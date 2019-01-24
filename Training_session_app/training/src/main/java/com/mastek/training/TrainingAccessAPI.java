package com.mastek.training;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/trainings/")
public class TrainingAccessAPI {

	TrainingJPARepository repository;
	ParticipantJPARepository participantRepository;

	public TrainingJPARepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(TrainingJPARepository repository) {
		this.repository = repository;
	}
		
	public ParticipantJPARepository getParticipantRepository() {
		return participantRepository;
	}

	@Autowired
	public void setParticipantRepository(ParticipantJPARepository participantRepository) {
		this.participantRepository = participantRepository;
	}

	// URL = http://localhost:9900/trainings/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Training> listTrainings() {
		return getRepository().findAll();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Training addTraining(@BeanParam Training newtraining) {
		getRepository().save(newtraining);
		return newtraining;
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Training deletetraining(int trainingId) {
		Training deletetraining = getRepository().findById(trainingId).get();
		getRepository().delete(deletetraining);
		return deletetraining;
	}
	
	@POST
	@Path("/joined")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Set<Participant> addNewParticipantToTraining (@FormParam("trainingId")int trainingId, @FormParam ("empId") int empId) {
		Participant p = getParticipantRepository().findById(empId).get();
		Training t = getRepository().findById(trainingId).get();
		
		if(!t.getParticipants().contains(p)) {
			t.getParticipants().add(p);
		}
		//p.getTrainings().add(t)
		getRepository().save(t);
		return t.getParticipants();
	}
	
	@GET
	@Path("/participants")
	@Transactional
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Set<Participant> getParticipant(@QueryParam("trainingId") int trainingId){
		Training t = getRepository().findById(trainingId).get();
		
		if(!t.getParticipants().isEmpty()) {
		return t.getParticipants();
	} else {
		return null;
	}
	}
}
