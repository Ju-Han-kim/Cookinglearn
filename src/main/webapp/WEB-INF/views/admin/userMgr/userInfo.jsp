<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />	

	<!-- content -->
	<div class="content">
		<h3>고객상세정보</h3>
		<fieldset>
			<legend>상세내역</legend>
			
			<h3>계정 정보</h3>
			<table border=1>
				<tr>
					<th>아이디</th>
					<th>닉네임</th>
					<th>성별</th>
					<th>보유적립금</th>
					<th>가입일자</th>
				</tr>
				<tr>
					<td>${userInfo.userId}</td>
					<td>${userInfo.nickname}</td>
					<td>
						<c:if test="${userInfo.gender}">
							남자
						</c:if>
						<c:if test="${!userInfo.gender}">
							여자
						</c:if>
					</td>
					<td>
						<fmt:formatNumber pattern="#,###" value="${userPoint}" />점
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${userInfo.regDate}"/> 
					</td>
				</tr>
			</table>
			
			<fieldset>
				<legend>관리자권한 설정</legend>
				<div id="adminArea">
					<c:if test="${userInfo.adminLevel == 0}">
						이 계정은 일반계정입니다. 관리자권한을 부여하시겠습니까? <button id="grant-admin-btn">권한부여</button>
					</c:if>
					<c:if test="${userInfo.adminLevel > 0}">
						이 계정은 관리자계정입니다. 관리자권한을 회수하시겠습니까? <button id="revoke-admin-btn">권한회수</button>
					</c:if>
				</div>
			</fieldset>
			
			<h3>주문내역</h3>
			<c:if test="${fn:length(orderInfo) != 0}">
				<table border=1>
					<tr>
						<th>순번</th>
						<th>강의종류</th>
						<th>카테고리</th>
						<th>강의이름</th>
						<th>결제일자</th>
						<th>결제방법</th>
						<th>결제금액</th>
						<th>적립금사용액</th>
						<th>진행상태</th>
					</tr>
					<c:forEach var="order" items="${orderInfo}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>
								<c:if test="${order.classType}">
									온라인
								</c:if>
								<c:if test="${!order.classType}">
									오프라인
								</c:if>
							</td>
							<td>${order.classCategory}</td>
							<td>${order.className}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${order.paymentDate}" />
							</td>
							<td>${order.paymentMethod}</td>
							<td>
								<fmt:formatNumber pattern="#,###" value="${order.payment}"/>원
							</td>
							<td>
								<fmt:formatNumber pattern="#,###" value="${order.pointUse}"/>점
							</td>
							<td>${order.getProcess(order.orderProcess)}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${fn:length(orderInfo) == 0}">
				등록한 강의가 없습니다.
			</c:if>
			
			<h3>작성한 리뷰</h3>
			<c:if test="${fn:length(reviewInfo) != 0}">
				<table border=1>
					<tr>
						<th>순번</th>
						<th>강의종류</th>
						<th>카테고리</th>
						<th>강의이름</th>
						<th>내용</th>
						<th>별점</th>
						<th>작성일자</th>
					</tr>
					<c:forEach var="review" items="${reviewInfo}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>
								<c:if test="${review.classType}">
									온라인
								</c:if>
								<c:if test="${!review.classType}">
									오프라인
								</c:if>
							</td>
							<td>${review.classCategory}</td>
							<td>${review.className}</td>
							<td>${review.reviewComment}</td>
							<td>${review.reviewStar}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${review.regDate}" />
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${fn:length(reviewInfo) == 0}">
				작성된 리뷰가 없습니다.
			</c:if>
			
			<h3>문의내역</h3>
			<c:if test="${fn:length(qnaInfo) != 0}">
				<table border=1>
					<tr>
						<th>순번</th>
						<th>문의제목</th>
						<th>작성일자</th>
						<th>답변여부</th>
					</tr>
					<c:forEach var="qna" items="${qnaInfo}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${qna.title}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${qna.regDate}" />
							</td>
							<td>
								<c:if test="${qna.answer == null}">
									N
								</c:if>
								<c:if test="${qna.answer != null}">
									Y
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${fn:length(qnaInfo) == 0}">
				작성된 문의가 없습니다.
			</c:if>
		</fieldset>
		<button id="list-btn">목록</button>
	
	</div>

<jsp:include page="../include/footer.jsp" />	

<script>

	const userPath = "${userPath}";
	const userNo = "${userInfo.userNo}";

	$(function() {
		
		//목록으로 이동
		$("#list-btn").click(function() {
			location.href="/admin/user/"+ userPath;
		});
		
		//관리자 권한부여 클릭 시
		$("#grant-admin-btn").click(function() {
			grantAdmin();
		});
		
		//관리자 권환회수 클릭 시
		$("#revoke-admin-btn").click(function() {
			grantAdmin();
		});
		
	});
	
	//관리자권한부여
	function grantAdmin() {
		if(confirm("정말 관리자권한을 부여하시겠습니까?")){
			$.ajax({
				type: "POST",
				data: {
					"userNo": userNo,
					"adminLevel": 1
				},
				url: "/admin/user/setadmin",
				success: function() {
					alert("관리자권한이 부여되었습니다!");
					$("#adminArea").html("이 계정은 관리자계정입니다. 관리자권한을 회수하시겠습니까? <button id='revoke-admin-btn'>권한회수</button>");
					$("#revoke-admin-btn").click(function() {
						revokeAdmin();
					});
				},
				error: function() {
					alert("다시 시도해주세요");
				}
			});
		}
	}
	
	//관리자권한회수
	function revokeAdmin() {
		if(confirm("정말 관리자권한을 회수하시겠습니까?")){
			$.ajax({
				type: "POST",
				data: {
					"userNo": userNo,
					"adminLevel": 0
				},
				url: "/admin/user/setadmin",
				success: function() {
					alert("관리자권한이 회수되었습니다!");
					$("#adminArea").html("이 계정은 일반계정입니다. 관리자권한을 부여하시겠습니까? <button id='grant-admin-btn'>권한부여</button>");
					$("#grant-admin-btn").click(function() {
						grantAdmin();
					});
				},
				error: function() {
					alert("다시 시도해주세요");
				}
			});
		}
	}
	

</script>

