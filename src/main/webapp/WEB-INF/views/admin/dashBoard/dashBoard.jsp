<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>오늘의 할 일</strong></div>
					<div class="card-body text-secondary">
						<div class='col-md-12 text-center'>
							<table class="table table-bordered">
								<tr>
									<th scope="col">결제완료(ON/OFF)</th>
									<th scope="col">오늘의 현강강의</th>
									<th scope="col">내일의 현장강의</th>
									<th scope="col">완료대기</th>
									<th scope="col">반품(ON/OFF)</th>
									<th scope="col">신규가입</th>
									<th scope="col">문의관리</th>
								</tr>
								<tr>
									<td>${todayWork.onComplete + todayWork.offComplete} (  
										<a href="<c:url value='/admin/order/on?orderProcess=0&orderProcess=1&orderProcess=2' />">${todayWork.onComplete}</a> / 
										<a href="<c:url value='/admin/order/off?orderProcess=0&orderProcess=1&orderProcess=2' />">${todayWork.offComplete}</a> )
									</td>
									<td>
										<a href="<c:url value='/admin/class/off1?seDate=${todayWork.StringSeDate(\'today\')}' />">${todayWork.todayOffClass}</a>
									</td>
									<td>
										<a href="<c:url value='/admin/class/off1?seDate=${todayWork.StringSeDate(\'tomorrow\')}' />">${todayWork.tomorrowOffClass}</a>
									</td>
									<td>
										<a href="<c:url value='/admin/class/off2' />">${todayWork.waitForCompletion}</a>
									</td>
									<td>${todayWork.onReturn + todayWork.offReturn} (  
										<a href="<c:url value='/admin/order/on?orderProcess=3&seDate=${todayWork.StringSeDate(\'today\')}' />">${todayWork.onReturn}</a> / 
										<a href="<c:url value='/admin/order/off?orderProcess=3&seDate=${todayWork.StringSeDate(\'today\')}' />">${todayWork.offReturn}</a> )
									</td>
									<td>
										<a href="<c:url value='/admin/user/' />">${todayWork.newUser}</a>
									</td>
									<td>
										<a href="<c:url value='/admin/qna/' />">${todayWork.qnaCount}</a>
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
					<div class="card-header"><strong>매출현황</strong></div>
					<div class="card-body text-secondary">
						<div class="row">
							<div class='col-md-6 text-center'>
								<canvas id="myChart"></canvas>
							</div>
							<div class='col-md-6 text-center'>
								<table class="table table-bordered">
									<tr>
										<th scope="col">날짜</th>
										<th scope="col">온라인(건/원)</th>
										<th scope="col">오프라인(건/원)</th>
										<th scope="col">반품(건/원)</th>
									</tr>
									<c:forEach var="daily" items="${dailySales}">
										<tr>
											<td>
												<fmt:formatDate pattern="yyyy-MM-dd" value="${daily.paymentDate}"/>	
											</td>
											<td>
												<fmt:formatNumber pattern="#,###" value="${daily.onClass}" /> / <fmt:formatNumber pattern="#,###" value="${daily.onPayment}" /></td>
											<td>
												<fmt:formatNumber pattern="#,###" value="${daily.offClass}" /> / <fmt:formatNumber pattern="#,###" value="${daily.offPayment}" /></td>
											<td>
												<fmt:formatNumber pattern="#,###" value="${daily.returnClass}" /> / <fmt:formatNumber pattern="#,###" value="${daily.returnPayment}" /></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>처리할 문의</strong></div>
					<div class="card-body text-secondary">
						<div class='col-md-12 text-center'>
							<c:if test="${fn:length(qnaList) == 0}">
								<h3>처리할 문의가 없습니다</h3>
							</c:if>
							<table class="table table-bordered">
								<c:if test="${fn:length(qnaList) != 0}">
									<tr>
										<th scope="col">문의번호</th>
										<th scope="col">제목</th>
										<th scope="col">내용</th>
										<th scope="col">작성자</th>
										<th scope="col">작성일자</th>
									</tr>
									<c:forEach var="qna" items="${qnaList}">
										<tr>
											<td>${qna.qnaNo}</td>
											<td>${qna.title}</td>
											<td>${qna.qnaContent}</td>
											<td>${qna.writer}</td>
											<td>
												<fmt:formatDate pattern="yyyy-MM-dd" value="${qna.regDate}" />
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<jsp:include page="../include/footer.jsp" />

<script>
	let labels = new Array();
	let onClass = new Array();
	let offClass = new Array();

	<c:forEach var="daily" items="${dailySales}">
		labels.push("<fmt:formatDate pattern="MM/dd" value="${daily.paymentDate}"/>");
		onClass.push("${daily.onClass}");
		offClass.push("${daily.offClass}");
	</c:forEach>
	
	const data = {
		labels: labels,
		datasets: [{
			label: '온라인',
			backgroundColor: 'rgb(255, 99, 132)',
			borderColor: 'rgb(255, 99, 132)',
			data: onClass
		},
		{
			label: '오프라인',
			backgroundColor: 'rgb(100, 100, 132)',
			borderColor: 'rgb(100, 100, 132)',
			data: offClass
		}]
	};

	const config = {
		type: 'line',
		data: data
	};
		
	let myChart = new Chart(document.getElementById('myChart'),config);
	
</script>