package com.rogerioarruda.galaxy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerioarruda.galaxy.dtos.PlanetDTO;
import com.rogerioarruda.galaxy.models.Planet;
import com.rogerioarruda.galaxy.repositories.PlanetRepository;
import com.rogerioarruda.galaxy.restclient.SwapiClient;

import reactor.core.publisher.Mono;

@Service
public class PlanetService {
	
	  @Autowired
	  private PlanetRepository planetRepository;
	  
	  @Autowired
	  private SwapiClient swapiClient;
	  
	  public Planet save(Planet planet) {
		  return planetRepository.saveAndFlush(planet);
	  }
	  
	  public Iterable<Planet> getAll() {
	    return planetRepository.findAll();
	  }
	  
	  public Iterable<Planet> findByName(String name) {
		  return planetRepository.findByName(name);
	  }
	  
	  public Optional<Planet> findByid(long id) {
		  return planetRepository.findById(id);
	  }
	  
	  public void deleteById(long id) {
		  planetRepository.deleteById(id);
	  }

	  public Mono<PlanetDTO> getPlanets(){
		  return swapiClient.getAllPlanets();
	  }
}
