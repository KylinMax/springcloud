package com.kylin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kylin.cloud.entity.User;

@RestController
public class MovieContrller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Value("${user.userServicePath}")
	private String url;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		//http://localhost:7905/simple/ 
		//vip: virtual ip   (microservice-provider-user)
		//HAProxy  Heartbeat
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	
	//测试负载均衡的方式
	@RequestMapping("/test")
	public String test(){
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("=========================");
		System.out.print(serviceInstance.getHost());
		System.out.print(serviceInstance.getPort());
		System.out.println(serviceInstance.getServiceId());
		System.out.println("=========================");
		
		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("*************************");
		System.out.print(serviceInstance2.getHost());
		System.out.print(serviceInstance2.getPort());
		System.out.print(serviceInstance2.getServiceId());
		System.out.println("*************************");
		return "ok";
	}
}
