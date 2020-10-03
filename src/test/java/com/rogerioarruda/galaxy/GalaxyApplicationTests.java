package com.rogerioarruda.galaxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rogerioarruda.galaxy.models.Planet;
import com.rogerioarruda.galaxy.repositories.PlanetRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class GalaxyApplicationTests {

	@Autowired
	PlanetRepository planetRepository;
	
	@Test
	public void whenSave_thenFindOneById() {
		Planet planet = saveOnePlanet();

		Optional<Planet> found = planetRepository.findById(planet.getId());
		assertEquals(planet.getId(), found.get().getId());
	}
	
	@Test
	public void whenSave_thenFindOneByName() {
		Planet planet = saveOnePlanet();

		Planet found =
		planetRepository.findByName(planet.getName()).iterator().next();
		assertEquals(planet.getName(), found.getName());
	}

	@Test
	public void whenSaveSeveral_thenFindSeveral() {
		getThreePlanets().forEach(planet -> planetRepository.saveAndFlush(planet));

		List<Planet> found = planetRepository.findAll();
		
		assertEquals(found.size(), 3);
	}	

	@Test
	public void whenSaveAndDelete_thenNoData() {
		Planet planet = saveOnePlanet();

		List<Planet> found = planetRepository.findAll();
		
		assertEquals(found.size(), 1);
		
		planetRepository.delete(planet);

		found = planetRepository.findAll();
		
		assertEquals(found.size(), 0);
	}

	
	private static List<Planet> getThreePlanets() {
        List<Planet> dummyPlanetList = new ArrayList<Planet>();
        dummyPlanetList.add(new Planet("DummyPlanet1","DummyClimate1","DummyTerrain1",1));
        dummyPlanetList.add(new Planet("DummyPlanet2","DummyClimate2","DummyTerrain2",2));
        dummyPlanetList.add(new Planet("DummyPlanet3","DummyClimate3","DummyTerrain3",3));
        return dummyPlanetList;
    }


	private Planet saveOnePlanet() {
		Planet planet = new Planet("DummyPlanet","DummyClimate","DummyTerrain",0);
		planetRepository.saveAndFlush(planet);
		return planet;
	}
}
