package com.hebgb.demo.management.service;

import java.util.Date;

import com.hebgb.demo.exception.MessageException;
import com.hebgb.demo.management.model.Admin;

public interface IAdminService {

	Admin findByLoginName(String loginName);

	long count();

	void save(Admin admin) throws MessageException;

	void updateLastLoginTime(String id, Date date);

}
