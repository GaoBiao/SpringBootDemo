package com.hebgb.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hebgb.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>, UserDao {

	User findByUsername(String username);

	@Modifying
	@Query("update User u set u.lastLoginTime=?2 where u.id=?1")
	void updateLastLoginTime(Long id, Date date);

}
