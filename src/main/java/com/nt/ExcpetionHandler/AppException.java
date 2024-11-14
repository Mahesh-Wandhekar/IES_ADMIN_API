package com.nt.ExcpetionHandler;

import java.time.LocalDateTime;

public class AppException {

	
	private String excCode;
	private String excDesc;
	private LocalDateTime excDate;
	
	
	public String getExcCode() {
		return excCode;
	}
	public void setExcCode(String excCode) {
		this.excCode = excCode;
	}
	public String getExcDesc() {
		return excDesc;
	}
	public void setExcDesc(String excDesc) {
		this.excDesc = excDesc;
	}
	public LocalDateTime getExcDate() {
		return excDate;
	}
	public void setExcDate(LocalDateTime excDate) {
		this.excDate = excDate;
	}
	
	
}
