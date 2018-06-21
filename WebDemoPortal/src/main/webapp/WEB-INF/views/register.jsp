<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>

<body>
	<form method="post" action="register">
		<input type="text" name="username" placeholder="请输入用户名" /> <input type="password" name="password" placeholder="请输入密码" />
		<button type="submit">注册</button>
	</form>
</body>
</html>
