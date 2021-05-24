<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<%-- 스크립트 코드 --%>
<script>
	function class_reg() {	
		var classCode = document.getElementById("classCode");
		if ("${login}") {
			alert('장바구니로 이동됩니다.');
			return true;
		} else {
			alert('로그인이 필요한 서비스입니다.');
			location.href = "/user/login";
			return false;
		}
	}

	function review() {
		if ("${login}" != "") {
			alert('댓글이 작성되었습니다.');
			//location.href  = "write";
		} else {
			alert('로그인이 필요한 서비스입니다.\n로그인 창으로 이동합니다.');
			location.href = "/user/login";
			//history.back();
		}
	}

	function review_test() {
		if ("${login}") {
			var classCode = document.getElementById("classCode");
			var reviewComment = document.getElementById("reviewComment");

			if ("${reviewComment}") {
				alert('댓글이 작성되었습니다.');
				return true;
			} else {
				alert('내용을 입력해주세요.');
				return false;
			}
		} else {
			alert('로그인이 필요한 서비스 입니다.\n로그인 창으로 이동합니다.');
			location.href = "/user/login";
			return false;
		}
	}
</script>

</head>
<body>

	<%-- Header --%>
	<jsp:include page="../include/header.jsp" />

	<div align="center">
		<table style="text-align: center;">
			<tr>
				<td colspan="2">
					<br>
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
					<p>
						<img src="/resources/board/icon/time.png"> 강의시간 :
						${detail.runTime/24/60}분
					</p>
				</td>
				<td>
					<p>
						<img src="/resources/board/icon/calender.png"> 강의 기간 : 30일
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p>
						<img src="/resources/board/icon/buy.png"> ${detail.price}원</p>
			</tr>
			<tr>
				<td colspan="2">
					<form action="cart" method="post" onsubmit="return class_reg();" >
						<input type="hidden" name="classCode" value="${detail.classCode}"> 
						<button id="button" class="btn btn-warning">수강신청</button>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<div class="container mt-3">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td> <h2>상세보기</h2> </td>
				</tr>
			</thead>
				<tr>
					<td>${detail.classContent}</td>
				</tr>
		</table>
	</div>
	<br>
	<div class="container mt-3">
		<h2>클래스 리뷰</h2>
		<form action="ReviewInsert" method="post" onsubmit="return review_test();" >
	  	<div class="input-group mb-3">
				<input type="hidden" name="classCode" value="${detail.classCode}"> 
		    	<input type="text" class="form-control" name="reviewComment" placeholder="댓글을 입력하세요.">
		    	<div class="input-group-append">
		   		<button class="btn btn-success" id="button">작성</button>  
		    	</div>
	  	</div>
	  </form>
		<table class="table table-borderless">
				<c:forEach items="${review}" var="reviewList">
					<tr>
						<td><img src="/resources/board/icon/person_m.png">
							${reviewList.writer} <br /> ${reviewList.reviewComment}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<%-- footer --%>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>

<%-- 
전 클래스 리뷰 코드
<th>클래스 리뷰<br>
	<form action="ReviewInsert" method="POST">
		<input type="hidden" name="classCode" value="${detail.classCode}">
		<textarea cols="50" rows="1" name="reviewComment" placeholder="댓글을 입력하세요."></textarea>
		<button id="button" class="btn btn-warning" onclick="review();">작성</button>
	</form>
	
	
	현 클래스 리뷰 코드
	<p>클래스 리뷰 테스트</p>
	<div class="form-group position-relative has-icon-left">
		<form action="ReviewInsert" method="post" onsubmit="return review_test();" >
			<input type="hidden" name="classCode" value="${detail.classCode}"> 
			<input type="text" class="form-control" name="reviewComment"	placeholder="댓글을 입력하세요.">
			<button id="button" class="btn btn-warning" >작성</button>
		</form>
	</div>
 --%>