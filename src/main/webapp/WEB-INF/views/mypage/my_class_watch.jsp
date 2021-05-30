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
          <a href="<c:url value="/user/myqna" />"><i class="fas fa-question-circle"></i>&nbsp;&nbsp;내 문의</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypage" />"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
        </li>
      </ul>
      <div class="mypage__content">
        <div class="classes">
          <div class="classes_left">
            <h2>수강중인 클래스</h2>
            <%--클래스 코드 --%>
            <iframe width="1200" height="720" src="${classUrl}" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
          </div>
        </div>
      </div>
    </div>
	
	
<jsp:include page="../include/footer.jsp" />