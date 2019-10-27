package com.fish.service;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientTest {
	
	@Test
	public void testBase1() {
		Flux<String> flux = WebClient.create().get()
				.uri("http://localhost:8080/fish/list")
				.accept(MediaType.APPLICATION_STREAM_JSON)
				.retrieve().bodyToFlux(String.class);
		System.out.println(flux.blockLast());
	}
	
	@Test
	public void testBase2() {
		Mono<String> flux = WebClient.create().get()
				.uri("http://localhost:8080/fish/find?id={id}", 3)
				.accept(MediaType.APPLICATION_STREAM_JSON)
				.retrieve().bodyToMono(String.class);
		System.out.println(flux.block());
	}
}
