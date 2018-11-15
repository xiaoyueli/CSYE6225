package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.my6225.fall2018.courseservice.datamodel.Course;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;

public class CourseService {

	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;
	static int availableID = 0;

	public CourseService() {
		// TODO Auto-generated constructor stub
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	
	
	public Course getCourseById(String id) {
		Course std = mapper.load(Course.class, id);
		return std;
	}
	
	public List<Course> getAllCourses() {
		PaginatedScanList<Course> ls = mapper.scan(Course.class, new DynamoDBScanExpression());
		List<Course> ans = new ArrayList<>();
		for (Course s: ls) {
			ans.add(s);
		}
		return ans;
	}
	
	public Course addCourse(Course cos) {
		cos.setCourseID(++availableID);
		cos.setRoster(new ArrayList<String>());
		mapper.save(cos);
		return cos;
	}
	
	public Course updateCourse(String id, Course cos) {
		Course old = getCourseById(id);
		if (old == null) return null;
		cos.setId(id);
		cos.setCourseID(old.getCourseID());
		mapper.save(cos);
		return cos;
	}
	
	public Course deleteCourse(String id) {
		Course cos = getCourseById(id);
		if (cos == null) return null;
		mapper.delete(cos);
		return cos;
	}
	
	public Course addStudentID(String courseID, String stdID) {
		Course cos = getCourseById(courseID);
		if (cos == null) return null;
		cos.getRoster().add(stdID);
		mapper.save(cos);
		return cos;
	}
	
	
}
