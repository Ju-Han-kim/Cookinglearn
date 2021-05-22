<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />


	<!-- Mypage -->
    <div class="mypage__wrapper">
      <ul class="mypage__navmenu__sidebar">
        <h3>안녕하세요 <c:out value="${login.nickname}"/>님!</h3>
        <p>내 포인트: 2100p</p>
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
            <div class="classes_wrap_left">
              <div class="class_left">
                  <div class="class">
                    <div class="class_thumb">
                      <img src="https://www.kikkoman.eu/fileadmin/_processed_/0/0/csm_WEB_Traditional_Fukuoka_Ramen_646cd39e6b.jpg" alt="클래스 썸네일">
                    </div>
                    <div class="class_contents">
                      <div class="class_title">
                        <h4>일본 나가사키 전통 라멘! 나카무라 센세이의 라멘 클래스</h4>
                      </div>
                      <div class="class_button_wrap">
                        <button class="button_left">시청하기</button>
                        <button class="button_right">삭제하기</button>
                      </div>
                    </div>
                  </div>
              </div>                
            </div>
          </div>
          <div class="classes_right">
            <h2>대기중인 클래스</h2>
            <div class="classes_wrap_right">
              <div class="class_right">
                <div class="class">
                  <div class="class_thumb">
                    <img src="https://qtmd.org/wp-content/uploads/2019/07/howcuttingdo.jpg" alt="클래스 썸네일">
                  </div>
                  <div class="class_contents">
                    <div class="class_title">
                      <h4>일본 나가사키 전통 라멘! 나카무라 센세이의 라멘 클래스</h4>
                    </div>
                    <div class="class_button_wrap">
                      <button class="button_left">수강동의</button>
                      <button class="button_right">반품하기</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
	
	
<jsp:include page="../include/footer.jsp" />