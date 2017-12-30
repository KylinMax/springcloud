package com.kylin.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kylin.cloud.config.Configuration2;

//此版本的spring cloud 中 @FeignClient必须value或者name属性为不为空的字符串
@FeignClient(value =  "xxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface FeignClient2 {

	@RequestMapping(value="/eureka/apps/{serviceName}", method=RequestMethod.GET)
	public String findServicefromEurekaByServiceName(@PathVariable("serviceName") String serviceName);

}