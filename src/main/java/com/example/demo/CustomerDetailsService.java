package com.example.demo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService{

	private final userService userservice;
	public CustomerDetailsService(userService userservice) {
		super();
		this.userservice = userservice;
	}
	
	
		
		

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u=userservice.findByUser(username);
		if(u==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return org.springframework.security.core.userdetails.User.withUsername(username).password(u.getPassword()).build();
		
		
	}
	

	public String getErrorPath() {
		return "/error";
		
	}

	

}
