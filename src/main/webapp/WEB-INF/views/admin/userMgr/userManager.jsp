<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<h3>고객관리</h3>
		<div class="row">
			<div class="col-md-12">
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
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<table class="table table-bordered">
					<tr>
						<th scope="col">고유번호</th>
						<th scope="col">아이디</th>
						<th scope="col">닉네임</th>
						<th scope="col">성별</th>
						<th scope="col">가입일자</th>
						<th scope="col">관리자권한</th>
					</tr>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td scope="row">${user.userNo}</td>
							<td>
								<a href="<c:url value='/admin/user/${user.userNo}${pageMgr.mkUserUri(pageMgr.paging.currentPage)}'/>">${user.userId}</a>
							</td>
							<td>${user.nickname}</td>
							<td>
								<c:if test="${user.gender}">남자</c:if>
								<c:if test="${!user.gender}">여자</c:if>
							</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd(E)" value="${user.regDate}"/>
							</td>
							<td>${user.adminLevel}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<nav class="page-nav" style="display:inline-block;">
					<ul class="pagination">
						<c:if test="${pageMgr.prev}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/user/${pageMgr.mkUserUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
							</li>
						</c:if>
						<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
							<li class="page-item ${pageMgr.paging.currentPage == page?'active':''}">
								<a class="page-link" href="<c:url value='/admin/user/${pageMgr.mkUserUri(page)}'/>">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMgr.next}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/user/${pageMgr.mkUserUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
							</li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>

<jsp:include page="../include/footer.jsp" />	