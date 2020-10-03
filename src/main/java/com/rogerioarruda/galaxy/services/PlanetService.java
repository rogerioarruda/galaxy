package com.rogerioarruda.galaxy.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogerioarruda.galaxy.dtos.PlanetDTO;
import com.rogerioarruda.galaxy.dtos.SearchDTO;
import com.rogerioarruda.galaxy.models.Planet;
import com.rogerioarruda.galaxy.repositories.PlanetRepository;
import com.rogerioarruda.galaxy.restclient.SwapiClient;

@Service
public class PlanetService {
	
	  @Autowired
	  private PlanetRepository planetRepository;
	  
	  @Autowired
	  private SwapiClient swapiClient;
	  
	  public Planet save(Planet planet) {
		  Iterator<Planet> listPlanets =  findByName(planet.getName()).iterator();
		  if (listPlanets.hasNext())
			  planet = listPlanets.next();
		  planet.setQtFilms(findByNameSwapi(planet.getName()));
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

	  public List<PlanetDTO> getAllFromSwapi() {
		  return swapiClient.findPlanet("").getResults();
	  }
	  
	  private int findByNameSwapi(String name) {
		  SearchDTO searchDTO = swapiClient.findPlanet(name);
		  if ((searchDTO != null) && (searchDTO.getResults() != null) && (!searchDTO.getResults().isEmpty()))
			  return searchDTO.getResults().iterator().next().getFilms().size();
		  else
			  return 0;
	  } 
}
