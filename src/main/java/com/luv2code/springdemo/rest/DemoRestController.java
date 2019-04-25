package com.luv2code.springdemo.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.model.User;
import com.luv2code.springdemo.repo.UserRepository;
import com.luv2code.springdemo.representation.ApiResponse;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@PostMapping("/user/save")
	public ApiResponse<User> save(@RequestBody User user) {
		// save a single Customer
		userRepository.save(user);		
		return new ApiResponse<>(200,user);
	}
	@PutMapping("/user/update")
	public ApiResponse<User> update(@RequestBody User user) {
		// save a single Customer
		userRepository.update(user);	
		return new ApiResponse<>(200,user);
	}
	@DeleteMapping("/user/delete/{id}")
	public ApiResponse<String> deleteById(@PathVariable String id){
		userRepository.delete(id);
		return new ApiResponse<>(200,"Removed User ID:- " + id);
	}
	
	@GetMapping("/user/{id}")
	public ApiResponse<User> findUserById(@PathVariable String id){
		User user = userRepository.find(id);
		return new ApiResponse<>(200,user);
	}
	
	@GetMapping("/users")
	public ApiResponse<Map<String,User>> findAll(){
		Map<String,User> users = userRepository.findAll();
		return new ApiResponse<>(200,users);
	}

	// add code for the "/hello" endpoint
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
