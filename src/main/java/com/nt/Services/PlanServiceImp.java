package com.nt.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.Binding.CreatePlanBind;
import com.nt.Constant.AppConstant;
import com.nt.Entity.PlansEntity;
import com.nt.Repository.IESPlansRepo;


@Service
public class PlanServiceImp  implements PlanService{

	@Autowired
	private IESPlansRepo plansRepo;
	
	@Override
	public boolean createPlan( CreatePlanBind createPlanBind) {
		PlansEntity entity=new PlansEntity();
		BeanUtils.copyProperties(createPlanBind, entity);
		entity.setActiveSwitch(AppConstant.ACC_SWITCH_ACTIVE);
		plansRepo.save(entity);
		return true;
	}
	
	 @Override
	public String changePlanStatus(Integer planId) {
		Optional<PlansEntity> optional=plansRepo.findById(planId);
		
		if(optional.isPresent()) {
			PlansEntity entity=optional.get();
			if(AppConstant.ACC_SWITCH_ACTIVE.equals(entity.getActiveSwitch())) {
				entity.setActiveSwitch(AppConstant.ACC_SWITCH_INACTIVE);
				plansRepo.save(entity);
				return AppConstant.ACCOUNT_SW_INACTIVE;
			}
			if(AppConstant.ACC_SWITCH_INACTIVE.equals(entity.getActiveSwitch())) {
				entity.setActiveSwitch(AppConstant.ACC_SWITCH_ACTIVE);
				plansRepo.save(entity);
				return AppConstant.ACCOUNT_SW_ACTIVE;
			}
			
			
		}
		 return null;
	}
	 
	 @Override
	public CreatePlanBind getPlanById(Integer id) {
		Optional<PlansEntity> entity=plansRepo.findById(id);
		if(entity.isPresent()) {
			PlansEntity plansEntity=entity.get();
			CreatePlanBind bind=new CreatePlanBind();
			BeanUtils.copyProperties(plansEntity, bind);
			
			return bind;
		}
		 
		 
		return null;
	}
	 
	 @Override
	public List<CreatePlanBind> viewPlans() {
		List<PlansEntity> entitys=plansRepo.findAll();
		List<CreatePlanBind>createPlanBinds=new ArrayList<>();
		for(PlansEntity entity:entitys) {
			CreatePlanBind bind=new CreatePlanBind();
			BeanUtils.copyProperties(entity, bind);
			createPlanBinds.add(bind);
		}
		
		return createPlanBinds;
	}
	
}
