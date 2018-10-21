package com.my6225.fall2018.courseservice.service;

import java.util.List;

import com.my6225.fall2018.courseservice.datamodel.Lecture;
import com.my6225.fall2018.courseservice.datamodel.LectureDB;

public class LectureService {
	
	private static LectureDB db;

	public LectureService() {
		// TODO Auto-generated constructor stub
		db = new LectureDB();
	}
	
	public Lecture addLecture(Lecture lecture) {
		return db.addLecture(lecture);
	}
	
	public Lecture deleteLecture(String title) {
		return db.deleteLecture(title);
	}
	
	public List<Lecture> getAllLectures(){
		return db.getAllLectures();
	}
	
	public Lecture getLecture(String title) {
		return db.getLecture(title);
	}

}
