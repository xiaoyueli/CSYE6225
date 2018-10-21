package com.my6225.fall2018.courseservice.datamodel;

import java.util.HashMap;

public class ProgramDB {
	
	private static HashMap<Long, Program> programDB;
	private static long availableID;

	public ProgramDB() {
		// TODO Auto-generated constructor stub
		programDB = new HashMap<>();
		availableID = 1;
	}
	
	public static HashMap<Long, Program> getInstance() {
		if (programDB == null) {
			programDB = new HashMap<>();
			availableID = 1;
			
		}
		return programDB;
	}
	
	public static long getNextID() {
		return availableID;
	}
	
	public static void increaseID() {
		availableID++;
	}

}
