package com.my6225.fall2018.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.my6225.fall2018.courseservice.datamodel.Lecture;
import com.my6225.fall2018.courseservice.service.LectureService;

@Path("lectures")
public class LectureResourse {

	private LectureService service = new LectureService();
	public LectureResourse() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getAllLectures() {
		return service.getAllLectures();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture addLecture(Lecture lecture) {
		return service.addLecture(lecture);
	}
	
	@GET
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture getLecture(@PathParam("title") String title) {
		return service.getLecture(title);
	}
	
	@DELETE
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture deleteCourseByID(@PathParam("title") String title) {
		return service.deleteLecture(title);
	}
	
}
