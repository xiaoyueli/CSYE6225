package com.my6225.fall2018.courseservice.resources;

import java.util.Date;
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

import com.my6225.fall2018.courseservice.datamodel.Professor;
import com.my6225.fall2018.courseservice.service.ProfessorService;


@Path("professors")
public class ProfessorResource {
	
	ProfessorService service = new ProfessorService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {
		return service.getAllProfessors();
	}
	
	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessorById(@PathParam("professorId") int id) {
		return service.getProfessorById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor addProfessor(Professor prof) {
		return service.addProfessor(prof);
	}
	
	public void addProfessor(String name, String dep, Date joiningDate) {
		service.addProfessor(name, dep, joiningDate);
	}
	
	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor updateProfessorInformation(@PathParam("professorId") int profId, Professor prof) {
		return service.updateProfessorInformation(profId, prof);
	}
	
	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor deleteProfessorById(@PathParam("professorId") int profId) {
		return service.deleteProfessorById(profId);
	}
}