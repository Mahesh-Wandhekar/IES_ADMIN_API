package com.nt.Entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "IES_Users")
public class IESUsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    
    private String fname;
    
    private String email;
    
    private String password;
    
    private String phone;
    
    private String gender;
    
    private String dob;
    
    private String ssn;
    
    private String accountStatus; 
    
    private String activeSwitch;
    
    private String role;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdDate;
    
    @UpdateTimestamp
    private LocalDate updatedDate;
    
    private String createdBy;
    
    private String updatedBy;

    @OneToMany(mappedBy = "createdBy",cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    private List<PlansEntity> plans;
    
    @OneToMany(mappedBy ="createdByApps",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ApplicationEntity> citizenApps;
    
    

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getActiveSwitch() {
		return activeSwitch;
	}

	

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<PlansEntity> getPlans() {
		return plans;
	}

	public void setPlans(List<PlansEntity> plans) {
		this.plans = plans;
	}

	public List<ApplicationEntity> getCitizenApps() {
		return citizenApps;
	}

	public void setCitizenApps(List<ApplicationEntity> citizenApps) {
		this.citizenApps = citizenApps;
	}
    
    
    
}
