package com.fish.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.model.User;
import com.fish.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fish")
public class FishController {

//	@Autowired
//	private UserService userService;
	
	private final UserService userService;
	
	public FishController(final UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/test")
	public Mono<String> test() {
		return Mono.just("hello, flux");
	}
	
	@RequestMapping("/find")
	public Mono<User> findById(final String id) {
		return userService.getById(id);
	}
	
	@RequestMapping(value="/list",produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> get() {
		return userService.list().delayElements(Duration.ofSeconds(2));
	}
	
	@RequestMapping("/del")
	public Mono<User> delete(String id) {
		return userService.delete(id);
	}
}
