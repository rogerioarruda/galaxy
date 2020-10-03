package com.rogerioarruda.galaxy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rogerioarruda.galaxy.dtos.PlanetDTO;
import com.rogerioarruda.galaxy.models.Planet;
import com.rogerioarruda.galaxy.services.PlanetService;


@RestController
@RequestMapping(path="/planet")
public class PlanetController {
	
  @Autowired
  private PlanetService planetService;

  @PostMapping
  public @ResponseBody Planet post (@RequestBody Planet planet) {	  
	  return planetService.save(planet);
  }

  @GetMapping
  public @ResponseBody Iterable<Planet> getAllPlanets() {
    return planetService.getAll();
  }  
  
  @GetMapping(path="/{id}")
  public @ResponseBody Optional<Planet> getById(@PathVariable Long id) {
    return planetService.findByid(id);
  }

  @GetMapping(path="/name/{name}")
  public @ResponseBody Iterable<Planet> getByName(@PathVariable String name) {
    return planetService.findByName(name);
  }


  @GetMapping(path="/getAllFromSwapi/")
  public @ResponseBody List<PlanetDTO> getAllFromSwapi() {
    return planetService.getAllFromSwapi();
  }
  
  @DeleteMapping(path="/{id}")
  public void deleteById(@PathVariable Long id) {
    planetService.deleteById(id);
  }
}
