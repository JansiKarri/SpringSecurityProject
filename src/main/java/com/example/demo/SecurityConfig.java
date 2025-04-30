package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final CustomerDetailsService customerdetailsservice;

	public SecurityConfig(CustomerDetailsService customerdetailsservice) {
		super();
		this.customerdetailsservice = customerdetailsservice;
	}
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception {
		http.authorizeRequests(
				authorizerequest ->
				authorizerequest.requestMatchers("/register")
				.permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(
				formlogin ->
				formlogin.loginPage("/login")
				.defaultSuccessUrl("/userdashboard",true)
				.permitAll()
				)
		.logout(
				logout -> 
				logout.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}