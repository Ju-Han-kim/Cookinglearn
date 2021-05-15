<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관 동의</title>
</head>
<body>
	<p>"이용약관, 개인정보 수집 및 이용에 모두 동의합니다."
		<input type="checkbox" id="allchk" value="1">
	</p>

	<a href="<c:url value="/user/register"/>">동의합니다.</a>
	
</body>
</html>