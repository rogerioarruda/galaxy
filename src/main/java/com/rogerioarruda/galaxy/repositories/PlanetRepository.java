package com.rogerioarruda.galaxy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogerioarruda.galaxy.models.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Iterable<Planet> findByName(String name);
}