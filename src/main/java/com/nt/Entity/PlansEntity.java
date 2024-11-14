package com.nt.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class PlansEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	private String planName;
	private String planStartDate;
	private String planEndDate;
	private String activeSwitch;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private IESUsersEntity createdBy;
	
	private Integer updatedBy;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
    private LocalDate updatedDate;
	
	@OneToOne
	@JoinColumn(name="planSelectionId")
	private DcPlanSelectionEntity selectedPlan;

	
	
	
	
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

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

	public String getActiveSwitch() {
		return activeSwitch;
	}

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
	}

	public IESUsersEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(IESUsersEntity createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public DcPlanSelectionEntity getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(DcPlanSelectionEntity selectedPlan) {
		this.selectedPlan = selectedPlan;
	}
	
	
	
	
}
	

	