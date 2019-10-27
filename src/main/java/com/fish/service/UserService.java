package com.fish.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fish.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	private static final Map<String, User> dataMap = new HashMap<>();
	
	static {
		dataMap.put("1", new User("1", "zhaojiahong1"));
		dataMap.put("2", new User("2", "zhaojiahong2"));
		dataMap.put("3", new User("3", "zhaojiahong3"));
		dataMap.put("4", new User("4", "zhaojiahong4"));
		dataMap.put("5", new User("5", "zhaojiahong5"));
		dataMap.put("6", new User("6", "zhaojiahong6"));
		dataMap.put("7", new User("7", "zhaojiahong7"));
		dataMap.put("8", new User("8", "zhaojiahong8"));
		dataMap.put("9", new User("9", "zhaojiahong9"));
	}
	
	public Flux<User> list() {
		Collection<User> list = UserService.dataMap.values();
		return Flux.fromIterable(list);
	}
	
	public Mono<User> getById(String id) {
		User user = UserService.dataMap.get(id);
		return Mono.justOrEmpty(user);
	}
	
	public Mono<User> delete(final String id) {
		User user = UserService.dataMap.remove(id);
		return Mono.justOrEmpty(user);
	}
}
