package com.hebgb.demo.management.service.impl;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hebgb.demo.enums.ObjectStatus;
import com.hebgb.demo.exception.MessageException;
import com.hebgb.demo.management.model.Admin;
import com.hebgb.demo.management.repository.AdminRepository;
import com.hebgb.demo.management.service.IAdminService;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin findByLoginName(String loginName) {
		return adminRepository.findByLoginName(loginName);
	}

	@Override
	public long count() {
		return adminRepository.count();
	}

	@Override
	public void save(Admin admin) throws MessageException {
		if (StringUtils.isEmpty(admin.getId())) {
			if (StringUtils.isEmpty(admin.getLoginName())) {
				throw new MessageException("登录名为空");
			}
			if (StringUtils.isEmpty(admin.getPassword())) {
				throw new MessageException("密码为空");
			}
			if (findByLoginName(admin.getLoginName()) != null) {
				throw new MessageException("登录名重复");
			}
			admin.setStatus(ObjectStatus.enabled);
			admin.setCreateTime(new Date());
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			adminRepository.save(admin);
		} else {
			Optional<Admin> optional = adminRepository.findById(admin.getId());
			if (!optional.isPresent()) {
				throw new MessageException();
			}
			Admin a = optional.get();
			if (StringUtils.isNotEmpty(admin.getPassword())) {
				a.setPassword(passwordEncoder.encode(admin.getPassword()));
			}
			a.setStatus(admin.getStatus());
			adminRepository.save(a);
		}
	}

	@Override
	public void updateLastLoginTime(String id, Date date) {
		adminRepository.updateLastLoginTime(id, date);
	}

}
