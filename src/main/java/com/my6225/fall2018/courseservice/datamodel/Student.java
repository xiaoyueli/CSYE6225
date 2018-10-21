package com.my6225.fall2018.courseservice.datamodel;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="studentDB")
public class Student {
	
	private String name;
	private long studentID;
//	private String image;
//	private List<String> enrolledCourse;
	private String program;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, long studentID, String program) {
		super();
		this.name = name;
		this.studentID = studentID;
		this.program = program;
	}

	@DynamoDBAttribute(attributeName="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBHashKey(attributeName="studentID")
	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

//	public List<String> getEnrolledCourse() {
//		return enrolledCourse;
//	}
//
//	public void setEnrolledCourse(List<String> enrolledCourse) {
//		this.enrolledCourse = enrolledCourse;
//	}

	@DynamoDBAttribute(attributeName="program")
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() {
		return "StudentID=" + getStudentID() + ", Name=" + getName() + " , Program=" + getProgram();
	}
	
	

}
