package com.rogerioarruda.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import com.rogerioarruda.galaxy.repositories.PlanetRepository;

@SpringBootApplication
@EnableR2dbcRepositories
public class GalaxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaxyApplication.class, args);
	}

}
