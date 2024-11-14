package com.nt.Entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ApplicationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseNum;
	private String fullName;
	private String email;
	private String dob;
	private String gender;
	private String ssn;
	private String stateName;
	private String cityName;
	private String houseName;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private IESUsersEntity createdByApps;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@OneToOne(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private DcPlanSelectionEntity planSelection;

	@OneToOne(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private DcIncome incomeDetails;
	
	@OneToOne(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private DcEducation educationDetails;
	
	@OneToMany(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<DcChildren> childernDetails;
	
	@OneToOne(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch =  FetchType.EAGER)
	private EDDTLS eligibleDetails;
	
	@OneToOne(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private BenefitInfo benefitDeteils;
	
	@OneToMany(mappedBy = "caseNum",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<CoNotices> noticesDetails;

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public IESUsersEntity getCreatedByApps() {
		return createdByApps;
	}

	public void setCreatedByApps(IESUsersEntity createdByApps) {
		this.createdByApps = createdByApps;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public DcPlanSelectionEntity getPlanSelection() {
		return planSelection;
	}

	public void setPlanSelection(DcPlanSelectionEntity planSelection) {
		this.planSelection = planSelection;
	}

	public DcIncome getIncomeDetails() {
		return incomeDetails;
	}

	public void setIncomeDetails(DcIncome incomeDetails) {
		this.incomeDetails = incomeDetails;
	}

	public DcEducation getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(DcEducation educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<DcChildren> getChildernDetails() {
		return childernDetails;
	}

	public void setChildernDetails(List<DcChildren> childernDetails) {
		this.childernDetails = childernDetails;
	}

	public EDDTLS getEligibleDetails() {
		return eligibleDetails;
	}

	public void setEligibleDetails(EDDTLS eligibleDetails) {
		this.eligibleDetails = eligibleDetails;
	}

	public BenefitInfo getBenefitDeteils() {
		return benefitDeteils;
	}

	public void setBenefitDeteils(BenefitInfo benefitDeteils) {
		this.benefitDeteils = benefitDeteils;
	}

	public List<CoNotices> getNoticesDetails() {
		return noticesDetails;
	}

	public void setNoticesDetails(List<CoNotices> noticesDetails) {
		this.noticesDetails = noticesDetails;
	}
	
	
}
