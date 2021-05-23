<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />

	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>주문 상세현황</strong></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>주문자 정보</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<table class="table table-bordered">
								<tr>
									<th scope="col">아이디</th>
									<th scope="col">닉네임</th>
									<th scope="col">성별</th>
									<th scope="col">가입일자</th>
									<th scope="col">비고</th>
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
										<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${userInfo.regDate}"/> 
									</td>
									<td>
										<button class="btn btn-sm btn-outline-secondary" id="userInfo-btn">상세보기</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>강의정보</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<table class="table table-bordered">
								<tr>
									<th scope="col">강의종류</th>
									<th scope="col">카테고리</th>
									<th scope="col">강의이름</th>
									<th scope="col">
										<c:if test="${classInfo.classType}">
											등록일자
										</c:if>
										<c:if test="${!classInfo.classType}">
											강의일자
										</c:if>
									</th>
									<th scope="col">
										<c:if test="${classInfo.classType}">
											수강기간
										</c:if>
										<c:if test="${!classInfo.classType}">
											수강시간
										</c:if>
									</th>
									<th scope="col">가격</th>
									<th scope="col">비고</th>
								</tr>
								<tr>
									<td>
										<c:if test="${classInfo.classType}">
											온라인
										</c:if>
										<c:if test="${!classInfo.classType}">
											오프라인
										</c:if>
									</td>
									<td>${classInfo.classCategory}</td>
									<td>${classInfo.className}</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${classInfo.startDate}" />
									</td>
									<td>
										<c:if test="${classInfo.classType}">
											<fmt:formatNumber pattern="#" value="${classInfo.runTime/60/24}"/>일 
										</c:if>
										<c:if test="${!classInfo.classType}">
											<fmt:formatNumber pattern="#" value="${classInfo.runTime}"/>분
										</c:if>
									</td>
									<td>
										<fmt:formatNumber pattern="#,###" value="${classInfo.price}"/>원
									</td>
									<td>
										<button class="btn btn-sm btn-outline-secondary" id="classInfo-btn">상세보기</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>결제 정보</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<table class="table table-bordered">
								<tr>
									<th scope="col">결제일자</th>
									<th scope="col">결제방법</th>
									<th scope="col">적립금사용액</th>
									<th scope="col">결제금액</th>
									<th scope="col">진행상태</th>
									<th scope="col">
										<c:if test="${orderInfo.orderProcess != 3}">
											수강동의일자
										</c:if>
										<c:if test="${orderInfo.orderProcess == 3}">
											반품일자
										</c:if>
									</th>
								</tr>
								<tr>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.paymentDate}" />
									</td>
									<td>${orderInfo.paymentMethod}</td>
									<td>
										<fmt:formatNumber pattern="#,###" value="${orderInfo.pointUse}"/>점
									</td>
									<td>
										<fmt:formatNumber pattern="#,###" value="${orderInfo.payment}"/>원
									</td>
									<td>${orderInfo.getProcess(orderInfo.orderProcess)}</td>
									<td>
										<c:if test="${orderInfo.limitDate != null}">
											<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.limitDate}" />
										</c:if>
										<c:if test="${orderInfo.limitDate == null}">
											-
										</c:if>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>주문자 리뷰</strong></div>
					<div class="card-body text-secondary">
						<div class="col-md-12 text-center">
							<c:if test="${fn:length(reviewInfo) != 0}">
								<table class="table table-bordered">
									<tr>
										<th scope="col">내용</th>
										<th scope="col">별점</th>
										<th scope="col">작성일자</th>
									</tr>
									<c:forEach var="review" items="${reviewInfo}">
										<tr>
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

	const orderPath = "${orderPath}";
	const classType = "${classInfo.classType?'on':'off'}";
	const classCode = "${classInfo.classCode}";
	
	$(function() {
		
		//목록이동
		$("#list-btn").click(function() {
			location.href="/admin/order/" + classType + orderPath;
		});
		
		//주문자 상세정보 이동
		$("#userInfo-btn").click(function() {
			location.href="/admin/user/"+"${userInfo.userNo}"+"?currentPage=1";
		});
		
		//강의 상세정보 이동
		$("#classInfo-btn").click(function() {
			location.href="/admin/class/"+classType+"/"+classCode+"?currentPage=1";
		});
		
	});

</script>





