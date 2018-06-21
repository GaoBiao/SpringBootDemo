package com.hebgb.demo.management.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hebgb.demo.enums.ObjectStatus;
import com.hebgb.demo.management.model.Admin;

public class CustomizedUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin;

	private CustomizedUserDetails(Admin admin) {
		this.admin = admin;
	}

	public static CustomizedUserDetails getIntance(Admin admin) {
		if (admin != null) {
			return new CustomizedUserDetails(admin);
		}
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return ObjectStatus.enabled.equals(admin.getStatus());
	}

	public Admin getAdmin() {
		return admin;
	}

}
