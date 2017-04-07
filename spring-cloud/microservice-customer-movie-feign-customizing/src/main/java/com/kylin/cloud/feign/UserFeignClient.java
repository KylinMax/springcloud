package com.kylin.cloud.feign;

import java.math.BigDecimal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kylin.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
	// 两个坑：1. @GetMapping不支持 2.@PathVariable得设置value
	public User findById(@PathVariable("id") Long id);

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user);

	// 请求失败，只要参数是复杂参数，即使指定了是GET方法，feign依然会以POST方法进行发送请求
	// @RequestMapping(value="/get-user", method=RequestMethod.GET)
	// public User getUser(User user);

	//如果是复杂参数，现目前就只有这种方式
	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	public User getUser(@RequestParam("id") Long id, @RequestParam("username") String username,
			@RequestParam("name") String name, @RequestParam("age") short age,
			@RequestParam("balance") BigDecimal balance);
}
