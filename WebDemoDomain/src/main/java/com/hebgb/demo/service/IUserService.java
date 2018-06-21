package com.hebgb.demo.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hebgb.demo.model.User;

public interface IUserService {

	Page<User> findAll(User user, Pageable pageable);

	User findByUsername(String username);

	void add(User user);

	void updateLastLoginTime(Long id, Date date);

}
