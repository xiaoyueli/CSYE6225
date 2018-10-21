package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProfessorsService {
	
	static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();
	
	// Getting a list of all professor
	// GET webapi/professors
	public List<Professor> getAllProfessors() {
		List<Professor> ls = new ArrayList<>();
		ls.addAll(prof_Map.values());
		return ls;
	}
	
	public void addProfessor(String name, String dep, Date joiningDate) {
		long nextAvailableId = prof_Map.size() + 1;
		
		Professor prof = new Professor(name, dep, joiningDate, nextAvailableId);
		prof_Map.put(nextAvailableId, prof);
	}
	
	public Professor addProfessor(Professor prof) {
		long nextAvailableId = prof_Map.size() + 1;
		prof.setProfessorId(nextAvailableId);
		prof_Map.put(nextAvailableId, prof);
		return prof;
	}
	
	public Professor getProfessor(long profId) {
		return prof_Map.get(profId);
	}
	
	
	public Professor updateProfessorInformation(long profId, Professor prof) {
		prof.setProfessorId(profId);
		prof_Map.put(profId, prof);
		return prof;
	}

}
