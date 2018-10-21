package com.my6225.fall2018.courseservice.datamodel;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBConnector {
	
	static AmazonDynamoDB dynamoDB;

	public DynamoDBConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public static void init() {
		if (dynamoDB == null) {
			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
			credentialsProvider.getCredentials();
			dynamoDB = AmazonDynamoDBClientBuilder
					.standard()
					.withCredentials(credentialsProvider)
					.withRegion("us-east-2")
					.build();
		}
	}
	
	public AmazonDynamoDB getClient() {
		return dynamoDB;
	}
}
