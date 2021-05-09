<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<!-- content -->
	<div class="content">
		<h3>온라인 주문관리</h3>
		<form>
			<fieldset>
				<legend>주문검색</legend>
					진행상태 : 	<input type="checkbox" name="orderProcess" value=0 ${search.isContain(0)?'checked':''}> 결제완료 &nbsp;
								<input type="checkbox" name="orderProcess" value=1 ${search.isContain(1)?'checked':''}> 수강중 &nbsp;
								<input type="checkbox" name="orderProcess" value=2 ${search.isContain(2)?'checked':''}> 수강완료 &nbsp;
								<input type="checkbox" name="orderProcess" value=3 ${search.isContain(3)?'checked':''}> 반품 <br>
					결제일자 : <input id="seDate" name="seDate" size=17 value="${search.seDate}" readonly><br/>
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
					<th>강의이름</th>
					<th>신청자ID</th>
					<th>결제일자</th>
					<th>만료일자</th>
					<th>진행상태</th>
					<th>결제금액</th>
				</tr>
				
				<c:forEach var="orderInfo" items="${orderList}">
					<tr>
						<td>${orderInfo.orderNo}</td>
						<td>${orderInfo.className}</td>
						<td>${orderInfo.userId}</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.paymentDate}"/>
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.limitDate}"/>
						</td>
						<td>${orderInfo.getProcess(orderInfo.orderProcess)}</td>
						<td>${orderInfo.payment}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="paging">
				<c:if test="${pageMgr.prev}">
					<a href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
					<a href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
				</c:if>
				<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
					<a href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(page)}'/>">${page}</a>
				</c:forEach>
				<c:if test="${pageMgr.next}">
					<a href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
					<a href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
				</c:if>
			</div>
		</div>
	</div>

<jsp:include page="../include/footer.jsp" />	

<script>
	
	$(function() {
		
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

		$("#seDate").daterangepicker(option);
		
	});
	
</script>











