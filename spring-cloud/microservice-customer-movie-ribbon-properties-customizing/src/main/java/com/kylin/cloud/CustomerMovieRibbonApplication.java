package com.kylin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient

public class CustomerMovieRibbonApplication {

	// 相当于：private RestTemplate RestTemplate = new RestTemplate();
	@Bean
	@LoadBalanced //实现了ribbon,默认的负载均衡的策略是轮询
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerMovieRibbonApplication.class, args);
	}
}
