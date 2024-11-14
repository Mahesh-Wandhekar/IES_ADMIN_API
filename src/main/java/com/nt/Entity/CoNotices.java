package com.nt.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CoNotices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noticeId;
	
	private String coPdfUrl;
	private String printDate;
	private String noticeStatus;
	@CreationTimestamp
	private LocalDate createdDate;
	
	@OneToOne
	@JoinColumn(name="edId")
	private EDDTLS edId;
	
	@ManyToOne
	@JoinColumn(name="caseNum")
	private ApplicationEntity caseNum;

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getCoPdfUrl() {
		return coPdfUrl;
	}

	public void setCoPdfUrl(String coPdfUrl) {
		this.coPdfUrl = coPdfUrl;
	}

	public String getPrintDate() {
		return printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}


	public EDDTLS getEdId() {
		return edId;
	}

	public void setEdId(EDDTLS edId) {
		this.edId = edId;
	}

	public ApplicationEntity getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(ApplicationEntity caseNum) {
		this.caseNum = caseNum;
	}
	
	
	
	
	
}
