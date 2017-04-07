package com.kylin.cloud.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	//请求失败
//	@GetMapping("/test-get")
//	public User testGet(User user){
//		return this.userFeignClient.getUser(user);
//	}
	
	@GetMapping("/test-get")
	public User testGet(@RequestParam("id") Long id, @RequestParam("username") String username,
			@RequestParam("name") String name, @RequestParam("age") short age,
			@RequestParam("balance") BigDecimal balance){
		return this.userFeignClient.getUser(id, username, name, age, balance);
	}
}
