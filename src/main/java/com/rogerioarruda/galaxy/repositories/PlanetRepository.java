package com.rogerioarruda.galaxy.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.rogerioarruda.galaxy.models.Planet;

import reactor.core.publisher.Flux;

@Repository
public interface PlanetRepository extends ReactiveCrudRepository<Planet, Long> {

	Flux<Planet> findByName(String name);
}