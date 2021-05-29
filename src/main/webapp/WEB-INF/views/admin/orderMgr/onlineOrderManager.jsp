<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />	
	<div class="container">
		<br>
		<form>
			<div class="row">
				<div class="col-md-12">
					<div class="card border-secondary mb-3">
						<div class="card-header"><strong>온라인 주문관리</strong></div>
						<div class="card-body text-secondary">
							<div class="form-group row">
								<label class="col-sm-1 col-form-label">진행상태</label> 
								<div class="form-check form-check-inline col-sm-4">&nbsp;&nbsp;&nbsp;
									<input type="checkbox" class="form-check-input" name="orderProcess" value=0 ${search.isContain(0)?'checked':''}> &nbsp;
										<label class="form-check-label">결제완료 </label>&nbsp;
									<input type="checkbox" name="orderProcess" value=1 ${search.isContain(1)?'checked':''}> &nbsp;
										<label class="form-check-label"> 수강중 </label>&nbsp;
									<input type="checkbox" name="orderProcess" value=2 ${search.isContain(2)?'checked':''}> &nbsp;
										<label class="form-check-label"> 수강완료 </label>&nbsp;
									<input type="checkbox" name="orderProcess" value=3 ${search.isContain(3)?'checked':''}> &nbsp;
										<label class="form-check-label"> 반품 </label>&nbsp;
							 	</div>
							 	<label class="col-sm-1 col-form-label">결제일자</label>
							 	<div class="form-check form-check-inline col-sm-5">
							 		<input id="seDate" class="form-control" name="seDate" value="${search.seDate}" readonly>
							 	</div>
						 	</div>
							<div class="form-group row">
								<label class="col-sm-1 col-form-label">상품검색</label> 
								<div class="input-group mb-3 col-sm-11">
									<div class="input-group-prepend">
										<select name="condition" class="custom-select">
											<option value="classNameContent" ${param.condition == 'classNameContent'?'selected':''}>강의이름+내용</option>
											<option value="className" ${param.condition == 'className'?'selected':''}>강의이름</option>
											<option value="classContent" ${param.condition == 'classContent'?'selected':''}>강의내용</option>
										</select>
									</div>
									<input name="keyword" class="form-control" placeholder="검색어를 입력해주세요" value="${param.keyword}"/>
									<input type="hidden" name="currentPage" value="${pageMgr.paging.currentPage}">
									<input type="hidden" name="messagePerPage" value="${pageMgr.paging.messagePerPage}">
								</div>
							</div>
							<input type="submit" class="btn btn-outline-secondary btn-block submit-btn" value="검색" />
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-md-12 text-center">
				<c:if test="${fn:length(orderList) != 0}">
					<table class="table table-bordered">
						<tr>
							<th scope="col">고유번호</th>
							<th scope="col">강의이름</th>
							<th scope="col">신청자ID</th>
							<th scope="col">결제일자</th>
							<th scope="col">만료일자</th>
							<th scope="col">진행상태</th>
							<th scope="col">결제금액</th>
						</tr>
						
						<c:forEach var="orderInfo" items="${orderList}">
							<tr>
								<td scope="row">${orderInfo.orderNo}</td>
								<td>
									<a href="<c:url value='/admin/order/${orderInfo.orderNo}${pageMgr.mkOrderUri(pageMgr.paging.currentPage)}' />">${orderInfo.className}</a>
								</td>
								<td>
									<a href="<c:url value='/admin/order/${orderInfo.orderNo}${pageMgr.mkOrderUri(pageMgr.paging.currentPage)}' />">${orderInfo.userId}</a>
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.paymentDate}"/>
								</td>
								<td>
									<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${orderInfo.limitDate}"/>
								</td>
								<td>${orderInfo.getProcess(orderInfo.orderProcess)}</td>
								<td>
									<fmt:formatNumber pattern="#,###" value="${orderInfo.payment}"/>원
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${fn:length(orderList) == 0}">
					<div class="row">
						<div class="col-md-12">
							<div class="card border-secondary mb-3">
								<div class="card-header"><strong>해당되는 내용이 없습니다</strong></div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<nav class="page-nav" style="display:inline-block;">
					<ul class="pagination">
						<c:if test="${pageMgr.prev}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
							</li>
						</c:if>
						<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
							<li class="page-item ${pageMgr.paging.currentPage == page?'active':''}">
								<a class="page-link" href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(page)}'/>">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMgr.next}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/order/on${pageMgr.mkOrderUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
							</li>
						</c:if>
					</ul>
				</nav>
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











