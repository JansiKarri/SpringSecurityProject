package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {
	private final UserRepository user_repository;
	private final PasswordEncoder password_encoder;
	public userService(UserRepository user_repository, @Lazy PasswordEncoder password_encoder) {
		super();
		this.user_repository = user_repository;
		this.password_encoder = password_encoder;
	}
	public User addUser(User u) {
		u.setPassword(password_encoder.encode(u.getPassword()));
		u.setRole("userrole");
		return user_repository.save(u);
	}
	
	public User findByUser(String userName) {
		return user_repository.findByUsername(userName);
		
	}
	
	

}
