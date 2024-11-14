package com.nt.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Binding.CreatePlanBind;
import com.nt.Constant.AppConstant;
import com.nt.Services.PlanService;

@RestController
public class PlanRestController {

	Logger logger=LoggerFactory.getLogger(PlanRestController.class);
	
	@Autowired
	private PlanService planService;
	
	@PostMapping("cre_plan")
	public ResponseEntity<String> createPlan(@RequestBody CreatePlanBind bind){
		logger.debug("Plan Creation Process Started");
		boolean result =planService.createPlan(bind);
		if(result) {
			logger.info("Plan Creation Successfully..");
		return new ResponseEntity<>(AppConstant.PLAN_CREATION, HttpStatus.CREATED);
		}
		logger.info("Plan Creation Failed..");
		logger.debug("Plan Creation Process Started");
		return new ResponseEntity<>(AppConstant.PLAN_CREATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("plans")
	public ResponseEntity<List<CreatePlanBind>> viewPlans(CreatePlanBind bind){
		logger.debug("View All Plans Process Started..");
		logger.info("View All Plans..");
		List<CreatePlanBind> plans=planService.viewPlans();
		logger.debug("View All Plans Process End..");
		return new ResponseEntity<>(plans,HttpStatus.OK );
	}
	
	@GetMapping("plan/{id}")
	public ResponseEntity<CreatePlanBind> getPlan(@PathVariable("id") Integer id){
		logger.debug("View Plans Process Started..");
		CreatePlanBind bind=planService.getPlanById(id);
		logger.info("View Plan Success..");
		logger.debug("View Plans Process Started..");
		return new ResponseEntity<>(bind, HttpStatus.OK);
	}
	
	@PutMapping("plansw/{id}")
	public ResponseEntity<List<CreatePlanBind>> chnageSwStatus(@PathVariable("id") Integer id){
		planService.changePlanStatus(id);
		List<CreatePlanBind> bind=planService.viewPlans();
		logger.info("Plan Changed Status Changed");
		logger.debug("Plan Changed Process Started..");
		return new ResponseEntity<>(bind, HttpStatus.OK);
	}
}
