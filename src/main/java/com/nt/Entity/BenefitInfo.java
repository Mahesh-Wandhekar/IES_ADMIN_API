package com.nt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Entity
public class BenefitInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer benefitID;
	private String benefitMouthYear;
	private String benefitAmt;
	private String transactionDate;
	private String transactionStatus;
	
	
	@OneToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;


	public Integer getBenefitID() {
		return benefitID;
	}


	public void setBenefitID(Integer benefitID) {
		this.benefitID = benefitID;
	}


	public String getBenefitMouthYear() {
		return benefitMouthYear;
	}


	public void setBenefitMouthYear(String benefitMouthYear) {
		this.benefitMouthYear = benefitMouthYear;
	}


	public String getBenefitAmt() {
		return benefitAmt;
	}


	public void setBenefitAmt(String benefitAmt) {
		this.benefitAmt = benefitAmt;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}


	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public ApplicationEntity getCaseNum() {
		return caseNum;
	}


	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}


	
	
}
