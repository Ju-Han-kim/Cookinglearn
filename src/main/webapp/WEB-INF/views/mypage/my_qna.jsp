<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

	<!-- Mypage -->
    <div class="mypage__wrapper">
      <ul class="mypage__navmenu__sidebar">
        <h3>안녕하세요 <c:out value="${login.nickname}"/>님!</h3>
        <p>내 포인트:&nbsp;&nbsp;<c:out value="${point}"/>p</p>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myclass" />"><i class="fas fa-book"></i>&nbsp;&nbsp;&nbsp;내 강의</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypoint" />"><i class="fab fa-product-hunt"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내 포인트</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypayment" />"><i class="fas fa-receipt"></i>&nbsp;&nbsp;결제 내역</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myqna" />"><b style="color: #fcba03;" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='#fcba03'"><i class="fas fa-question-circle"></i>&nbsp;&nbsp;내 문의</b></a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypage" />"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
        </li>
      </ul>
      <div class="mypage__content">
      	<c:if test="${not empty qna}">
	        <div class="qnas">
	        	<c:forEach var="q" items="${qna}">
	        		<div class="qna">
		                <div class="qna_wrap">
		                    <div class="qna_title">
		                        <p>제목:&nbsp;&nbsp;${q.title}</p>
		                    </div>
		                    <div class="qna_conv">
		                        <div class="qna_user">
		                            <div class="qna_info">
		                                <p>작성자:&nbsp;&nbsp;${q.writer}</p>
		                                <p>작성일:&nbsp;&nbsp;<fmt:formatDate value="${q.regDate}" pattern="yy년 MM월 dd일  HH시 mm분" /></p>
		                            </div>
		                            <div class="qna_content">
		                                <textarea name="" id="user_question" cols="30" rows="6" readonly
		                                >&nbsp;&nbsp;${q.qnaContent}</textarea>
		                            </div>
		                        </div>
		                        <c:if test="${q.answer != null}">
		                        	<div class="qna_sysop">
			                            <div class="qna_info">
			                                <p>작성자: 운영자</p>
			                                <p>작성일:&nbsp;&nbsp;<fmt:formatDate value="${q.answerDate}" pattern="yy년 MM월 dd일  HH시 mm분" /></p>
			                            </div>
			                            <div class="qna_content">
			                                <textarea name="" id="sysop_answer" cols="30" rows="6" readonly
			                                >&nbsp;&nbsp;${q.answer}</textarea>
			                            </div>
		                        	</div>
		                        </c:if>
		                        <c:if test="${q.answer == null}">
		                        	<div class="qna_sysop_not">
		                            	<h4><i class="far fa-meh-rolling-eyes"></i>&nbsp;&nbsp;답장이 아직 도착하지 않았습니다</h4>
		                        	</div>
		                        </c:if>
		                    </div>
		                </div>
	            	</div>
	        	</c:forEach>
	        </div>
        </c:if>
        <c:if test="${empty qna}">
        	<div class="qnas_not">
            	<h2>내 문의가 존재하지 않습니다</h2>
        	</div>
        </c:if>
      </div>
	</div>

<jsp:include page="../include/footer.jsp" />