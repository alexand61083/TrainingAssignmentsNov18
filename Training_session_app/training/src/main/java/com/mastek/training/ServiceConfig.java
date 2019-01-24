package com.mastek.training;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig extends ResourceConfig {
	
	public ServiceConfig() {
		//register the CORS filter for service
		register(CORSFilter.class);
		// register training as a service
		register(TrainingAccessAPI.class);
		// register participants as a service
		register(ParticipantAccessAPI.class);
	}
	

}
