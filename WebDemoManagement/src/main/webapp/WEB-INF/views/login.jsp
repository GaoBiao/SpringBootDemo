<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>

<body>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }
	 <form action="login" method="post">
		<sec:csrfInput />
		<input type="text" name="loginName" placeholder="输入登录名" /> <input type="password" name="password" placeholder="输入密码" />
		<button type="submit">登录</button>
	</form>
</body>
</html>
