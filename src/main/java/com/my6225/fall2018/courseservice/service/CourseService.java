package com.my6225.fall2018.courseservice.service;

import java.util.List;

import com.my6225.fall2018.courseservice.datamodel.Course;
import com.my6225.fall2018.courseservice.datamodel.CourseDB;
import com.my6225.fall2018.courseservice.datamodel.Lecture;
import com.my6225.fall2018.courseservice.datamodel.Professor;


public class CourseService {

	private static CourseDB db;
	public CourseService() {
		// TODO Auto-generated constructor stub
		db = new CourseDB();
	}
	
	public Course addCourse(Course course) {
		long id = db.getNextID();
		course.setCourseID(id);
		db.put(id, course);
		return course;
	}
	
	public Course updateCourse(long id, Course course) {
		course.setCourseID(id);
		db.put(id, course);
		return course;
	}
	
	public Course getCourseByID(long id) {
		return db.get(id);
	}
	
	public List<Course> getAllCourses() {
		return db.getAllCourses();
	}
	
	public Course deleteCourseByID(long id) {
		return db.remove(id);
	}
	
	public Course addProfessor(long courseID, long professorID) {
		ProfessorService profService = new ProfessorService();
		Professor prof = profService.getProfessorById(professorID);
		Course course = getCourseByID(courseID);
		course.setProf(prof);
		return course;
	}
	
	public Course deleteProfessor(long courseID) {
		Course course = getCourseByID(courseID);
		course.setProf(null);
		return course;
	}
	
	public Course addLecture(long courseID, String lectureTitle) {
		LectureService lectureService = new LectureService();
		Lecture lecture = lectureService.getLecture(lectureTitle);
		Course course = getCourseByID(courseID);
		course.getLectures().put(lectureTitle, lecture);
		return course;
	}
	
	public Course deleteLecture(long courseID, String lectureTitle) {
		Course course = getCourseByID(courseID);
		course.getLectures().remove(lectureTitle);
		return course;
	}
	
	
}
