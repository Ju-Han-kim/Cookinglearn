<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<!-- content -->
	<div class="content">
		<h3>오프라인 강의관리</h3>
		<%-- 
		<ul class="nav nav-tabs nav-justified">
			<li class="nav-item"><a href="#" class="nav-link active">링크1</a> </li>
			<li class="nav-item"><a href="#" class="nav-link">링크2</a> </li>
			<li class="nav-item"><a href="#" class="nav-link disabled">링크3</a> </li>
		</ul>
		--%>
		<!-- 임시메뉴 -->
		<a href="<c:url value='/admin/class/off1' />">예정강의</a> 
		<a href="<c:url value='/admin/class/off2' />">완료대기</a>
		<a href="<c:url value='/admin/class/off3' />">완료강의</a>
		<br>
		<form>
			<fieldset>
				<legend>강의검색</legend>
					강의일자 : <input id="seDate" name="seDate" size=17 value="${search.seDate}" readonly><br/>
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
			<input type="submit" value="검색" />
		</form>
			
		<div class="content-list">
			
			<table border=1>
				<tr>
					<th>고유번호</th>
					<th>카테고리</th>
					<th>강의이름</th>
					<th>수강비용</th>
					<th>강의일자</th>
					<th>비고</th>
				</tr>
				
				<c:forEach var="classInfo" items="${classList}">
					<tr>
						<td>${classInfo.classCode}</td>
						<td>${classInfo.classCategory}</td>
						<td>
							<a href="<c:url value='/admin/class/off/${classInfo.classCode}${pageMgr.mkClassUri(pageMgr.paging.currentPage)}&offOption=${offOption}' />">${classInfo.className}</a>
						</td>
						<td>${classInfo.price}</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${classInfo.startDate}"/>
						</td>
						<td>
							<c:if test="${offOption == 2}">
								<button>상세정보</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="paging">
				<c:if test="${pageMgr.prev}">
					<a href="<c:url value='/admin/class/off${offOption}${pageMgr.mkClassUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
					<a href="<c:url value='/admin/class/off${offOption}${pageMgr.mkClassUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
				</c:if>
				<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
					<a href="<c:url value='/admin/class/off${offOption}${pageMgr.mkClassUri(page)}'/>">${page}</a>
				</c:forEach>
				<c:if test="${pageMgr.next}">
					<a href="<c:url value='/admin/class/off${offOption}${pageMgr.mkClassUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
					<a href="<c:url value='/admin/class/off${offOption}${pageMgr.mkClassUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
				</c:if>
			</div>
		</div>
		<button id="reg-btn">강의등록</button>
	</div>

<jsp:include page="../include/footer.jsp" />	

<script>
	
	$(function() {
		
		const offOption = "${offOption}";
		const now = getFormatDate(new Date());
		
		let option = {
				locale: {
					"separator": " ~ ",
					"format": 'YYYY-MM-DD', 
					"applyLabel": "확인",    
					"cancelLabel": "취소",   
					"daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
					"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
					},
				showDropdowns: true
		};
		
		if(offOption === 1) {
			option["minDate"] = new Date(now);
		} else if(offOption === 2) {
			option["maxDate"] = new Date(now);
		} else if(offOption === 3) {
			option["maxDate"] = new Date(now);
		}

		$("#seDate").daterangepicker(option);
		
		
		$("#reg-btn").click(function() {
			location.href="/admin/class/regoff";
		});
		
	});
	
	function getFormatDate(date){
	    let year = date.getFullYear(); 
	    let month = (1 + date.getMonth());    
	    month = month >= 10 ? month : '0' + month;
	    let day = date.getDate();     
	    day = day >= 10 ? day : '0' + day; 
	    return  year + '-' + month + '-' + day;
	}
	
	const msg = "${msg}";
	
	if(msg === "noClass"){
		alert('유효하지 않은 값입니다. 다시 확인해주세요');
	} else if(msg === "deleteSuccess"){
		alert('성공적으로 삭제되었습니다!');
	} else if (msg === "deleteFail"){
		alert('신청인원이 있어 강의삭제가 불가능합니다.');
	}
	
</script>








