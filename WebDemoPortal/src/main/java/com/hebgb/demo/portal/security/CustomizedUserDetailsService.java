package com.hebgb.demo.portal.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hebgb.demo.service.IUserService;

public class CustomizedUserDetailsService implements UserDetailsService {
	private IUserService userService;

	public CustomizedUserDetailsService(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return CustomizedUserDetails.getIntance(userService.findByUsername(username));
	}

}
