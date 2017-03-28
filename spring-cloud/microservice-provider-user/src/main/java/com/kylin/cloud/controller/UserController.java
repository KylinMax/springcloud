package com.kylin.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.kylin.cloud.entity.User;
import com.kylin.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	//注意导包
	private DiscoveryClient discoveryClient;

	@GetMapping("/simple/{id}") // 相当于Requestmapping(value="/xxx/xxxx",Method="GET")
	public User findById(@PathVariable Long id) {
		return this.userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		// 默认情况下，MICROSERVICE-PROVIDER-USER为虚拟化的主机名，就是应用的名称
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("microservice-provider-user", false);
		return instance.getHomePageUrl();
	}
	
	@GetMapping("/instance-info")
	public ServiceInstance showInfo(){
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
