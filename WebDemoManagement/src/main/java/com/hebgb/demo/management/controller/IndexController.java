package com.hebgb.demo.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hebgb.demo.Constants;
import com.hebgb.demo.exception.MessageException;
import com.hebgb.demo.management.model.Admin;
import com.hebgb.demo.management.service.IAdminService;

@Controller
public class IndexController extends AbstractController {

	protected static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private IAdminService adminService;

	@RequestMapping("/index")
	public void index() {

	}

	@GetMapping("/login")
	public void login() {
	}

	@RequestMapping("/init")
	public String init(Model model, Admin admin) {
		logger.info("init page");
		long count = adminService.count();
		if (count > 0) {
			return "redirect:login";
		}
		if ("POST".equals(request.getMethod())) {
			try {
				adminService.save(admin);
			} catch (MessageException e) {
				model.addAttribute(Constants.ERROR_MESSAGE, e.getMessage());
			}
			return "redirect:login";
		}
		return "init";
	}
}
