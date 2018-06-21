package com.hebgb.demo.portal.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hebgb.demo.enums.ObjectStatus;
import com.hebgb.demo.model.Role;
import com.hebgb.demo.model.User;

public class CustomizedUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	private CustomizedUserDetails(User user) {
		this.user = user;
	}

	public static CustomizedUserDetails getIntance(User user) {
		if (user != null) {
			return new CustomizedUserDetails(user);
		}
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		List<Role> roles = user.getRoles();
		if (roles != null && !roles.isEmpty()) {
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getRole()));
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
		return ObjectStatus.enabled.equals(user.getStatus());
	}

	public User getUser() {
		return user;
	}

}
