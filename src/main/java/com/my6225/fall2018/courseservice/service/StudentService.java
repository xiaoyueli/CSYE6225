package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.my6225.fall2018.courseservice.datamodel.Student;

public class StudentService {
	
	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;
	static int availableID = 0;

	public StudentService() {
		// TODO Auto-generated constructor stub
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	
	
	public Student getStudentById(String id) {
		Student std = mapper.load(Student.class, id);
		return std;
	}
	
	public List<Student> getAllStudents() {
		PaginatedScanList<Student> ls = mapper.scan(Student.class, new DynamoDBScanExpression());
		List<Student> ans = new ArrayList<>();
		for (Student s: ls) {
			ans.add(s);
		}
		return ans;
	}
	
	public Student addStudent(Student stu) {
		stu.setJoiningDate(new Date());
		stu.setStudentID(++availableID);
		stu.setRegisteredCourses(new ArrayList<String>());
		mapper.save(stu);
		return stu;
	}
	
	public Student updateStudent(String id, Student stu) {
		Student old = getStudentById(id);
		if (old == null) return null;
		stu.setId(id);
		stu.setStudentID(old.getStudentID());
		stu.setJoiningDate(old.getJoiningDate());
		stu.setRegisteredCourses(old.getRegisteredCourses());
		mapper.save(stu);
		return stu;
	}
	
	public Student deleteStudent(String id) {
		Student std = getStudentById(id);
		if (std == null) return null;
		mapper.delete(std);
		return std;
	}
	
	public Student addCourseID(String stdID, String courseID) {
		Student std = getStudentById(stdID);
		if (std == null) return null;
		std.getRegisteredCourses().add(courseID);
		mapper.save(std);
		return std;
	}
	

}
