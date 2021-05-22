<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<h3>온라인 강의관리</h3>
		<form>
			<div class="row">
				<div class='col-md-12'>
					<fieldset>
						<legend>강의검색</legend>
						
							등록일자 : <input id="seDate" name="seDate" size=17 value="${param.seDate}" readonly><br/>
							카테고리 : 
									<select name="classCategory">
										<option value="all" ${param.classCategory == 'all'?'selected':''}>전체</option>
										<option value="한식" ${param.classCategory == '한식'?'selected':''}>한식</option>
										<option value="분식" ${param.classCategory == '분식'?'selected':''}>분식</option>
										<option value="중식" ${param.classCategory == '중식'?'selected':''}>중식</option>
										<option value="일식" ${param.classCategory == '일식'?'selected':''}>일식</option>
										<option value="양식" ${param.classCategory == '양식'?'selected':''}>양식</option>
									</select> <br/>
							상품검색 : 
									<select name="condition">
										<option value="classNameContent" ${param.condition == 'classNameContent'?'selected':''}>강의이름+내용</option>
										<option value="className" ${param.condition == 'className'?'selected':''}>강의이름</option>
										<option value="classContent" ${param.condition == 'classContent'?'selected':''}>강의내용</option>
									</select> &nbsp;
									<input name="keyword" placeholder="검색어를 입력해주세요" value="${param.keyword}"/>&nbsp;
									<input type="hidden" name="currentPage" value="${pageMgr.paging.currentPage}">
									<input type="hidden" name="messagePerPage" value="${pageMgr.paging.messagePerPage}">
					</fieldset>
				</div>
			</div>
			<div class="row">
				<div class='col-md-12'>
					<input type="submit" value="검색" />
				</div>
			</div>
		</form>
		<div class="row">
			<div class='col-md-12 text-center'>
				<table class="table table-bordered">
					<tr>
						<th scope="col">고유번호</th>
						<th scope="col">카테고리</th>
						<th scope="col">강의이름</th>
						<th scope="col">수강기간</th>
						<th scope="col">수강비용</th>
						<th scope="col">등록일자</th>
					</tr>
					
					<c:forEach var="classInfo" items="${classList}">
						<tr>
							<td scope="row">${classInfo.classCode}</td>
							<td>${classInfo.classCategory}</td>
							<td>
								<a href="<c:url value='/admin/class/on/${classInfo.classCode}${pageMgr.mkClassUri(pageMgr.paging.currentPage)}' />">${classInfo.className}</a>
							</td>
							<td>
								<fmt:formatNumber pattern="#" value="${classInfo.runTime/24/60}"/>일
							</td>
							<td>
								<fmt:formatNumber pattern="#,###" value="${classInfo.price}"/>원
							</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${classInfo.startDate}"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row text-center">
			<div class="col-md-12 text-center">
				<nav class="page-nav" style="display:inline-block;">
					<ul class="pagination">
						<c:if test="${pageMgr.prev}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/class/on${pageMgr.mkClassUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/class/on${pageMgr.mkClassUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
							</li>
						</c:if>
						<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
							<li class="page-item ${pageMgr.paging.currentPage == page?'active':''}">
								<a class="page-link" href="<c:url value='/admin/class/on${pageMgr.mkClassUri(page)}'/>">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMgr.next}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/class/on${pageMgr.mkClassUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/class/on${pageMgr.mkClassUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class='col-md-12'>
				<button id="reg-btn">강의등록</button>
			</div>
		</div>
	</div>


<jsp:include page="../include/footer.jsp" />	

<script>
	
	const msg = "${msg}";
	
	if(msg === "noClass"){
		alert('유효하지 않은 값입니다. 다시 확인해주세요');
	} else if(msg === "deleteSuccess"){
		alert('성공적으로 삭제되었습니다!');
	} else if (msg === "deleteFail"){
		alert('신청인원이 있어 강의삭제가 불가능합니다.');
	} else if(msg === "regSuccess"){
		alert("성공적으로 강의가 등록되었습니다!");
	}

	
	$(function() {

		$("#seDate").daterangepicker({

			locale: {
				"separator": " ~ ",
				"format": 'YYYY-MM-DD', 
				"applyLabel": "확인",    
				"cancelLabel": "취소",   
				"daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
				"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
				},
			showDropdowns: true
			
		});
		
		$("#reg-btn").click(function() {
			location.href="/admin/class/regon";
		});
		
	});
	
	
</script>








