package com.hebgb.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hebgb.demo.enums.ObjectStatus;
import com.hebgb.demo.model.User;
import com.hebgb.demo.repository.UserRepository;
import com.hebgb.demo.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findAll(User user, Pageable pageable) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id", "password");
		Example<User> example = Example.of(user, matcher);
		return userRepository.findAll(example, pageable);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void add(User user) {
		user.setCreateTime(new Date());
		user.setStatus(ObjectStatus.enabled);
		userRepository.save(user);
	}

	@Override
	public void updateLastLoginTime(Long id, Date date) {
		userRepository.updateLastLoginTime(id, date);
	}

}
