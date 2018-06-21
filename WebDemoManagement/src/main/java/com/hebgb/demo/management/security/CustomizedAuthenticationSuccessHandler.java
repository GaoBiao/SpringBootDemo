package com.hebgb.demo.management.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.hebgb.demo.management.model.Admin;
import com.hebgb.demo.management.service.IAdminService;

public class CustomizedAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private IAdminService adminService;

	public CustomizedAuthenticationSuccessHandler(IAdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		CustomizedUserDetails userDetails = (CustomizedUserDetails) authentication.getPrincipal();
		Admin admin = (Admin) userDetails.getAdmin();
		adminService.updateLastLoginTime(admin.getId(), new Date());
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
