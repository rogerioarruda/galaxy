package com.rogerioarruda.galaxy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerioarruda.galaxy.dtos.SearchDTO;
import com.rogerioarruda.galaxy.models.Planet;
import com.rogerioarruda.galaxy.repositories.PlanetRepository;
import com.rogerioarruda.galaxy.restclient.SwapiClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetService {
	
	  @Autowired
	  private PlanetRepository planetRepository;
	  
	  @Autowired
	  private SwapiClient swapiClient;
	  
	  public Mono<Planet> save(Planet planet) {
		  return planetRepository.save(planet);
	  }
	  
	  public Flux<Planet> getAll() {
	    return planetRepository.findAll();
	  }
	  
	  public Flux<Planet> findByName(String name) {
		  return planetRepository.findByName(name);
	  }
	  
	  public Mono<Planet> findByid(long id) {
		  return planetRepository.findById(id);
	  }
	  
	  public void deleteById(long id) {
		  planetRepository.deleteById(id);
	  }

	  public Mono<SearchDTO> findByNameSwapi(String name) {
		  return swapiClient.findPlanet(name);
	  } 
	  /*public Mono<Planet> getNumMovies(Planet planet) { 
		  Mono<SearchDTO> findPlanet = swapiClient.findPlanet(planet.getName());
		  findPlanet.subscribe(value -> planet.setQtAp(value.getResults().size()));
	 	  findPlanet.doOnSuccess(searchDTO -> {
	 		  searchDTO.getResults().stream().findFirst()
	 		  	.ifPresent(dto -> planet.setQtAp(dto.getFilms().size()));
	 		  }).then(planetRepository.save(planet)); 
	  }*/
	 // planet.setQtAp(planetDTO.getFilms().size()); 
}
