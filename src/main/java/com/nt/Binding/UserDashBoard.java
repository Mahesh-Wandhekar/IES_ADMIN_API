package com.nt.Binding;

import org.springframework.stereotype.Component;

@Component
public class UserDashBoard {

	private Long totalPlan;
	
	private Long citizanApprovedPlans;
	
	private Long citizenDeniedPlans;
	
	private Double benefits;
	
	private CreateUserBind userBind;

	public Long getTotalPlan() {
		return totalPlan;
	}

	public void setTotalPlan(Long totalPlan) {
		this.totalPlan = totalPlan;
	}

	public Long getCitizanApprovedPlans() {
		return citizanApprovedPlans;
	}

	public void setCitizanApprovedPlans(Long citizanApprovedPlans) {
		this.citizanApprovedPlans = citizanApprovedPlans;
	}

	public Long getCitizenDeniedPlans() {
		return citizenDeniedPlans;
	}

	public void setCitizenDeniedPlans(Long citizenDeniedPlans) {
		this.citizenDeniedPlans = citizenDeniedPlans;
	}

	public Double getBenefits() {
		return benefits;
	}

	public void setBenefits(Double benefits) {
		this.benefits = benefits;
	}

	public CreateUserBind getUserBind() {
		return userBind;
	}

	public void setUserBind(CreateUserBind userBind) {
		this.userBind = userBind;
	}
	
	
	
	


	
	
	
}
