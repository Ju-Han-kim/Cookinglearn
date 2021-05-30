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
          <a href="<c:url value="/user/mypage" />"><b style="color: #fcba03;" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='#fcba03'"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</b></a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
        </li>
      </ul>
      <div class="mypage__content">
      	<c:if test="${empty msg || msg == 'pwBlank' || msg == 'pwFail'}">
      		<form id="PwChk_form" method="post">
          		<h3>비밀번호를 입력해주세요</h3>
          		<input type="password" name="password" class="pw_check" placeholder="비밀번호" />
          		<input type="submit" class="PwChk_button" value="제출" />
        	</form>
        	<script>
      		$(function(){
      			if("${msg}" == "pwBlank") { alert("비밀번호를 입력해주세요")};
      			if("${msg}" == "pwFail") { alert("비밀번호가 틀렸습니다")};
      		});
      	</script>
      	</c:if>
      	<c:if test="${msg == 'pwSuccess'}">
      		<div id="my_info">
	          <h3>내 정보 조회</h3>
	          <p id="my_info_id"><i class="fas fa-user-check"></i>&nbsp;&nbsp;아이디:&nbsp;&nbsp;<c:out value="${login.userId}"/></p>
	          <p id="my_info_pw"><i class="fas fa-lock"></i>&nbsp;&nbsp;&nbsp;비밀번호:&nbsp;&nbsp;********</p>
	          <p id="my_info_nk"><i class="fas fa-user-astronaut"></i>&nbsp;&nbsp;&nbsp;닉네임:&nbsp;&nbsp;<c:out value="${login.nickname}"/></p>
	          <p id="my_info_gd"><i class="fas fa-venus-mars"></i>&nbsp;&nbsp;성별:&nbsp;&nbsp;<c:out value="${(login.gender > 0) ? '남성' : '여성' }"/></p>
	          <p id="my_info_rg"><i class="far fa-calendar-check"></i>&nbsp;&nbsp;&nbsp;가입일:&nbsp;&nbsp;<c:out value="${login.regDate}"/></p>
	          <div class="button_wrapper">
	            <button type="button" id="update_info-btn" onclick="location.href='/user/modify'">내 정보 수정</button>
	            <button type="button" id="delete_info-btn" onclick="delete_account();">회원 탈퇴</button>
	            <script>
	            	function delete_account() {
	            		if (!confirm("정말 회원을 탈퇴하시겠습니까?")) {
	            			return
	            	    } else {
	            	    	location.href="/user/delete";
	            	    }
	            	}
	            </script>
          	  </div>
        	</div>
      	</c:if>
      </div>
    </div>
    
<jsp:include page="../include/footer.jsp" />