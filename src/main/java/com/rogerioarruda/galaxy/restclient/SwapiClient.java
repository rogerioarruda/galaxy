package com.rogerioarruda.galaxy.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.rogerioarruda.galaxy.dtos.PlanetDTO;
import com.rogerioarruda.galaxy.dtos.SearchDTO;

import reactor.core.publisher.Mono;

@Component
public class SwapiClient {

    public Mono<SearchDTO> findPlanet(String search) {
    	String uri = "https://swapi.dev/api/planets/" + (search.trim().length() > 0 ? ("?search=" + search) : "");
        WebClient.Builder builder = WebClient.builder();
        return builder
        	.build()
        	.get()
        	.uri(uri)
        	.retrieve()
        	.bodyToMono(SearchDTO.class);
    }
}
