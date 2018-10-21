package com.my6225.fall2018.courseservice.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LectureDB {

	private static HashMap<String, Lecture> db = new HashMap<>();
	public LectureDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static Lecture addLecture(Lecture lecture) {
		db.put(lecture.getTitle(), lecture);
		return lecture;
	}
	
	public static Lecture deleteLecture(String title) {
		return db.remove(title);
	}
	
	public static List<Lecture> getAllLectures() {
		List<Lecture> ls = new ArrayList<>();
		ls.addAll(db.values());
		return ls;
	}
	
	public static Lecture getLecture(String title) {
		if (db.containsKey(title)) {
			return db.get(title);
		}
		return null;
	}

}
