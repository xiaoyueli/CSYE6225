package com.my6225.fall2018.courseservice.datamodel;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="studentDB")
public class Student {
	
	private String id;
	private String firstName;
	private String lastName;
	private int studentID;
	private Date joiningDate;
	private String department;
	private List<String> registeredCourses;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
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

	@DynamoDBHashKey(attributeName="id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "studentID")
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@DynamoDBAttribute(attributeName="joiningDate")
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	@DynamoDBAttribute(attributeName="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@DynamoDBAttribute(attributeName="registeredCourses")
	public List<String> getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(List<String> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() {
		return "StudentID=" + getStudentID() + ", FirstName=" + getFirstName() + " , LastName=" + getLastName();
	}

}
