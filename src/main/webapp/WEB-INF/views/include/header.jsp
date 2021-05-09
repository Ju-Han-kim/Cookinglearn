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
    <meta name="author" content="권우희, 김주한, 양다정, 유한기, 최준우" />
    <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png' />" />
    <script
      src="https://kit.fontawesome.com/bab51a57cc.js"
      crossorigin="anonymous"
    ></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
    <link rel="stylesheet" href="/resources/css/style.css" />
    <script src="<c:url value='/js/main.js'/>" defer></script>
    <style type="text/css">
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      ul,
      li {
        list-style: none;
      }

      [name="slide"] {
        display: none;
      }

      .slidebox {
        max-width: 100%;
        width: 100%;
        margin: 0 auto 20px auto;
      }

      .slidebox img {
        max-width: 100%;
      }

      .slidebox .slidelist {
        white-space: nowrap;
        font-size: 0;
        overflow: hidden;
      }

      .slidebox .slideitem {
        position: relative;
        display: inline-block;
        vertical-align: middle;
        width: 100%;
        transition: all 0.35s;
      }

      .slidebox .slideitem label {
        position: absolute;
        z-index: 1;
        top: 45%;
        transition: translateY(-50%);
        padding: 20px;
        border-radius: 50%;
        cursor: pointer;
      }

      label.left {
        left: 20px;
        background-image: url("<c:url value='/img/left-arrow.png'/>");
        background-position: center center;
        background-size: 50%;
        background-repeat: no-repeat;
      }

      label.right {
        right: 20px;
        background-image: url("<c:url value='/img/right-arrow.png'/>");
        background-position: center center;
        background-size: 50%;
        background-repeat: no-repeat;
      }

      [id="slide1"]:checked ~ .slidelist .slideitem {
        transform: translateX(0);
      }
      [id="slide2"]:checked ~ .slidelist .slideitem {
        transform: translateX(-100%);
      }
      [id="slide3"]:checked ~ .slidelist .slideitem {
        transform: translateX(-200%);
      }
      [id="slide4"]:checked ~ .slidelist .slideitem {
        transform: translateX(-300%);
      }

      @keyframes slide1 {
        0% {
          left: 0%;
        }
        23% {
          left: 0%;
        }
        25% {
          left: -100%;
        }
        48% {
          left: -100%;
        }
        50% {
          left: -200%;
        }
        73% {
          left: -200%;
        }
        75% {
          left: -300%;
        }
        98% {
          left: -300%;
        }
        100% {
          left: 0%;
        }
      }

      @keyframes slide2 {
        0% {
          left: 0%;
        }
        23% {
          left: 0%;
        }
        25% {
          left: -100%;
        }
        48% {
          left: -100%;
        }
        50% {
          left: -200%;
        }
        73% {
          left: -200%;
        }
        75% {
          left: 100%;
        }
        98% {
          left: 100%;
        }
        100% {
          left: 0%;
        }
      }

      @keyframes slide3 {
        0% {
          left: 0%;
        }
        23% {
          left: 0%;
        }
        25% {
          left: -100%;
        }
        48% {
          left: -100%;
        }
        50% {
          left: 200%;
        }
        73% {
          left: 200%;
        }
        75% {
          left: 100%;
        }
        98% {
          left: 100%;
        }
        100% {
          left: 0%;
        }
      }

      @keyframes slide4 {
        0% {
          left: 0%;
        }
        23% {
          left: 0%;
        }
        25% {
          left: 300%;
        }
        48% {
          left: 300%;
        }
        50% {
          left: 200%;
        }
        73% {
          left: 200%;
        }
        75% {
          left: 100%;
        }
        98% {
          left: 100%;
        }
        100% {
          left: 0%;
        }
      }

      [id="slide1"]:checked ~ .slidelist .slideitem {
        transform: translateX(0);
        animation: slide1 20s infinite;
      }

      [id="slide2"]:checked ~ .slidelist .slideitem {
        transform: translateX(-100%);
        animation: slide2 20s infinite;
      }

      [id="slide3"]:checked ~ .slidelist .slideitem {
        transform: translateX(-200%);
        animation: slide3 20s infinite;
      }

      [id="slide4"]:checked ~ .slidelist .slideitem {
        transform: translateX(-300%);
        animation: slide4 20s infinite;
      }
    </style>
  </head>
  <body>
    <!-- 로그인 전 Header -->
   <c:if test="${empty login.nickname}">
      <header id="header">
         <div class="header__brandicon">
            <a href=""> 
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
   <c:if test="${not empty login.nickname}">   
      <header id="header">
         <div class="header__brandicon">
            <a href=""> 
               <img src="<c:url value='/img/brandicon.png'/>" alt="브랜드 로고" width="250px" />
            </a>
         </div>
         <div class="header__right--loggedin">
              <a class="cart" href="<c:url value="/order/cart" />">
               <i class="fas fa-shopping-cart"></i>
              </a>
              <div class="dropdown">
                   <a class="button--user" href="/">
                     <i class="fas fa-user"></i>
                   </a>
                   <div class="dropdown-content">
                     <a href="/">마이페이지</a>
                     <a href="/">내 강의</a>
                     <a href="/">로그아웃</a>
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
          <li class="navbar__menu__item"><a href="/">전체</a></li>
          <li class="navbar__menu__item"><a href="/">한식</a></li>
          <li class="navbar__menu__item"><a href="/">분식</a></li>
          <li class="navbar__menu__item"><a href="/">중식</a></li>
          <li class="navbar__menu__item"><a href="/">일식</a></li>
          <li class="navbar__menu__item"><a href="/">양식</a></li>
          <li class="navbar__menu__item"><a href="/">오프라인</a></li>
        </ul>
      </div>
    </nav>