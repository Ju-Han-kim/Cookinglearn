<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>
      쿠킹런 - 요리를 배울 수 있는 온오프라인 클래스 | 온오프라인 강의 플랫폼
    </title>
    <meta
      name="description"
      content="요리 입문부터 심화까지 업계 최고 요리사들에게 배울 수 있는 곳. 우리는 맛있고 건강한 매일을 추구합니다...."
    />
    <meta name="author" content="권우희, 김주한, 양다정, 최준우" />
    <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png' />" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="/resources/css/style.css" />
    <link rel="stylesheet" href="/resources/css/banner.css" />
    <link rel="stylesheet" href="/resources/css/user/mypage.css" />
    <script src="<c:url value='/js/main.js'/>" defer></script>
    <script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
    <script src="https://kit.fontawesome.com/bab51a57cc.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <!-- 로그인 전 Header -->
   <c:if test="${empty login}">
      <header id="header">
         <div class="header__brandicon">
            <a href="<c:url value="/"/>"> 
               <img src="<c:url value='/img/brandicon.png'/>" alt="브랜드 로고" width="250px" />
            </a>
         </div>
         <div class="header__right">
            <a class="button--signin" href="<c:url value="/user/login"/>">로그인</a> 
            <a class="button--signup"href="<c:url value="/user/join"/>">회원가입</a>
         </div>
      </header>
   </c:if>
   
   <!-- 로그인 후 Header -->
   <c:if test="${not empty login}">   
      <header id="header">
         <div class="header__brandicon">
            <a href="<c:url value="/"/>"> 
               <img src="<c:url value='/img/brandicon.png'/>" alt="브랜드 로고" width="250px" />
            </a>
         </div>
         <div class="header__right--loggedin">
              <c:if test="${login.adminLevel > 0}">
         	    <a class="admin" href="<c:url value="/admin/" />">
         	      <i id="fas fa-user-cog" class="fas fa-user-cog"></i>
         	    </a>
           	  </c:if>   
              <a class="cart" href="<c:url value="/order/cart" />">
               <i class="fas fa-shopping-cart"></i>
              </a>
              <div class="dropdown">
                   <a class="button--user" href="<c:url value="/user/mypage" />">
                     <i class="fas fa-user"></i>
                   </a>
                   <div class="dropdown-content">
                     <a href="<c:url value="/user/mypage" />"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</a>
                     <a href="<c:url value="/user/myclass" />"><i class="fas fa-book"></i>&nbsp;&nbsp;내 강의</a>
                     <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
                   </div>
              </div>
              <h4><c:out value="${login.nickname}"/>님 환영합니다!</h4>
         </div>
      </header>
   </c:if>
   
   <!-- Navbar-->
    <nav id="navbar">
      <div class="navbar__menu">
        <ul class="navbar__menu">
          <li class="navbar__menu__item"><a href="/board/online-all">전체</a></li>
          <li class="navbar__menu__item"><a href="/board/online-kat?category=한식">한식</a></li>
          <li class="navbar__menu__item"><a href="/board/online-kat?category=분식">분식</a></li>
          <li class="navbar__menu__item"><a href="/board/online-kat?category=중식">중식</a></li>
          <li class="navbar__menu__item"><a href="/board/online-kat?category=일식">일식</a></li>
          <li class="navbar__menu__item"><a href="/board/online-kat?category=양식">양식</a></li>
          <li class="navbar__menu__item"><a href="/board/offline">오프라인</a></li>
        </ul>
      </div>
    </nav>