package com.kylin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class CustomerMovieFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMovieFeignApplication.class, args);
    }
}
