package com.my6225.fall2018.courseservice.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class StudentDB {
	
	static AmazonDynamoDB dynamoDB;

	public StudentDB() {
		// TODO Auto-generated constructor stub
		
	}
	
	private static void init() throws Exception {
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		credentialsProvider.getCredentials();
		dynamoDB = AmazonDynamoDBClientBuilder
				.standard()
				.withCredentials(credentialsProvider)
				.withRegion("us-east-2")
				.build();
	}
	
	public static void main(String[] args) throws Exception {
		init();
		String tableName = "studentDB";
		
		GetItemRequest getItemRequest = new GetItemRequest();

		Map<String, AttributeValue> itemToFetch = new HashMap<>();
		itemToFetch.put("studentID", new AttributeValue().withN("1"));
		getItemRequest.setKey(itemToFetch);
		
		getItemRequest.setTableName("studentDB");
		
		GetItemResult getItemResult = dynamoDB.getItem(getItemRequest);
		System.out.println("GetItemResult:" + getItemResult);
		
		
	}

}
