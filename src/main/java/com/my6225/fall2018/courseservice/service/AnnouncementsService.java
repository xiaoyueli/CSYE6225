package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.PathParam;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.my6225.fall2018.courseservice.datamodel.Announcements;
import com.my6225.fall2018.courseservice.datamodel.Board;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.my6225.fall2018.courseservice.datamodel.Professor;

public class AnnouncementsService {
	
	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;
	static int availableID = 0;
	
	public AnnouncementsService() {
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	

	public List<Announcements> getAllAnnouncements() {
		PaginatedScanList<Announcements> ls = mapper.scan(Announcements.class, new DynamoDBScanExpression());
		List<Announcements> ans = new ArrayList<>();
		for (Announcements s: ls) {
			ans.add(s);
		}
		return ans;
	}
	
	
	public Announcements addAnnouncements(Announcements announcements) {
		announcements.setAnnouncementID(++availableID);
		mapper.save(announcements);
		return announcements;
	}
	
	public Announcements getAnnouncementsById(String id) {
		Announcements announcements = mapper.load(Announcements.class, id);
		return announcements;
	}
	
	
	public Announcements updateAnnouncementsInformation(String id, Announcements announcements) {
		Announcements old = getAnnouncementsById(id);
		if (old == null) return null;
		announcements.setId(id);
		announcements.setAnnouncementID(old.getAnnouncementID());
		mapper.save(announcements);
		return announcements;
	}
	
	public Announcements deleteAnnouncementsById(String id) {
		Announcements announcements = getAnnouncementsById(id);
		if (announcements == null) return null;
		mapper.delete(announcements);
		return announcements;
	}

}
