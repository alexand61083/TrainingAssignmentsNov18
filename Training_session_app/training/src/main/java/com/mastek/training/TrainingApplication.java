package com.mastek.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
				SpringApplication.run(TrainingApplication.class, args);
		
//		TrainingAccessAPI trainingAPI = ctx.getBean(TrainingAccessAPI.class);
//		ParticipantAccessAPI participantAPI = ctx.getBean(ParticipantAccessAPI.class);
//		
//		Training session1 = new Training();
//		
//		session1.setName("Sohail teaches mongo");
//		session1.setLocation("Leeds");
//		session1.setDate("17/01/2018");
//		
//		Participant participant = new Participant();
//
//		
//		participant.setName("Dan");
		
		
		
		
		//trainingAPI.addTraining(session1);
		//trainingAPI.addNewParticipantToTraining(16, 63);
	}

}

