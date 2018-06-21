package com.hebgb.demo.management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.hebgb.demo.management.service.IAdminService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IAdminService adminService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomizedUserDetailsService(adminService);
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(MessageSource messageSource) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setMessageSource(messageSource);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// csrf
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
				// auth
				.authorizeRequests()
				// 不限制授权
				.antMatchers("/static/**", "/init").permitAll()
				// 其他请求需要授权
				.anyRequest().authenticated().and()
				// 登录配置
				.formLogin()
				// 登录请求参数
				.usernameParameter("loginName").passwordParameter("password").defaultSuccessUrl("/index")
				// 登录页面
				.loginPage("/login").successHandler(new CustomizedAuthenticationSuccessHandler(adminService)).permitAll().and()
				// 登出配置
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll().and()
				// 支持httpBasic
				.httpBasic();
	}

}
