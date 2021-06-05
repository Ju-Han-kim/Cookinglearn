<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/board/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<%-- Header --%>
<jsp:include page="../include/header.jsp" />
<div class="class_list">
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
					강의시간 : 
				</p>
			</td>
			<td>
				<p>
					<img src="/resources/board/icon/calender.png"> 카테고리 : ${detail.classCategory}
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
	<form action="ReviewInsert" method="post" id="reviewForm">
	<div class="input-group mb-3">
		<br>
		<input type="checkbox" name="area" class="checkStar" id="box1"><label for="box1"></label>
		<input type="checkbox" name="area" class="checkStar" id="box2"><label for="box2"></label>
		<input type="checkbox" name="area" class="checkStar" id="box3"><label for="box3"></label>
		<input type="checkbox" name="area" class="checkStar" id="box4"><label for="box4"></label>
		<input type="checkbox" name="area" class="checkStar" id="box5"><label for="box5"></label>
		<input type="hidden" name="reviewStar" id="star" value="0">
		<input type="hidden" name="classCode" value="${detail.classCode}">
		<input type="text" class="form-control" name="reviewComment" id="reviewComment1" placeholder="댓글을 입력하세요.">
		<div class="input-group-append">
			<button class="btn btn-success" id="reviewInsert">작성</button>
			<br>
		</div>
	</div>
	</form>
	<div class="row">
		<c:forEach items="${review}" var="reviewList">
		<div class="col-md-11">
				<img src="/resources/board/icon/person_m.png">
				${reviewList.writer}
				<br>
				<c:if test="${reviewList.reviewStar eq 0}">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
				</c:if>
				<c:if test="${reviewList.reviewStar eq 1}">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
				</c:if>
				<c:if test="${reviewList.reviewStar eq 2}">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
				</c:if>
				<c:if test="${reviewList.reviewStar eq 3}">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
				</c:if>
				<c:if test="${reviewList.reviewStar eq 4}">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_off.png" width="10">
				</c:if>
				<c:if test="${reviewList.reviewStar eq 5}">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
					<img src="/resources/board/icon/star_on.png" width="10">
				</c:if>
				${reviewList.reviewComment}
			</div>
			<div class="col-md-11">
				<img src="/resources/board/icon/person_m.png">
				${reviewList.writer} <br> ${reviewList.reviewComment}
			</div>
			<div class="col-md-1">
				<c:if test="${login.nickname eq reviewList.writer}">
				<form id="deleteForm" action="reviewDelete" method="post">
					<input type="hidden" name="reviewNo" value="${reviewList.reviewNo}">
					<button id="reviewDelete" type="button" class="btn btn-danger" >삭제</button>
				</form>
				</c:if>
			</div>
		</c:forEach>
	</div>
</div>
</div>
<%-- footer --%>
<jsp:include page="../include/footer.jsp" />


<script type="text/javascript">
	$(function() {
		$("#reviewInsert").click(function() {
			const starVal = $("input:checkbox[name='area']:checked").length;
			$("#star").attr("value", starVal);
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
		});
		
		$("#reviewDelete").click(function() {
			if(confirm('댓글을 정말 삭제하시겠습니까?')){
				$("#deleteForm").submit();
			}
		});
		
		//별점체크
		$(".checkStar").click(function() {
			const chId = $(this).attr("id").substring(3);
			
			if(chId > 1 && $(this).is(":checked")){
				for(let i=1; i<=parseInt(chId)-1; i++){
					$("#box"+i).prop("checked", true);
				}
			}
			
			if(chId < 5 && !$(this).is(":checked")){
				for(let i=parseInt(chId)+1; i<=5; i++){
					$("#box"+i).prop("checked", false);
				}
			}
		});
		
	});
	
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
	
	
</script>