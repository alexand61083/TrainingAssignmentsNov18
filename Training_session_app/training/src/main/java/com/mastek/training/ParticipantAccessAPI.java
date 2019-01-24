package com.mastek.training;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/participants/")
public class ParticipantAccessAPI {
	
	ParticipantJPARepository repository;

	public ParticipantJPARepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(ParticipantJPARepository repository) {
		this.repository = repository;
	}
	
	// URL = http://localhost:9900/participants/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Participant> listParticipants() {
		return getRepository().findAll();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Participant addParticipant(@BeanParam Participant newparticipant) {
		getRepository().save(newparticipant);
		return newparticipant;
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Participant deleteparticipant(int participantId) {
		Participant deleteParticipant = getRepository().findById(participantId).get();
		getRepository().delete(deleteParticipant);
		return deleteParticipant;
	}

}
