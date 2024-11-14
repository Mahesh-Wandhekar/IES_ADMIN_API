package com.nt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DcEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eductaionId;
	private String highestDegree;
	private String graduationYear;
	private String unversity;
	@OneToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;
	public Integer getEductaionId() {
		return eductaionId;
	}
	public void setEductaionId(Integer eductaionId) {
		this.eductaionId = eductaionId;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getUnversity() {
		return unversity;
	}
	public void setUnversity(String unversity) {
		this.unversity = unversity;
	}
	public ApplicationEntity getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}
	
	
	
	
	
	
}
