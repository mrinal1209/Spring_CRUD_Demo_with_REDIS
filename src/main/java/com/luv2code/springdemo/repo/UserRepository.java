package com.luv2code.springdemo.repo;

import java.util.Map;

import com.luv2code.springdemo.model.User;

public interface UserRepository {
	void save(User user);
	User find(String id);
	Map<String, User> findAll();
	void update(User user);
	void delete(String id);
}
