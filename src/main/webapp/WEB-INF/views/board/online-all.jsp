<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/board/css/style.css">
<script type="text/javascript">
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="/board/online-all?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>
</head>

<body>

<!-- Header -->
<jsp:include page="../include/header.jsp" />
<!-- Content Area -->
<div class="container">
	<div id="contents_area_full" style="clear: both">
	<div class="contents_title">
		전체 클래스
	</div>
	<div class="class_list">
	<div class="class_container">
	   	<c:forEach items="${list}" var = "list">
	    <div align="center" class="class_item">
				<a href="/board/viewDetail?viewDetail=${list.classCode}">
					<img src="<spring:url value='/resources/board/img/${list.thumbnailImg}'/>" class="img-thumbnail" alt="Cinque Terre" width="200" height="auto"> <br/>
						${list.className} 
					<div class="cli_caption_price_box">
	                  	<strong class="cli_caption_price">
							${list.price}
							<small>
								원
							</small> 
						</strong>
					</div>
				</a>
		</div>
		</c:forEach>
	</div>

	<div class="container">	
		<ul class="pagination">	
		<c:if test="${paging.startPage != 1 }">
			<li class="page-item disabled">
				<a href="/board/online-all?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">
					${p }
				</a>
			</li>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<li class="page-item active"><a class="page-link">${p}</a></li>
				</c:when>
				<c:when test="${p != paging.nowPage}">
					<li class="page-item">
						<a class="page-link" href="/board/online-all?nowPage=${p }&cntPerPage=${paging.cntPerPage}">
							${p}
						</a>
					</li>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<li class="page-item">
				<a class="page-link" href="/board/online-all?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">
					다음				
				</a>
			</li>
		</c:if>
		</ul>
	</div>
	
	</div>
	</div>
</div>
<!-- footer -->
<jsp:include page="../include/footer.jsp" />

</body>
</html>