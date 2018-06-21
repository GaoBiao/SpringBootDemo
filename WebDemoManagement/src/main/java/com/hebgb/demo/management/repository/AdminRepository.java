package com.hebgb.demo.management.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hebgb.demo.management.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

	Admin findByLoginName(String loginName);

	@Modifying
	@Query("update Admin a set a.lastLoginTime=?2 where a.id=?1")
	void updateLastLoginTime(String id, Date date);

}
