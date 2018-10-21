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

import com.my6225.fall2018.courseservice.datamodel.Course;
import com.my6225.fall2018.courseservice.datamodel.Program;
import com.my6225.fall2018.courseservice.service.CourseService;
import com.my6225.fall2018.courseservice.service.ProgramService;

@Path("programs")
public class ProgramResourse {

	private ProgramService service;
	private CourseService courseService;
	public ProgramResourse() {
		// TODO Auto-generated constructor stub
		service = new ProgramService();
		courseService = new CourseService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Program> getProfessors() {
		return service.getAllProgram();
	}
	
	@GET
	@Path("/{programID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProfessorById(@PathParam("programID") int id) {
		return service.getProgramByID(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addProgram(Program program) {
		return service.addProgram(program);
	}
	
	@PUT
	@Path("/{programID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program updateProgramInformation(@PathParam("programID") long id, Program program) {
		return service.modifyProgram(id, program);
	}
	
	@DELETE
	@Path("/{programID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program deleteProgramByID(@PathParam("programID") long id) {
		return service.deleteProgramByID(id);
	}
	
	@POST
	@Path("/{programID}/addcourse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(@PathParam("programID") long id, Course course) {
		course = courseService.addCourse(course);
		return service.addCourse(id, course);
	}

}
