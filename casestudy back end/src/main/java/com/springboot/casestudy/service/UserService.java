package com.springboot.casestudy.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.casestudy.model.User;
import com.springboot.casestudy.repository.UserRepository;


@Service
public class UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User signUp(User user) {
		String plainPassword = user.getPassword(); //<- this gives you plain password
		String encodedPassword =  passwordEncoder.encode(plainPassword);
		user.setPassword(encodedPassword); //<- Now, User has encoded password 

		return userRepository.save(user);
	}

	public Object getUserInfo(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

}
