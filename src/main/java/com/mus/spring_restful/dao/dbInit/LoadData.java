package com.mus.spring_restful.dao.dbInit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mus.spring_restful.dao.entity.Vehicle;
import com.mus.spring_restful.repository.VehicleRepository;

@Configuration
public class LoadData {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoadData.class);
	
	@Bean
	CommandLineRunner initializeDatabase(VehicleRepository vehicle) {
		return args -> {
			LOGGER.info("Preload Data : "+vehicle.save(new Vehicle(Long.valueOf("1"),"Hyundai","i20",Double.valueOf("900000"))));
		};
		
	}

}
