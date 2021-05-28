<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-12">
				<div class="card border-secondary mb-3">
					<div class="card-header">
						<strong>문의관리</strong> > 
						<a class="btn btn-sm btn-outline-info ${!search.complete?'active':''}" href="<c:url value='/admin/qna/' />"> 미처리문의 </a> / 
						<a class="btn btn-sm btn-outline-info ${search.complete?'active':''}" href="<c:url value='/admin/qna/?complete=true' />"> 처리문의 </a>
					</div>
					<div class="card-body text-secondary">
						<form>
							<div class="form-group row">
								<label class="col-sm-1 col-form-label">상품검색</label> 
								<div class="input-group mb-3 col-sm-11">
									<div class="input-group-prepend">
										<select class="custom-select" name="condition">
											<option value="writer" ${param.condition == 'writer'?'selected':''}>작성자</option>
											<option value="titleContent" ${param.condition == 'titleContent'?'selected':''}>제목+내용</option>
										</select>
									</div>
									<input name="keyword" class="form-control" placeholder="검색어를 입력해주세요" value="${param.keyword}"/>
									<input type="hidden" name="currentPage" value="${pageMgr.paging.currentPage}">
									<input type="hidden" name="messagePerPage" value="${pageMgr.paging.messagePerPage}">
								</div>
							</div>
							<input type="submit" class="btn btn-outline-secondary btn-block submit-btn" value="검색" />
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<c:if test="${fn:length(qnaList) != 0}">
			<c:forEach var="qna" items="${qnaList}">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong>${qna.writer}</strong> - <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${qna.regDate}"/><br>
							</div>
							<div class="card-body">
								<h5 class="card-title"><strong>${qna.title}</strong></h5>
								${qna.qnaContent}
								<hr>
								<div class="col" id="area${qna.qnaNo}" style="text-align: left;">
									<c:if test="${!search.complete}">
										<button class="comment-btn" id="comment${qna.qnaNo}">답글달기></button>
									</c:if>
									<c:if test="${search.complete}">
										<strong>답글</strong> - <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${qna.answerDate}"/><br>
										${qna.answer}
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div><br>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(qnaList) == 0}">
			<div class="row">
				<div class="col-md-12 text-center">
					<div class="card border-secondary mb-3">
						<div class="card-header"><strong>모두 처리되었습니다.</strong></div>
					</div>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-12 text-center">
				<nav class="page-nav" style="display:inline-block;">
					<ul class="pagination">
						<c:if test="${pageMgr.prev}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(1)}'/>"><i class="fas fa-angle-double-left"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.startPage-1)}'/>"><i class="fas fa-angle-left"></i></a>
							</li>
						</c:if>
						<c:forEach var="page" begin="${pageMgr.startPage}" end="${pageMgr.endPage}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(page)}'/>">${page}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMgr.next}">
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.endPage+1)}'/>"><i class="fas fa-angle-right"></i></a>
							</li>
							<li class="page-item">
								<a class="page-link" href="<c:url value='/admin/qna/${pageMgr.mkQnaUri(pageMgr.totalPage)}'/>"><i class="fas fa-angle-double-right"></i></a>
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
		
		//답글달기 버튼 클릭 시 이벤트처리
		$(".comment-btn").click(function() {
			
			const id = $(this).attr("id").substring(7);
			
			let answerInputForm = "<textarea class='form-control' rows='4' id='answer"+id+"'></textarea><br>"+
			"<button class='btn btn-outline-secondary btn-block submit-btn' id='submit"+id+"'\">작성</button>";
			
			//입력 폼으로 변경
			$("#area"+id).html(answerInputForm);
			
			//생성된 폼에 입력된 데이터 저장 
			$(".submit-btn").click(function() {
				
				if(confirm('답변을 등록하시겠습니까?')){
					
					const id = $(this).attr("id").substring(6);
					const answer = $("#answer"+id).val();
					
					$.ajax({
						type: "POST",
						headers: {
							"Content-Type": "application/json"
						},
						dateType: "text",
						url: "/admin/qna/updateAnswer",
						data: JSON.stringify({
							"qnaNo": id,
							"answer": answer
						}),
						success: function(returnAnswer) {
							alert("성공적으로 작성되었습니다!");
							$("#area"+id).html(returnAnswer);
						},
						error: function() {
							console.log("답글작성: 통신실패");
						}
					});
				}
				
			});
			
		});
		
		
		
	});
	
	
</script>













