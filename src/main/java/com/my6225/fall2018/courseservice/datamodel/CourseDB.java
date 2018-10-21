package com.my6225.fall2018.courseservice.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseDB {
	
	private static HashMap<Long, Course> db = new HashMap<>();
	private static long availableID = 1;

	public CourseDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static long getNextID() {
		return availableID++;
	}
	
	public static void put(long id, Course course) {
		db.put(id, course);
	}
	
	public static Course get(long id) {
		if (db.containsKey(id)) {
			return db.get(id);
		}
		return null;
	}
	
	public static Course remove(long id) {
		return db.remove(id);
	}
	
	public static List<Course> getAllCourses() {
		List<Course> ls = new ArrayList<>();
		ls.addAll(db.values());
		return ls;
	}

}
