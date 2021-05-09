<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	
</head>
<body>
<h1>
	Hello world!  
</h1>
<div class="login_area">
	<div class="login_button">
		<a href="<c:url value="/user/login"/>">로그인하기</a>
	</div>
	<span>
		<a href="<c:url value="/user/join"/>">회원가입</a>
	</span>
</div>

${login.userId}

</body>
</html>
