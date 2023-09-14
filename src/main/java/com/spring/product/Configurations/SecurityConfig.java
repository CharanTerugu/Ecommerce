package com.spring.product.Configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.product.filters.JwtAuthFilter;
import com.spring.product.service.serviceimpl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	@Autowired
	JwtAuthFilter authFilter;
	
	@Bean
	public UserDetailsService  userDetailsService()
	{
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.csrf().disable().cors().and().
			authorizeHttpRequests().requestMatchers("/user/**").permitAll().and().
			authorizeHttpRequests().requestMatchers("/customer/**").hasAuthority("ROLE_USER").and().
				authorizeHttpRequests().requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN").and().
				authorizeHttpRequests().requestMatchers("/products/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN").and().
//				authorizeHttpRequests().requestMatchers("/user/hello").authenticated().and().
				 
	                logout()
	                .logoutSuccessUrl("/") 
	                .permitAll().and().
				sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
	  return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		 
		return config.getAuthenticationManager();
	}
}