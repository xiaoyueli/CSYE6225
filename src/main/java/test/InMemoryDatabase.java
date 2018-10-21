package test;

import java.util.HashMap;

public class InMemoryDatabase {
	
	private static HashMap<Long, Professor> professorDB = new HashMap<>();

	public static HashMap<Long, Professor> getProfessorDB() {
		return professorDB;
	}
	
}
