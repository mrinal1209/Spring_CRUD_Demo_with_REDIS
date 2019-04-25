package com.luv2code.springdemo.service;

import com.luv2code.springdemo.model.User;

public interface UserService {
    User saveOrUpdate(String hashName , String key ,User user);    
}
