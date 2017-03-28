package com.kylin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceSimpleCustomerMovieApplication {

	// 相当于：private RestTemplate RestTemplate = new RestTemplate();
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleCustomerMovieApplication.class, args);
	}
}
