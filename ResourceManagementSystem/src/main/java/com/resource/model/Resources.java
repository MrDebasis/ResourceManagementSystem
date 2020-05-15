package com.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Resources {

	@Column(name = "country")
	private String country;

	@Column(name = "globalGroupID")
	private String globalGroupID;

	@Id
	@Column(name = "employeeId")
	private String employeeId;

	@Column(name = "emailId")
	private String emailId;

	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "localGrade")
	private String localGrade;

	@Column(name = "leaveApplied")
	private String leaveApplied;

	@Column(name = "status")
	private String status;

	@Column(name = "grade")
	private String grade;

	@Column(name = "type")
	private String type;

	@Column(name = "officeCity")
	private String officeCity;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOfficeCity() {
		return officeCity;
	}
	public void setOfficeCity(String officeCity) {
		this.officeCity = officeCity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGlobalGroupID() {
		return globalGroupID;
	}
	public void setGlobalGroupID(String globalGroupID) {
		this.globalGroupID = globalGroupID;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocalGrade() {
		return localGrade;
	}
	public void setLocalGrade(String localGrade) {
		this.localGrade = localGrade;
	}
	public String getLeaveApplied() {
		return leaveApplied;
	}
	public void setLeaveApplied(String leaveApplied) {
		this.leaveApplied = leaveApplied;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Resources [country=" + country + ", globalGroupID=" + globalGroupID + ", employeeId=" + employeeId
				+ ", emailId=" + emailId + ", password=" + password + ", name=" + name + ", mentorname=" 
				+ ", localGrade=" + localGrade + ", leaveApplied=" + leaveApplied + ", leaveGreaterthan5days="
				+ ", status=" + status + ", updatesRemarks="  + ", grade="
				+ grade + ", mainBookingType="  + ", type=" + type + ", officeCity=" + officeCity
				+ "]";
	}

}
