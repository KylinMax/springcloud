package com.kylin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.kylin.cloud.config.ExcludeComponentScan;
import com.kylin.cloud.config.TestConfiguration;
@SpringBootApplication
@EnableEurekaClient
//排除ribbon负载均衡配置在主applicationContext之外,只让该配置对@RibbonClient配置的微服务起作用，而不是对全局的微服务都起作用
@ComponentScan(excludeFilters=@ComponentScan.Filter(type=FilterType.ANNOTATION, value=ExcludeComponentScan.class))
//配置ribbon的负载均衡的方式
@RibbonClient(name="microservice-provider-user",configuration=TestConfiguration.class)

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
