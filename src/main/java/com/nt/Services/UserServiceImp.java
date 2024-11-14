package com.nt.Services;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nt.Binding.CreateUserBind;
import com.nt.Binding.UserDashBoard;
import com.nt.Binding.UserLogin;
import com.nt.Constant.AppConstant;
import com.nt.Entity.EDDTLS;
import com.nt.Entity.IESUsersEntity;
import com.nt.Repository.EDDTLSRepo;
import com.nt.Repository.IESPlansRepo;
import com.nt.Repository.IESUserRepo;
import com.nt.Utility.EmailSender;
import com.nt.Utility.EncodePwdDecodePwd;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private IESUserRepo iesUserRepo;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private IESPlansRepo plansRepo;

	@Autowired
	private EDDTLSRepo repo;
	
	

	@Override
	public CreateUserBind getByEmail(String email) {
		IESUsersEntity entity = iesUserRepo.findByEmail(email);
		if (null == entity) {
			return null;
		}
		CreateUserBind bind = new CreateUserBind();
		BeanUtils.copyProperties(entity, bind);
		return bind;
	}

	@Override
	public String login(UserLogin userLogin) {
		
		IESUsersEntity entity = iesUserRepo.findByEmailAndPassword(userLogin.getEmail(), EncodePwdDecodePwd.encode(userLogin.getPassword()));
		if (null == entity) {
			return AppConstant.INVALID_CRE;
		}
		if (AppConstant.ACC_UNLOCK.equals(entity.getAccountStatus())) {
			if (AppConstant.ACC_SWITCH_ACTIVE.equals(entity.getActiveSwitch())) {
				return AppConstant.LOGIN_SUCCESS;
			} else {
				return AppConstant.ACCOUNT_IN_ACTIVE;
			}
		} else {
			return AppConstant.ACCOUNT_LOCKED_STAGE;
		}

	}

	@Override
	public UserDashBoard getDashboard() {
		Long noOFPlans = plansRepo.count();
		
		List<EDDTLS> entity = repo.findAll();
		
		Long approved = entity.stream().filter(e -> e.getPlanStatus().equals("APPROVED")).count();
		Long denied = entity.stream().filter(e -> e.getPlanStatus().equals("DENIED")).count();
		Double benefitAmt = entity.stream().mapToDouble(e -> e.getBenefitAmt()).sum();

		UserDashBoard board = new UserDashBoard();
		board.setTotalPlan(noOFPlans);
		board.setCitizanApprovedPlans(approved);
		board.setCitizenDeniedPlans(denied);
		board.setBenefits(benefitAmt);
		return board;
	}

	@Override
	public boolean recoverPwd(String email) {
		IESUsersEntity entity = iesUserRepo.findByEmail(email);
		if (null == entity) {
			return false;
		}
		
		
		String subject = AppConstant.RECOVVER_PWD_SUB;
		StringBuilder body = new StringBuilder("");
		body.append("<h1>Welcome to IES family.. </h1>");
		body.append("<h3>User The Below  Password To Login Your Account</h3>");
		body.append(" Password :  " + EncodePwdDecodePwd.decode(entity.getPassword()));
		body.append("<br>");

		return emailSender.sendEmail(email, body.toString(), subject);
	}
}
