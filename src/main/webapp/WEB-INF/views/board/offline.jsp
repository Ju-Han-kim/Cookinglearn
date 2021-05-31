<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" type="text/css" href="/board/css/style.css">
</head>
<body>
<!-- Header -->
<jsp:include page="../include/header.jsp" />
<!-- Content Area -->
<div class="container">
	<div id="contents_area_full" style="clear: both">
	<div class="contents_title">
		클래스
	</div>
	<div class="class_list">
	<div class="class_container">
	   	<c:forEach items="${getOfflineClass}" var="list">
	    <div class="class_item">
				<a href="/board/offline-detail?viewDetail=${list.classCode}">
					<img src="<spring:url value='/resources/board/img/${list.thumbnailImg}'/>" class="img-thumbnail" alt="Cinque Terre" width="200" height="auto"> <br/>
					<div class="cli_caption_title"> 
						${list.className} 
					</div>
					<div class="cli_caption_price_box">
	                  	<strong class="cli_caption_price">
							${list.price}
							<small>
								원
							</small> 
						</strong>
					</div>
				</a>
		</div>
		</c:forEach>
	</div>
	</div>
	</div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp" />
</body>
</html>