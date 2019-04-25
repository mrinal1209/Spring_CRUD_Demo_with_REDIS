package com.luv2code.springdemo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@RedisHash("users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{
	private static final long serialVersionUID = 2584717032138458147L;	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	@JsonCreator
	public User(@JsonProperty("id")String id,@JsonProperty("firstName")String firstName,@JsonProperty("lastName")String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
