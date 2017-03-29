package com.kylin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kylin.cloud.entity.User;
import com.kylin.cloud.feign.UserFeignClient;

@RestController
public class MovieContrller {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		
		return this.userFeignClient.findById(id);
	}
	
	@GetMapping("/test")
	public User testPost(User user){
		return this.userFeignClient.postUser(user);
	}
}
