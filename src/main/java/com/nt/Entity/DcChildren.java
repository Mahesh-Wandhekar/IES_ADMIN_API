package com.nt.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class DcChildren {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childId;
	private String name;
	private String dob;
	private String ssn;
	
	@ManyToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ApplicationEntity getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}

	
	
}
