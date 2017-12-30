package com.kylin.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@ComponentScan(excludeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION, value=ExcludeComponentScan.class))

public class CustomerMovieFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMovieFeignApplication.class, args);
    }
}
