package com.nt.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UnlockAccountBind;
import com.nt.Constant.AppConstant;
import com.nt.Entity.IESUsersEntity;
import com.nt.Repository.IESUserRepo;
import com.nt.Utility.EmailSender;
import com.nt.Utility.EncodePwdDecodePwd;
import com.nt.Utility.PwdGenerated;


public class AccountServiceImp implements AccountService {

	
	
	@Autowired
	private IESUserRepo iesUserRepo;

	@Autowired
	private EmailSender emailSender;

	@Override
	public boolean createUser(CreateUserBind createUserBind) {
		IESUsersEntity optional=iesUserRepo.findByEmail(createUserBind.getEmail());
		if(null!=optional) {
			return false;
		}
		
		IESUsersEntity entity = new IESUsersEntity();
		BeanUtils.copyProperties(createUserBind, entity);
		entity.setPassword(PwdGenerated.pwdGenerator());
		
		entity.setRole(createUserBind.getRole());
		entity.setAccountStatus(AppConstant.ACC_LOCK);
		entity.setActiveSwitch(AppConstant.ACC_SWITCH_ACTIVE);
		iesUserRepo.save(entity);

		String subject = AppConstant.EMAIL_SUB;
		String to = entity.getEmail();
		StringBuilder body = new StringBuilder("");
		body.append("<h1>Welcome to IES family, your registration is almost completed. </h1>");
		body.append("<h3>User The Below Temporary Password To Unlock Your Account</h3>");
		body.append(" Temporary Password :  " + entity.getPassword());
		body.append("<br>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + "\">Click Here to Unlock Your Account</a>");
		return emailSender.sendEmail(to, body.toString(), subject);
	}

	@Override
	public CreateUserBind getUserById(Integer id) {
		Optional<IESUsersEntity> optional = iesUserRepo.findById(id);
		if (optional.isPresent()) {
			IESUsersEntity entity = optional.get();
			CreateUserBind user = new CreateUserBind();
			BeanUtils.copyProperties(entity, user);
			return user;
		}
		return null;
	}

	@Override
	public String changeAccStatus(Integer id) {
		Optional<IESUsersEntity> optional=iesUserRepo.findById(id);
		if(optional.isPresent()) {
			IESUsersEntity entity=optional.get();
			if(AppConstant.ACC_SWITCH_ACTIVE.equals(entity.getActiveSwitch())) {
				entity.setActiveSwitch(AppConstant.ACC_SWITCH_INACTIVE);
				iesUserRepo.save(entity);
				return AppConstant.ACCOUNT_SW_INACTIVE;
			}
			if(AppConstant.ACC_SWITCH_INACTIVE.equals(entity.getActiveSwitch())) {
				entity.setActiveSwitch(AppConstant.ACC_SWITCH_ACTIVE);
				iesUserRepo.save(entity);
				return AppConstant.ACCOUNT_SW_ACTIVE;
			}
			
			
		}
		
		return AppConstant.PLAN_STATUS_FAILED;
	}

	@Override
	public String unlockAcc(UnlockAccountBind unlockBind) {
		if (unlockBind.getNewPwd().equals(unlockBind.getConfirmPwd())) {
			IESUsersEntity entity = iesUserRepo.findByEmail(unlockBind.getEmail());
			entity.setPassword(EncodePwdDecodePwd.encode(unlockBind.getNewPwd()));
			entity.setAccountStatus(AppConstant.ACC_UNLOCK);
			iesUserRepo.save(entity);
			return AppConstant.ACCOUNT_UNLOCKED_STAGE;
		}
		return AppConstant.ACCOUNT_LOCKED_STAGE;
	}

	@Override
	public List<CreateUserBind> viewUsers() {
		List<IESUsersEntity> entity = iesUserRepo.findAll();
		List<CreateUserBind> bind = new ArrayList<>();
		for (IESUsersEntity usersEntity : entity) {
			CreateUserBind userbind = new CreateUserBind();
			BeanUtils.copyProperties(usersEntity, userbind);
			bind.add(userbind);
		}
		return bind;

	}

}
