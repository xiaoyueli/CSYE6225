package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.my6225.fall2018.courseservice.datamodel.Professor;

public class ProfessorService {
	
	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;
	static int availableID = 0;
	
	public ProfessorService() {
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	
	// Getting a list of all professor
	// GET webapi/professors
	public List<Professor> getAllProfessors() {
		PaginatedScanList<Professor> ls = mapper.scan(Professor.class, new DynamoDBScanExpression());
		List<Professor> ans = new ArrayList<>();
		for (Professor s: ls) {
			ans.add(s);
		}
		return ans;
	}
	
	
	public Professor addProfessor(Professor prof) {
		prof.setJoiningDate(new Date());
		prof.setProfessorId(++availableID);
		mapper.save(prof);
		return prof;
	}
	
	public Professor getProfessorById(String id) {
		Professor prof = mapper.load(Professor.class, id);
		return prof;
	}
	
	
	public Professor updateProfessorInformation(String id, Professor prof) {
		Professor old = getProfessorById(id);
		if (old == null) return null;
		prof.setId(id);
		prof.setProfessorId(old.getProfessorId());
		prof.setJoiningDate(old.getJoiningDate());
		mapper.save(prof);
		return prof;
	}
	
	public Professor deleteProfessorById(String id) {
		Professor prof = getProfessorById(id);
		if (prof == null) return null;
		mapper.delete(prof);
		return prof;
	}

}
