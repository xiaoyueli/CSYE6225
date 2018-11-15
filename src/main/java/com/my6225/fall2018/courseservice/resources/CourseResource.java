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
import com.my6225.fall2018.courseservice.service.CourseService;

@Path("courses")
public class CourseResource {
	
	CourseService service = new CourseService();
	public CourseResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses() {
		return service.getAllCourses();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseById(@PathParam("id") String id) {
		return service.getCourseById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course cos) {
		return service.addCourse(cos);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("id") String id, Course cos) {
		return service.updateCourse(id, cos);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("id") String id) {
		return service.deleteCourse(id);
	}
	
	@GET
	@Path("/{courseID}/{studentID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourseID(@PathParam("courseID") String courseID, @PathParam("studentID") String stdID) {
		return service.addStudentID(courseID, stdID);
	}
}
