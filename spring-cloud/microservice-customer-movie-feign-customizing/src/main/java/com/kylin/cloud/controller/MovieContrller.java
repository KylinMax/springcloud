package com.kylin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kylin.cloud.feign.FeignClient2;

@RestController
public class MovieContrller {
	
	@Autowired
	private FeignClient2 feignClient2;
	
	@GetMapping("/eureka/apps/{serviceName}")
	public String findServicefromEurekaByServiceName(@PathVariable String serviceName){
		return this.feignClient2.findServicefromEurekaByServiceName(serviceName);
	}

}
