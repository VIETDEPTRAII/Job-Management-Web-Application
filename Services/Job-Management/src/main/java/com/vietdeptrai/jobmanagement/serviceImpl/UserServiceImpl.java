package com.vietdeptrai.jobmanagement.serviceImpl;

import com.vietdeptrai.jobmanagement.dao.UserDao;
import com.vietdeptrai.jobmanagement.model.User;
import com.vietdeptrai.jobmanagement.model.UserDto;
import com.vietdeptrai.jobmanagement.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	@Override
	public List<User> findAllUsers() {
		List<User> list = new ArrayList<>();
		userDao
		.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public User findOneUser(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User saveUser(UserDto user) {
		 User newUser = new User();
		 newUser.setUsername(user.getUsername());
		 newUser.setPassword(bcryptEncoder.encode(user.getPassword()));	
	     return userDao.save(newUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		
		 User user = findById(userDto.getId());
	     if(user != null) {
	    	 BeanUtils.copyProperties(userDto, user, "password");
	         userDao.save(user);
	     }
	     return userDto;
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteById(id);
		
	}
	
}
