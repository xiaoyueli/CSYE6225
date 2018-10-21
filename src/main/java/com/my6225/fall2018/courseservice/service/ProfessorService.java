package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.PathParam;

import com.my6225.fall2018.courseservice.datamodel.Professor;
import com.my6225.fall2018.courseservice.datamodel.ProfessorDB;


public class ProfessorService {
	
	static HashMap<Long, Professor> professorDB = ProfessorDB.getDB();
	
	// Getting a list of all professor
	// GET webapi/professors
	public List<Professor> getAllProfessors() {
		List<Professor> ls = new ArrayList<>();
		ls.addAll(professorDB.values());
		return ls;
	}
	
	public void addProfessor(String name, String department, Date joiningDate) {
		Professor prof = new Professor(name, department, joiningDate);
		addProfessor(prof);
	}
	
	public Professor addProfessor(Professor prof) {
		long id = professorDB.size() + 1;
		prof.setProfessorID(id);
		prof.setStartDate(new Date());
		professorDB.put(id, prof);
		return prof;
	}
	
	public Professor getProfessorById(long profId) {
		if (profId > professorDB.size()) {
			return null;
		}
		return professorDB.get(profId);
	}
	
	
	public Professor updateProfessorInformation(long profId, Professor prof) {
		if (profId > professorDB.size()) return null;
		prof.setProfessorID(profId);
		prof.setStartDate(new Date());
		professorDB.put(profId, prof);
		return prof;
	}
	
	public Professor deleteProfessorById(long profId) {
		Professor prof = null;
		prof = professorDB.remove(profId);
		return prof;
	}

}
