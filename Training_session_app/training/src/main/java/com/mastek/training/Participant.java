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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="SPRING_BOOT_PARTICIPANTS")
public class Participant {
	
	@FormParam(value = "empId")
	int empId;
	
	@FormParam(value = "name")
	String name;
	Set<Training> trainings = new HashSet<>();
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlTransient
	@ManyToMany(mappedBy="participants")
	public Set<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	
	@Override
	public String toString() {
		return "Participant [empId=" + empId + ", name=" + name + ", trainings=" + trainings + "]";
	}
	
	

}
