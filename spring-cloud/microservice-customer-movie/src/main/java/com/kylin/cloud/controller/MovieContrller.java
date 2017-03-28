package com.kylin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kylin.cloud.entity.User;

@RestController
public class MovieContrller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.userServicePath}")
	private String url;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		
		return this.restTemplate.getForObject(url+id, User.class);
	}
}
