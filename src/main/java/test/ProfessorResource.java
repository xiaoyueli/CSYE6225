package test;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("professors")
public class ProfessorResource {
	
	ProfessorsService prof_service = new ProfessorsService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {
		addProfessor("Tom", "IS", new Date());
		addProfessor("Jary", "IS", new Date());
		return prof_service.getAllProfessors();
	}
	
	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessor(@PathParam("professorId") long profId) {
		return prof_service.getProfessor(profId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor addProfessor(Professor prof) {
		return prof_service.addProfessor(prof);
	}
	
	public void addProfessor(String name, String dep, Date joiningDate) {
		prof_service.addProfessor(name, dep, joiningDate);
	}
//	
//	@PUT
//	@Path("/{professorId}")
//	@Produces(MediaType.APPLICATION_XML)
//	@Consumes(MediaType.APPLICATION_XML)
//	public Professor updateProfessorInformation(long profId, Professor prof) {
//		return prof_service.updateProfessorInformation(profId, prof);
//	}
}
