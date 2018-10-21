package com.my6225.fall2018.courseservice.datamodel;

import java.util.HashMap;

public class ProfessorDB {
	
	private static HashMap<Long, Professor> professorDB;

	public static HashMap<Long, Professor> getDB() {
		if (professorDB == null) {
			professorDB = new HashMap<>();
		}
		return professorDB;
	}

}
