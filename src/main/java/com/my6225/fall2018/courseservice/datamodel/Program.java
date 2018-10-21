package com.my6225.fall2018.courseservice.datamodel;

import java.util.HashMap;

public class Program {
	
	private String program;
	private long programID;
	private HashMap<Long, Course> courses;

	public Program() {
		// TODO Auto-generated constructor stub
		courses = new HashMap<>();
	}
	
	public Program(String program, long id) {
		this.program = program;
		this.programID = id;
		courses = new HashMap<>();
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public long getProgramID() {
		return programID;
	}

	public void setProgramID(long programID) {
		this.programID = programID;
	}
	
	public int getCourseSize() {
		return courses.size();
	}

	public HashMap<Long, Course> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<Long, Course> courses) {
		this.courses = courses;
	}
	
	

}
