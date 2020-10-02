package com.example.demo.service.facade;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.bean.User;

public interface UserService {
	
	public int saveWithRoles(User user);
	
	public String authentificate(String login, String pass);
	
	public UserDetails loadUserByUsername(String username);

}
