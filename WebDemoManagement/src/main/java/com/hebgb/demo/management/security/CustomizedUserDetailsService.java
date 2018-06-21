package com.hebgb.demo.management.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hebgb.demo.management.model.Admin;
import com.hebgb.demo.management.service.IAdminService;

public class CustomizedUserDetailsService implements UserDetailsService {
	private IAdminService adminService;

	public CustomizedUserDetailsService(IAdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminService.findByLoginName(username);
		if (admin == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		return CustomizedUserDetails.getIntance(admin);
	}

}
