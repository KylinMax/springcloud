package com.kylin.cloud.feign;

import com.kylin.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient
public interface UserFeignClientAuth {
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable("id") Long id);
}
