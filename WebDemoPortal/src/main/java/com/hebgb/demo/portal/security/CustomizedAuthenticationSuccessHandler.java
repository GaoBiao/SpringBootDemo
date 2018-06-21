package com.hebgb.demo.portal.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.hebgb.demo.model.User;
import com.hebgb.demo.service.IUserService;

public class CustomizedAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private IUserService userService;

	public CustomizedAuthenticationSuccessHandler(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		CustomizedUserDetails userDetails = (CustomizedUserDetails) authentication.getPrincipal();
		User user = (User) userDetails.getUser();
		userService.updateLastLoginTime(user.getId(), new Date());
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
