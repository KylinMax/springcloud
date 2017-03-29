package com.kylin.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kylin.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	//两个坑：1. @GetMapping不支持 2.@Variable得设置value
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public User postUser(@RequestBody User user);

}
