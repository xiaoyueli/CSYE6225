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

import com.my6225.fall2018.courseservice.datamodel.Announcements;
import com.my6225.fall2018.courseservice.service.AnnouncementsService;

@Path("announcements")
public class AnnouncementsResource {
	
	AnnouncementsService service = new AnnouncementsService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Announcements> getAnnouncements() {
		return service.getAllAnnouncements();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Announcements getAnnouncementsById(@PathParam("id") String id) {
		return service.getAnnouncementsById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcements addAnnouncements(Announcements board) {
		return service.addAnnouncements(board);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcements updateAnnouncementsInformation(@PathParam("id") String id, Announcements announcements) {
		return service.updateAnnouncementsInformation(id, announcements);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Announcements deleteAnnouncementsById(@PathParam("id") String id) {
		return service.deleteAnnouncementsById(id);
	}
}
