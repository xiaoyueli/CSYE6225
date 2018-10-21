package com.my6225.fall2018.courseservice.datamodel;

import java.util.Date;

public class Professor {
	
	private String firstName;
	private String department;
	private Date startDate;
	private long professorID;
	
	public Professor() {
		
	}
	
	public Professor(String firstName, String department, Date startDate, long id) {
		super();
		this.firstName = firstName;
		this.department = department;
		this.startDate = startDate;
		this.professorID = id;
	}
	
	public Professor(String firstName, String department, Date startDate) {
		super();
		this.firstName = firstName;
		this.department = department;
		this.startDate = startDate;
	}
	
	public Professor(String firstName, String department) {
		super();
		this.firstName = firstName;
		this.department = department;
		this.startDate = new Date();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public long getProfessorID() {
		return professorID;
	}

	public void setProfessorID(long professorId) {
		this.professorID = professorId;
	}
	
	@Override
	public String toString() {
		return "ProfesserID=" + getProfessorID() + ", FirstName=" + getFirstName() + " ,Department=" + getDepartment();
	}
	
	
	

}
