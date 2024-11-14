package com.nt.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.Binding.CreatePlanBind;

@Service
public interface PlanService {

	
	public boolean createPlan(CreatePlanBind createPlanBind);
	
	public CreatePlanBind getPlanById(Integer id);
	
	public String changePlanStatus(Integer planId);
	
	public List<CreatePlanBind> viewPlans();
	
	
}
