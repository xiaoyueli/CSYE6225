package com.my6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.my6225.fall2018.courseservice.datamodel.Board;
import com.my6225.fall2018.courseservice.datamodel.DynamoDBConnector;

public class BoardService {
	
	static DynamoDBConnector dynamoDB;
	DynamoDBMapper mapper;
	static int availableID = 0;
	
	public BoardService() {
		dynamoDB = new DynamoDBConnector();
		dynamoDB.init();
		mapper = new DynamoDBMapper(dynamoDB.getClient());
	}
	

	public List<Board> getAllBoards() {
		PaginatedScanList<Board> ls = mapper.scan(Board.class, new DynamoDBScanExpression());
		List<Board> ans = new ArrayList<>();
		for (Board s: ls) {
			ans.add(s);
		}
		return ans;
	}
	
	
	public Board addBoard(Board board) {
		board.setBoardID(++availableID);
		mapper.save(board);
		return board;
	}
	
	public Board getBoardById(String id) {
		Board board = mapper.load(Board.class, id);
		return board;
	}
	
	
	public Board updateBoardInformation(String id, Board board) {
		Board old = getBoardById(id);
		if (old == null) return null;
		board.setId(id);
		board.setBoardID(old.getBoardID());
		mapper.save(board);
		return board;
	}
	
	public Board deleteBoardById(String id) {
		Board board = getBoardById(id);
		if (board == null) return null;
		mapper.delete(board);
		return board;
	}

}
