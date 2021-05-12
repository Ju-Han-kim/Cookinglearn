<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

		
	<!-- content -->
	<div class="content">
		<h3>오늘의 할 일</h3>
		<table>
			<tr>
				<th>결제완료(ON/OFF)</th>
				<th>오늘의 현강강의</th>
				<th>내일의 현장강의</th>
				<th>완료대기</th>
				<th>반품</th>
				<th>신규가입</th>
				<th>문의관리</th>
			</tr>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
			</tr>
		</table>
		
		<h3>매출현황</h3>
		<div style="width:550px;height:300px;float:left;">
			<canvas id="myChart"></canvas>
		</div>
		<table>
			<tr>
				<th>날짜</th>
				<th>온라인</th>
				<th>오프라인</th>
				<th>반품</th>
			</tr>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
			</tr>
		</table>
		<div style="clear:left;">
			<h3>처리할 문의</h3>
			<table>
				<tr>
					<th>문의번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일자</th>
				</tr>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
				</tr>
			</table>
		</div>
	</div>
	
<jsp:include page="../include/footer.jsp" />

<script>

	const labels = [
		'day1',
		'day2',
		'day3',
		'day4',
		'day5',
	];
	
	const data = {
		labels: labels,
		datasets: [{
			label: 'online',
			backgroundColor: 'rgb(255, 99, 132)',
			borderColor: 'rgb(255, 99, 132)',
			data: [0, 10, 5, 2, 20]
		},
		{
			label: 'offline',
			backgroundColor: 'rgb(100, 100, 132)',
			borderColor: 'rgb(100, 100, 132)',
			data: [40, 50, 30, 10, 0]
		}]
	};

	const config = {
		type: 'line',
		data: data
	};
		
	let myChart = new Chart(document.getElementById('myChart'),config);


</script>










