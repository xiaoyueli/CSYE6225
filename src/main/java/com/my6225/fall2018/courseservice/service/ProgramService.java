package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.my6225.fall2018.courseservice.datamodel.Course;
import com.my6225.fall2018.courseservice.datamodel.Program;
import com.my6225.fall2018.courseservice.datamodel.ProgramDB;

public class ProgramService {
	
	private static HashMap<Long, Program> db;

	public ProgramService() {
		// TODO Auto-generated constructor stub
		db = ProgramDB.getInstance();
	}
	
	public List<Program> getAllProgram() {
		List<Program> ls = new ArrayList<>();
		ls.addAll(db.values());
		return ls;
		
	}
	
	public Program addProgram(Program program) {
		long id = ProgramDB.getNextID();
		ProgramDB.increaseID();
		program.setProgramID(id);
		program.setCourses(new HashMap<Long, Course>());
		db.put(id, program);
		return program;
	}
	
	public Program getProgramByID(long id) {
		if (db.containsKey(id)) {
			Program pro = db.get(id);
			return pro;
		}
		return null;
	}
	
	public Program modifyProgram(long id, Program program) {
		program.setProgramID(id);
		db.put(id, program);
		return program;
	}
	
	public Program deleteProgramByID(long id) {
		if (db.containsKey(id)) {
			Program pro = db.remove(id);
			return pro;
		}
		return null;
	}
	
	public Course addCourse(long programID, Course course) {
		if (db.containsKey(programID)) {
			Program program = db.get(programID);
			program.getCourses().put(course.getCourseID(), course);
			return course;
		}
		return null;
  	}
}
