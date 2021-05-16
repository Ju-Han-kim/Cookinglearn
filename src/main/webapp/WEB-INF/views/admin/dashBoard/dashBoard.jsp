<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

		
	<!-- content -->
	<div class="content">
		<h3>오늘의 할 일</h3>
		<table border=1>
			<tr>
				<th>결제완료(ON/OFF)</th>
				<th>오늘의 현강강의</th>
				<th>내일의 현장강의</th>
				<th>완료대기</th>
				<th>반품(ON/OFF)</th>
				<th>신규가입</th>
				<th>문의관리</th>
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
		
		<h3>매출현황</h3>
		<div style="width:550px;height:300px;float:left;">
			<canvas id="myChart"></canvas>
		</div>
		<table border=1>
			<tr>
				<th>날짜</th>
				<th>온라인(건/원)</th>
				<th>오프라인(건/원)</th>
				<th>반품(건/원)</th>
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
		<div style="clear:left;">
			<h3>처리할 문의</h3>
			<table border=1>
				<tr>
					<th>문의번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일자</th>
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
			</table>

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
			label: 'online',
			backgroundColor: 'rgb(255, 99, 132)',
			borderColor: 'rgb(255, 99, 132)',
			data: onClass
		},
		{
			label: 'offline',
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










