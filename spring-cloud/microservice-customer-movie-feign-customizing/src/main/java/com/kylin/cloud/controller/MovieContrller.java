package com.kylin.cloud.controller;

import com.kylin.cloud.entity.User;
import com.kylin.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.kylin.cloud.feign.FeignClient2;

import java.util.List;

@RestController
public class MovieContrller {

	@Autowired
	private FeignClient2 feignClient;

	@Autowired
    private UserFeignClient userFeignClient;

	@Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 夸service查询user
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return this.userFeignClient.findById(id);
    }

	@GetMapping("/eureka/apps/{serviceName}")
	public String findServicefromEurekaByServiceName(@PathVariable String serviceName){
		return this.feignClient.findServicefromEurekaByServiceName(serviceName);
	}

    /**
     * 查询microservice-provider-user服务的信息并返回
     * @return microservice-provider-user 服务的信息
     */
	@GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
	    return this.discoveryClient.getInstances("microservice-provider-user");
    }

}
