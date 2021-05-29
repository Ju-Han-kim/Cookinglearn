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
					<div class="card-header"><strong>오프라인 강의 상세현황</strong></div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-12 text-center">
								<img alt="썸네일" src="${classInfo.thumbnailImg}" width="250px" height="250px">
							</div>
						</div>
						<div class="row text-center">
							<div class="col-md-12">
								<h1>${classInfo.className}</h1>
							</div>
						</div>
						<div class="row text-center">
							<div class="col-md-6">
								<img src="/resources/board/icon/time.png" width="50px" height="50px"> 강의시간 : <fmt:formatNumber pattern="#,###" value="${classInfo.runTime}"/>분
							</div>
							<div class="col-md-6">
								<img src="/resources/board/icon/calender.png" width="50px" height="50px"> 카테고리 : ${classInfo.classCategory}
							</div>
						</div>
						<br>
						<div class="row text-center">
							<div class="col-md-6">
								<img src="/resources/board/icon/buy.png" width="50px" height="50px"> 수강비용 : <fmt:formatNumber pattern="#,###" value="${classInfo.price}"/>원
							</div>
							<div class="col-md-6">
								<img src="/resources/board/icon/person_m.png" width="50px" height="50px"> 최대인원 : ${classInfo.maxStudent}명
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<c:if test="${classInfo.classContent != null}">
									${classInfo.classContent}
								</c:if>
								<c:if test="${classInfo.classContent == null}">
									작성된 내용이 없습니다.
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
				<button class="btn btn-outline-primary" id="list-btn">목록</button> 
				<button class="btn btn-outline-primary" id="update-btn">수정</button> 
				<button class="btn btn-outline-primary" id="delete-btn">삭제</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header"><strong>신청자 현황</strong></div>
					<div class="card-body">
						<div class="row">
							<c:if test="${fn:length(students) != 0}">
								<div class="col-sm-3 text-center">
									<canvas id="myChart"></canvas>
								</div>
								<div class="col-sm-9 text-center">
									<table class="table table-bordered">
										<tr>
											<th scope="col">순번</th>
											<th scope="col">아이디</th>
											<th scope="col">닉네임</th>
											<th scope="col">성별</th>
											<th scope="col">결제일자</th>
											<th scope="col">진행상태</th>
											<th scope="col">비고</th>
										</tr>
										<c:forEach var="student" items="${students}" varStatus="status">
											<tr>
												<td scope="row">${status.count}</td>
												<td>${student.userId}</td>
												<td>${student.nickname}</td>
												<td>
													<c:if test="${student.gender}">남자</c:if>
													<c:if test="${!student.gender}">여자</c:if>
												<td>
													<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${student.paymentDate}" />
												</td>
												<td id="process-td${student.orderNo}">${student.getProcess(student.orderProcess)}</td>
												<td id="process-btn${student.orderNo}">
													<c:if test="${student.orderProcess == 1}">
														<button class="btn btn-sm btn-outline-secondary process-btn" id="${student.orderNo}">완료처리</button>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</c:if>
							<c:if test="${fn:length(students) == 0}">
								<div class="col-sm-12 text-center">
									강의를 신청한 수강생이 없습니다.
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<jsp:include page="../include/footer.jsp" />

<script>

	const currentPage = "${param.currentPage}";
	const seDate = "${param.seDate}";
	const messagePerPage = "${param.messagePerPage}";
	const classCategory = "${param.classCategory}";
	const condition = "${param.condition}";
	const keyword = "${param.keyword}";
	
	const msg = "${msg}";
	
	if(msg === "modSuccess"){
		alert("강의수정이 완료되었습니다!");
	}
	
	$(function() {
		
		let offOption = "${param.offOption}";
		
		if(offOption == ""){
			offOption = 1;
		}
		
		//강의 리스트로 다시 이동
		$("#list-btn").click(function() {

			let classPath = "currentPage="+currentPage
							+"&seDate="+seDate+"&messagePerPage="+messagePerPage
							+"&classCategory="+classCategory
							+"&condition="+condition+"&keyword="+keyword;

			if(messagePerPage == ""){
				classPath = "";
			}
			
			location.href="/admin/class/off"+offOption+"?"+classPath;
		});
		
		//해당강의 수정으로 이동
		$("#update-btn").click(function() {
			location.href="/admin/class/modoff/${classInfo.classCode}";
		});
		
		//삭제
		$("#delete-btn").click(function() {
			if(confirm('정말 삭제하시겠습니까?')){
				const classCode = "${classInfo.classCode}";
				const classType = "${classInfo.classType}";
				
				location.href="/admin/class/delete?classCode="+classCode+"&classType="+classType
						+"&offOption="+offOption;
			}
		});
		
		//프로세스 변경
		$(".process-btn").click(function() {
			if(confirm('수강완료 처리하시겠습니까?')){
				const classCode = "${classInfo.classCode}";
				const orderNo = $(this).attr("id");
				
				const processId = "#process-td"+orderNo;
				const btnId = "#process-btn"+orderNo;
				
				$.ajax({
					type: "POST",
					data:{
						"classCode": classCode,
						"orderNo": orderNo
					},
					url:"/admin/class/orderprocess",
					success: function() {
						alert("성공적으로 수정되었습니다.");
						$(processId).html("수강완료");
						$(btnId).html("");
					},
					error: function() {
						console.log("통신오류 : 프로세스변경");
					}
				});
				
			}
		});
		
	});
	
	let male = 0;
	let female = 0;

	<c:forEach var="student" items="${students}">
		${student.gender}?male++:female++;
	</c:forEach>
	
	const datas = [male, female];
	
	const data = {
		labels: ['남', '여'],
		datasets: [{
			label: '신청자 성비',
			data: datas,
			backgroundColor: ['rgb(0, 0, 255)','rgb(255, 0, 0)'],
		}]
	};

	const config = {
		type: 'doughnut',
		data: data,
		options: {
			responsive: true,
			plugins: {
				legend: {
					position: 'bottom',
				},
				title: {
				display: true,
				text: '강의신청자 성비'
				}
			}
		}
	};

	let myChart = new Chart(document.getElementById('myChart'),config);


</script>