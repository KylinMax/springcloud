package com.kylin.cloud.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kylin.cloud.entity.User;
import com.kylin.cloud.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/simple/{id}") //相当于Requestmapping(value="/xxx/xxxx",Method="GET")
	public User findById(@PathVariable Long id){
		return this.userRepository.findOne(id);
	}
}
