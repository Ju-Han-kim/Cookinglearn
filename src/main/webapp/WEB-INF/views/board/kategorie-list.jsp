<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
</head>
<body>
<!-- Header -->
<jsp:include page="../include/header.jsp" />
<section id="container">

<table>
	<c:forEach items="${kategorie}" var = "list">
	<a href="/board/viewDetail?viewDetail=${list.classCode}">
		<img src="<spring:url value='/resources/board/img/${list.thumbnailImg}'/>"> <br/>
		<p>${list.className}
		<br/>${list.price}원</p>
	</a>
	</c:forEach>
</table>

</section>
	
	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />	
</body>
</html>