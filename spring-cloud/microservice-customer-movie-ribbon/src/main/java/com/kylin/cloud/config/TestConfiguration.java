package com.kylin.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeComponentScan
public class TestConfiguration {
//	@Autowired
//	IClientConfig iClientConfig;
	
	@Bean
	public IRule ribbenRule(){
		return new RandomRule();
	}
}
