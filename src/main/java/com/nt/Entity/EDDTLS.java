package com.nt.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class EDDTLS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edId;
	private String planName;
	private String planStatus;
	private String eligstartDate;
	private String eligEndDate;
	private Double benefitAmt;
	private String denialReason;
	
	
	@ManyToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;
	
	@OneToOne(mappedBy = "edId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private CoNotices coNotices;

	public Integer getEdId() {
		return edId;
	}

	public void setEdId(Integer edId) {
		this.edId = edId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getEligstartDate() {
		return eligstartDate;
	}

	public void setEligstartDate(String eligstartDate) {
		this.eligstartDate = eligstartDate;
	}

	public String getEligEndDate() {
		return eligEndDate;
	}

	public void setEligEndDate(String eligEndDate) {
		this.eligEndDate = eligEndDate;
	}

	public Double getBenefitAmt() {
		return benefitAmt;
	}

	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public ApplicationEntity getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}

	public CoNotices getCoNotices() {
		return coNotices;
	}

	public void setCoNotices(CoNotices coNotices) {
		this.coNotices = coNotices;
	}

	
	
	
	
}
