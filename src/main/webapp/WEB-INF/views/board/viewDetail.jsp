<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	
	<div align="center">
		<table style="text-align: center;">
		<tr>
			<td colspan="2">
				<img src="<spring:url value='/resources/board/img/${detail.thumbnailImg}'/>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<h1>${detail.className}</h1>
			</td>
		</tr>
		<tr>
			<td>
				<p>시간 : ${detail.runTime}분</p>
			</td>
			<td>
				<p>강의기간 : 30일</p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>가격 : ${detail.price}</p>
			</td>
		</tr>
		</table>
	</div>
	<br/>
	<div class="container">
	 <table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>상세보기</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>${detail.classContent}</td>
	      </tr>
	    </tbody>
	  </table>
	</div>
	
	<div class="container">
	 <table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>클래스 리뷰</th>
	      </tr>
	    </thead>
	    <tbody>
			 <c:forEach items="${review}" var="reviewList">
		   		<tr>
			     <td>${reviewList.writer} <br/>
			     	 ${reviewList.reviewComment}</td>
				</tr>
			  </c:forEach>
			 </tbody>
	  </table>
	</div>
	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />	
</body>
</html>
