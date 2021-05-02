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
				<option value="nickname">닉네임</option>
				<option value="userId">아이디</option>
			</select> &nbsp;
			<input name="keyword" placeholder="검색어를 입력해주세요" />&nbsp;
			<input type="submit" value="검색" />
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
				
				<a href="#"><i class="fas fa-angle-double-left"></i></a>
				<a href="#"><i class="fas fa-angle-left"></i></a>
				
				<a href="#"><i class="fas fa-angle-right"></i></a>
				<a href="#"><i class="fas fa-angle-double-right"></i></a>
			
			</div>
		</div>
	</div>

<jsp:include page="../include/footer.jsp" />	