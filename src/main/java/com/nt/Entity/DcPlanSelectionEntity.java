package com.nt.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DcPlanSelectionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planSelectionId;
	
	@OneToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;
	
	@OneToOne(mappedBy = "selectedPlan",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private PlansEntity planSelectedDetails;

	public Integer getPlanSelectionId() {
		return planSelectionId;
	}

	public void setPlanSelectionId(Integer planSelectionId) {
		this.planSelectionId = planSelectionId;
	}

	public ApplicationEntity getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}

	public PlansEntity getPlanSelectedDetails() {
		return planSelectedDetails;
	}

	public void setPlanSelectedDetails(PlansEntity planSelectedDetails) {
		this.planSelectedDetails = planSelectedDetails;
	}

	
	
	
	
}
