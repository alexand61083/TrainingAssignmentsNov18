package com.mastek.training;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="SPRING_BOOT_SESSIONS")
@XmlRootElement	//enables Java object conversion to XML data
public class Training {
	
	
	@FormParam("trainingId")
	int trainingId;
	
	@FormParam("name")
	String name;
	@FormParam("location")
	String location;
	@FormParam("date")
	String date;
	Set<Participant> participants = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSessionId() {
		return trainingId;
	}
	public void setSessionId(int sessionId) {
		this.trainingId = sessionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@XmlTransient
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="Trainings_Participants",
	joinColumns = {@JoinColumn(name="FK_TrainingId")}, //the foreign key for the current class
	inverseJoinColumns= {@JoinColumn(name="FK_ParticipantId")})//the foreign key for the collection type class
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	
	

}
