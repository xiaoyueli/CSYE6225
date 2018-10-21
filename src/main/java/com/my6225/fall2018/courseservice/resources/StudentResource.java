package com.my6225.fall2018.courseservice.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.my6225.fall2018.courseservice.datamodel.Student;
import com.my6225.fall2018.courseservice.service.StudentService;

@Path("students")
public class StudentResource {

	StudentService service = new StudentService();
	public StudentResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET
	@Path("/{studentID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("studentID") long id) {
		return service.getStudentById(id);
	}

}
