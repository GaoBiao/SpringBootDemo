package com.hebgb.demo.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hebgb.demo.model.User;
import com.hebgb.demo.service.IUserService;

@Controller
public class IndexController extends AbstractController {

	protected static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public void index() {

	}
	
	@GetMapping("/login")
	public void login() {

	}

	@GetMapping("/register")
	public void register() {
		logger.info("==========");
	}

	@PostMapping("/register")
	public String register(Model model, String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userService.add(user);
		return "redirect:login";
	}
}
