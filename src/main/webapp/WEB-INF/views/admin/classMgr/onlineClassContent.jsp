<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<!-- content -->
	<div class="content">
		<h3>온라인 강의 상세현황</h3>
		<div style="border: 1px solid red">
			${classInfo.classCode}번 강의정보 
			<c:if test="${classInfo.classContent != null}">
				${classInfo.classContent}
			</c:if>
		</div>
		<button id="list-btn">목록</button> 
		<button id="update-btn">수정</button> 
		<button id="delete-btn">삭제</button>
		<div style="height:500px; border: 1px solid red">
			신청 수강생 정보 표현
		</div>
		
	</div>

<jsp:include page="../include/footer.jsp" />

<script>
	
	const currentPage = "${param.currentPage}";
	const seDate = "${param.seDate}";
	let messagePerPage = "${param.messagePerPage}";
	const classCategory = "${param.classCategory}";
	const condition = "${param.condition}";
	const keyword = "${param.keyword}";
	
	const msg = "${msg}";
	
	if(msg === "modSuccess"){
		alert("강의수정이 완료되었습니다!");
	}
	
	$(function() {
		
		//강의 리스트로 다시 이동
		$("#list-btn").click(function() {
			
			let classPath = "currentPage="+currentPage
							+"&seDate="+seDate+"&messagePerPage="+messagePerPage
							+"&classCategory="+classCategory
							+"&condition="+condition+"&keyword="+keyword;

			if(messagePerPage == ""){
				classPath = "";
			}
			
			location.href="/admin/class/on?"+classPath;
		});
		
		//해당강의 수정으로 이동
		$("#update-btn").click(function() {
			location.href="/admin/class/modon/${classInfo.classCode}";
		});
		
		//삭제
		$("#delete-btn").click(function() {
			if(confirm('정말 삭제하시겠습니까?')){
				const classCode = "${classInfo.classCode}";
				const classType = "${classInfo.classType}";
				
				location.href="/admin/class/delete?classCode="+classCode+"&classType="+classType;
			}
		});
		
		
		
	});
	
















</script>