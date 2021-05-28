<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<%-- Header --%>
<jsp:include page="../include/header.jsp" />

<div align="center">
	<table style="text-align: center;">
		<tr>
			<td colspan="2"><br> <img
				src="<spring:url value='/resources/board/img/${detail.thumbnailImg}'/>">
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
					<img src="/resources/board/icon/time.png"> 
					강의시간 : ${detail.runTime/24/60}분
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
				<form action="cart" method="post" onsubmit="return class_reg();">
					<input type="hidden" name="classCode" value="${detail.classCode}">
					<button id="button" class="btn btn-outline-light text-dark">
						<img src="/resources/board/icon/buy.png"> ${detail.price}원
					</button>
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
				<td>
					<h2>상세보기</h2>
				</td>
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
		<form action="ReviewInsert" method="post" onsubmit="return review_insert();">
		<div class="input-group mb-3">
			<input type="hidden" name="classCode" value="${detail.classCode}">
			<input type="text" class="form-control" name="reviewComment" id="reviewComment1" placeholder="댓글을 입력하세요.">
			<div class="input-group-append">
				<button class="btn btn-success" id="reviewInsert">작성</button>
			</div>
		</div>
		</form>
	<table class="table table-borderless">
		<c:forEach items="${review}" var="reviewList">
			<tr>
				<td><img src="/resources/board/icon/person_m.png">
					${reviewList.writer} <br> ${reviewList.reviewComment}
					
				</td>
				
				<c:if test="${login.nickname eq reviewList.writer}">
				<td>
					<form action="reviewModify">
						<button type="button" class="btn btn-warning">수정</button>
					</form>
						<input type="hidden" name="reviewNo" value="${reviewList.reviewNo}">
						<button id="reviewDelete" type="button" class="btn btn-danger" onclick="reviewDelete();">삭제</button>
				</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</div>
<%-- footer --%>
<jsp:include page="../include/footer.jsp" />


<script type="text/javascript">

	function class_reg() {	
		if ("${login}") {
			alert('장바구니에 담겼습니다.');
			return true;
		} else {
			var returnLogoinPage = confirm('로그인이 필요한 서비스 입니다.\n로그인 창으로 이동하시겠습니까?');
			if(returnLogoinPage) 
				location.href = "/user/login";
			return false;
		}
	}

	function review_insert() {
		const reviewComment = document.getElementById("reviewComment1").value;
		if ("${login}") {
			console.log(reviewComment);
			if (reviewComment == "") {
				alert('내용을 입력해주세요.');
				return false;
			} else {
				alert('댓글이 작성되었습니다.');
				return true;
			}
		} else {
			var returnLogoinPage = confirm('로그인이 필요한 서비스 입니다.\n로그인 창으로 이동하시겠습니까?');
			if(returnLogoinPage) 
				location.href = "/user/login";
			return false;
		}
	}
	
	
	function reviewDelete()  {
		var trueDelete = confirm('댓글을 정말 삭제하시겠습니까?');
		if(trueDelete){
			document.frm.action = "reviewDelete";
			document.frm.method = "post";
			document.frm.submit();
		}
		return false;
	}
	
</script>