package com.my6225.fall2018.courseservice.datamodel;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="professorDB")
public class Professor {
	
	private String firstName;
	private String lastName;
	private String department;
	private String id;
	private Date joiningDate;
	private long professorId;

	public Professor() {
		
	}
	
	public Professor(String firstName, String lastName, String department, String id, Date joiningDate,
			long professorId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.id = id;
		this.joiningDate = joiningDate;
		this.professorId = professorId;
	}

	@DynamoDBAttribute(attributeName="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@DynamoDBAttribute(attributeName="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@DynamoDBAttribute(attributeName="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBHashKey(attributeName="id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName="joiningDate")
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "professorId")
	public long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	@Override
	public String toString() {
		return "ProfesserID=" + getProfessorId() + ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + " ,Department=" + getDepartment();
	}

}
