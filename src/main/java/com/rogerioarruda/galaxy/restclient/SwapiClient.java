package com.rogerioarruda.galaxy.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rogerioarruda.galaxy.dtos.SearchDTO;

@Component
public class SwapiClient {

    @Value("${swapi.url.planet}")
    private String valueFromFile;

    public SearchDTO findPlanet(String search) {

        search = valueFromFile + (search.trim().length() > 0 ? ("?search=" + search) : "");
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<SearchDTO> response
    	  = restTemplate.getForEntity(search, SearchDTO.class);
        return response.getBody();
    }
}
