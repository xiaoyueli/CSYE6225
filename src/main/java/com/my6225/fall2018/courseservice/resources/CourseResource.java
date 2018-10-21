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
	
	private CourseService service;
	public CourseResource() {
		// TODO Auto-generated constructor stub
		service = new CourseService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}
	
	@GET
	@Path("/{courseID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourseById(@PathParam("courseID") int id) {
		return service.getCourseByID(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return service.addCourse(course);
	}
	
	@PUT
	@Path("/{courseID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourseInformation(@PathParam("courseID") long id, Course course) {
		return service.updateCourse(id, course);
	}
	
	@DELETE
	@Path("/{courseID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course deleteCourseByID(@PathParam("courseID") long id) {
		return service.deleteCourseByID(id);
	}
	
	@GET
	@Path("/{courseID}/addprofessor/{professorID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addProfessor(@PathParam("courseID") long courseID, @PathParam("professorID") long professorID) {
		return service.addProfessor(courseID, professorID);
	}
	
	@DELETE
	@Path("/{courseID}/deleteProfessor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course deleteProfessor(@PathParam("courseID") long courseID) {
		return service.deleteProfessor(courseID);
	}
	
	@GET
	@Path("/{courseID}/addlecture/{lectureTitle}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addLecture(@PathParam("courseID") long courseID, @PathParam("lectureTitle") String lectureTitle) {
		return service.addLecture(courseID, lectureTitle);
	}
	
	@DELETE
	@Path("/{courseID}/deletelecture/{lectureTitle}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course deleteLecture(@PathParam("courseID") long courseID, @PathParam("lectureTitle") String lectureTitle) {
		return service.deleteLecture(courseID, lectureTitle);
	}

}
