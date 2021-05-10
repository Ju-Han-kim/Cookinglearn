<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

		
	<!-- content -->
	<div class="content">
		<h3>문의관리</h3>
		
		<a href="<c:url value='/admin/qna/' />"> 미처리문의 </a>
		<a href="<c:url value='/admin/qna/?complete=true' />"> 처리문의 </a>
					
		<form>
			<select name="condition">
				<option value="writer" ${param.condition == 'writer'?'selected':''}>작성자</option>
				<option value="titleContent" ${param.condition == 'titleContent'?'selected':''}>제목+내용</option>
			</select> &nbsp;
			<input name="keyword" placeholder="검색어를 입력해주세요" value="${param.keyword}"/>&nbsp;
			<input type="submit" value="검색" />
			<input type="hidden" name="currentPage" value="${pageMgr.paging.currentPage}">
			<input type="hidden" name="messagePerPage" value="${pageMgr.paging.messagePerPage}">
		</form><br/>
			
		<div class="content-list">
			
			<!-- 내용 출력부 -->
			<hr>
			<c:forEach var="qna" items="${qnaList}">
				<div style="text-align: left;">
					<strong>${qna.writer}</strong> - <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${qna.regDate}"/><br>
					<strong>${qna.title}</strong><br>
					<p>${qna.qnaContent}</p>
				</div>
				<hr>
			</c:forEach>
			
			<div class="paging">
				<c:if test="${pageMgr.prev}">
					<a href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
					<a href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
				</c:if>
				<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
					<a href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(page)}'/>">${page}</a>
				</c:forEach>
				<c:if test="${pageMgr.next}">
					<a href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
					<a href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
				</c:if>
			</div>
		</div>
	</div>

<jsp:include page="../include/footer.jsp" />	







