package com.nt.Binding;



import org.springframework.stereotype.Component;



@Component
public class CreatePlanBind {

	private String planName;
	private String planStartDate;
	private String planEndDate;
	
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}
	public String getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}
	
	
	
	
}
