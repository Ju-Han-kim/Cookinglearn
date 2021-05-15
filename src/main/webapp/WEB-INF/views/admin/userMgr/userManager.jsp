<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<!-- content -->
	<div class="content">
		<h3>고객관리</h3>
			
		<form>
			<select name="condition">
				<option value="nickname" ${param.condition == 'nickname'?'selected':''}>닉네임</option>
				<option value="userId" ${param.condition == 'userId'?'selected':''}>아이디</option>
			</select> &nbsp;
			<input name="keyword" placeholder="검색어를 입력해주세요" value="${param.keyword}"/>&nbsp;
			<input type="submit" value="검색" />
			<input type="hidden" name="currentPage" value="${pageMgr.paging.currentPage}">
			<input type="hidden" name="messagePerPage" value="${pageMgr.paging.messagePerPage}">
		</form><br/>
			
		<div class="content-list">
			
			<table border=1>
				<tr>
					<th>고유번호</th>
					<th>아이디</th>
					<th>닉네임</th>
					<th>성별</th>
					<th>가입일자</th>
					<th>관리자권한</th>
				</tr>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.userNo}</td>
						<td>${user.userId}</td>
						<td>${user.nickname}</td>
						<td>
							<c:if test="${!user.gender}">남자</c:if>
							<c:if test="${user.gender}">여자</c:if>
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${user.regDate}"/>
							
						</td>
						<td>${user.adminLevel}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="paging">
				<c:if test="${pageMgr.prev}">
					<a href="<c:url value='/admin/user/${pageMgr.mkUserUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
					<a href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
				</c:if>
				<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
					<a href="<c:url value='/admin/user/${pageMgr.mkUserUri(page)}'/>">${page}</a>
				</c:forEach>
				<c:if test="${pageMgr.next}">
					<a href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
					<a href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
				</c:if>
			</div>
		</div>
	</div>

<jsp:include page="../include/footer.jsp" />	