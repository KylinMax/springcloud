package com.kylin.cloud.feign;

import com.kylin.cloud.entity.User;
import com.kylin.cloud.config.Configuration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 注解@FeignClient参数"microservice-provider-user"用于穿件Ribbon负载均衡器，
 * 因为使用了Eureka，所以Ribbon会把。也可以指定url属性指定请求的完整url或者主机名。
 */
@FeignClient(value = "microservice-provider-user", configuration = Configuration2.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    // 两个坑：1. @GetMapping不支持 2.@PathVariable得设置value
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    // 请求失败，只要参数是复杂参数，即使指定了是GET方法，feign依然会以POST方法进行发送请求
    // @RequestMapping(value="/get-user", method=RequestMethod.GET)
    // public User getUser(User user);

    //如果是复杂参数，现目前就只有这种方式
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id, @RequestParam("username") String username,
                        @RequestParam("name") String name, @RequestParam("age") short age,
                        @RequestParam("balance") BigDecimal balance);
}
