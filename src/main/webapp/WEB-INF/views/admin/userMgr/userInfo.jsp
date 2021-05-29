<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>고객상세정보</strong></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header">
						<strong>
							계정 정보 / <c:if test="${userInfo.deleteAccount}">탈퇴한 회원입니다</c:if>
						</strong>
					</div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<table class="table table-bordered">
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">닉네임</th>
									<th scope="col">성별</th>
									<th scope="col">보유적립금</th>
									<th scope="col">가입일자</th>
									<c:if test="${userInfo.deleteAccount}">
										<th scope="col">탈퇴일자</th>
									</c:if>
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
									<c:if test="${userInfo.deleteAccount}">
										<td><fmt:formatDate pattern="yyyy-MM-dd(E)" value="${userInfo.deleteDay}"/></td>
									</c:if>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-md-11">
						<div class="card border-secondary mb-3">
							<div class="card-header"><strong>관리자권한</strong></div>
							<div class="card-body text-secondary">
								<div class="col-md-12" id="adminArea">
									<c:if test="${userInfo.adminLevel == -1}">
										탈퇴한 계정입니다.
									</c:if>
									<c:if test="${userInfo.adminLevel == 0}">
										이 계정은 일반계정입니다. 관리자권한을 부여하시겠습니까? &nbsp;<button class="btn btn-sm btn-outline-danger" id="grant-admin-btn">권한부여</button>
									</c:if>
									<c:if test="${userInfo.adminLevel > 0}">
										이 계정은 관리자계정입니다. 관리자권한을 회수하시겠습니까? &nbsp;<button class="btn btn-sm btn-outline-danger" id="revoke-admin-btn">권한회수</button>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>주문내역</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<c:if test="${fn:length(orderInfo) != 0}">
								<table class="table table-bordered">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">강의종류</th>
										<th scope="col">카테고리</th>
										<th scope="col">강의이름</th>
										<th scope="col">결제일자</th>
										<th scope="col">결제방법</th>
										<th scope="col">결제금액</th>
										<th scope="col">적립금사용액</th>
										<th scope="col">진행상태</th>
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
								주문한 강의가 없습니다.
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>작성한 리뷰</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<c:if test="${fn:length(reviewInfo) != 0}">
								<table class="table table-bordered">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">강의종류</th>
										<th scope="col">카테고리</th>
										<th scope="col">강의이름</th>
										<th scope="col">내용</th>
										<th scope="col">별점</th>
										<th scope="col">작성일자</th>
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
											<td>
												<c:if test="${review.reviewStar != 0}">
													<c:forEach begin="0" end="${review.reviewStar-1}">
														<i class="fas fa-star"></i>
													</c:forEach>
												</c:if>
												<c:if test="${review.reviewStar != 5}">
													<c:forEach begin="${review.reviewStar}" end="4">
														<i class="far fa-star"></i>
													</c:forEach>
												</c:if>
											</td>
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
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>문의내역</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<c:if test="${fn:length(qnaInfo) != 0}">
								<table class="table table-bordered">
									<tr>
										<th scope="col">순번</th>
										<th scope="col">문의제목</th>
										<th scope="col">작성일자</th>
										<th scope="col">답변여부</th>
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
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-outline-primary" id="list-btn">목록</button>
			</div>
		</div>
		<br>
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
			revokeAdmin();
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
					$("#adminArea").html("이 계정은 관리자계정입니다. 관리자권한을 회수하시겠습니까? &nbsp;<button class='btn btn-sm btn-outline-danger' id='revoke-admin-btn'>권한회수</button>");
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
					$("#adminArea").html("이 계정은 일반계정입니다. 관리자권한을 부여하시겠습니까? &nbsp;<button class='btn btn-sm btn-outline-danger' id='grant-admin-btn'>권한부여</button>");
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

