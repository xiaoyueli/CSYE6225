package com.my6225.fall2018.courseservice.service;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.my6225.fall2018.courseservice.datamodel.Student;

public class StudentService {
	
	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;

	public StudentService() {
		// TODO Auto-generated constructor stub
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	
	
	public Student getStudentById(Long stdID) {
		Student std = mapper.load(Student.class, stdID);
		System.out.println(std.toString());
		return std;
	}
	

}
