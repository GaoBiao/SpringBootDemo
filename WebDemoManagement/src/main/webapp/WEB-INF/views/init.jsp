<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初始化</title>
</head>

<body>
	<form action="init" method="post">
		<sec:csrfInput />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> <input type="text" name="loginName" placeholder="输入登录名" /> <input type="password" name="password" placeholder="输入密码" />
		<button type="submit">提交</button>
	</form>
</body>
</html>
