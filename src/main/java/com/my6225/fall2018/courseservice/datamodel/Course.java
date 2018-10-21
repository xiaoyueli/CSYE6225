package com.my6225.fall2018.courseservice.datamodel;

import java.util.HashMap;

public class Course {
	
	private String courseName;
	private long courseID;
	private Professor prof;
	private Student TA;
	private HashMap<String, Lecture> lectures;
	private HashMap<Long, Student> enrolledStudents;
	private Board board;
	private Roster roster;

	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(String courseName, long courseID) {
		this.courseName = courseName;
		this.courseID = courseID;
		lectures = new HashMap<>();
		enrolledStudents = new HashMap<>();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Student getTA() {
		return TA;
	}

	public void setTA(Student tA) {
		TA = tA;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public HashMap<String, Lecture> getLectures() {
		if (lectures == null) {
			lectures = new HashMap<>();
		}
		return lectures;
	}

	public void setLectures(HashMap<String, Lecture> lectures) {
		this.lectures = lectures;
	}

	public HashMap<Long, Student> getEnrolledStudents() {
		if (enrolledStudents == null) {
			enrolledStudents = new HashMap<>();
		}
		return enrolledStudents;
	}

	public void setEnrolledStudents(HashMap<Long, Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	
	
	
	
	

}
