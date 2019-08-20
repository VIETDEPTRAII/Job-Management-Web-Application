package com.vietdeptrai.jobmanagement.service;

import com.vietdeptrai.jobmanagement.model.User;
import com.vietdeptrai.jobmanagement.model.UserDto;

import java.util.List;

public interface UserService {
	
	List<User> findAllUsers();
	
	User findById(int id);
	
	User findOneUser(String username);
	
	User saveUser(UserDto user);
	
	UserDto updateUser(UserDto userDto);

	void deleteUser(int id);
	
}
