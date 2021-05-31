<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="/css/user/point.css" />

 <div class="mypage__wrapper">
      <ul class="mypage__navmenu__sidebar">
        <h3>안녕하세요 <c:out value="${login.nickname}"/>님!</h3>
        <p>내 포인트:&nbsp;&nbsp;<c:out value="${point}"/>p</p>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myclass" />"><i class="fas fa-book"></i>&nbsp;&nbsp;&nbsp;내 강의</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypoint" />"><b style="color: #fcba03;" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='#fcba03'"><i class="fab fa-product-hunt"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내 포인트</b></a>
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
        <div class="points">
        	<c:if test="${not empty pointList}">
        	  <c:forEach var="pointInfo" items="${pointList}">
        		<div class="point">
	                <div class="point_wrap">
	                	<div class="point_detail">
	                		<c:if test="${pointInfo.pointChange >= 0}">
	                			<img src="/img/myPage_point/pointSave.png" alt="point" />
                			</c:if>
	                		<c:if test="${pointInfo.pointChange < 0}">
	                			<img src="/img/myPage_point/pointUse.png" alt="point" />
							</c:if>
	                	</div>
	                    <div class="point_detail">
                             <p> <fmt:formatDate pattern="yyyy-MM-dd(E)" value="${pointInfo.pointDate}"/> 2021.05.31<br><strong> ${pointInfo.pointHistory}</strong></p>
	                    </div>
	                    <div class="point_count">
	                    	<fmt:formatNumber pattern="#,###" value="${pointInfo.pointChange}" />P
	                    </div>
	                </div>
            	</div>
        	</c:forEach>
       	  </c:if>
        </div>
       	<div class="points_not">
       		 <c:if test="${empty pointList}">
           		<h2>포인트 적립내용이 존재하지 않습니다</h2>
        	</c:if>
       	</div>
      </div>
      
      
      
	</div>
	

<jsp:include page="../include/footer.jsp" />
