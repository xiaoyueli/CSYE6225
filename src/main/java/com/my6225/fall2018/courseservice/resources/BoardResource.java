package com.my6225.fall2018.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.my6225.fall2018.courseservice.datamodel.Board;
import com.my6225.fall2018.courseservice.service.BoardService;

@Path("boards")
public class BoardResource {
	
	BoardService service = new BoardService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Board> getBoards() {
		return service.getAllBoards();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Board getBoardById(@PathParam("id") String id) {
		return service.getBoardById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board addBoard(Board board) {
		return service.addBoard(board);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board updateBoardInformation(@PathParam("id") String id, Board board) {
		return service.updateBoardInformation(id, board);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Board deleteBoardById(@PathParam("id") String id) {
		return service.deleteBoardById(id);
	}
}
