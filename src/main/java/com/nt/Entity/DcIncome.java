package com.nt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DcIncome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	private Double salaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	@OneToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

	
	

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getRentIncome() {
		return rentIncome;
	}

	public void setRentIncome(Double rentIncome) {
		this.rentIncome = rentIncome;
	}

	public Double getPropertyIncome() {
		return propertyIncome;
	}

	public void setPropertyIncome(Double propertyIncome) {
		this.propertyIncome = propertyIncome;
	}

	public ApplicationEntity getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}

	
	
	
	
	
	
}
