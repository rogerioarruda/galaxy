package com.rogerioarruda.galaxy.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.rogerioarruda.galaxy.dtos.PlanetDTO;

import reactor.core.publisher.Mono;

@Component
public class SwapiClient {

    public Mono<PlanetDTO> getAllPlanets() {
        WebClient.Builder builder = WebClient.builder();
        return builder
        	.build()
        	.get()
        	.uri("https://swapi.dev/api/planets/1/")
        	.retrieve()
        	.bodyToMono(PlanetDTO.class);
    }
}
