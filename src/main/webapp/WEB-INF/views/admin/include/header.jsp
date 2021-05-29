<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>쿠킹런 - 관리자페이지</title>
		<meta name="description"
			content="요리 입문부터 심화까지 업계 최고 요리사들에게 배울 수 있는 곳. 우리는 맛있고 건강한 매일을 추구합니다...." />
		<meta name="author" content="권우희, 김주한, 양다정, 유한기, 최준우" />
		<link rel="icon" type="image/png" href="/admin/img/favicon.png" />
		<script src="https://kit.fontawesome.com/bab51a57cc.js"
			crossorigin="anonymous"></script>
		<link rel="preconnect" href="https://fonts.gstatic.com" />
		<link
			href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap"
			rel="stylesheet" />
		
		<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
		<link rel="stylesheet" href="/admin/css/style.css" />
		
	</head>
	<body>
		<!-- Header -->
		<header id="header">
			<div class="header__brandicon">
				<a href="<c:url value='/'/>"> <img src="<c:url value='/admin/img/brandicon.png'/>"
					alt="브랜드 로고" />
				</a>
			</div>
		</header>
	
		<!-- Navbar-->
		<nav id="navbar">
			<div class="navbar__menu">
				<ul class="navbar__menu">
					<li class="navbar__menu__item ${menu=='DashBoard'?'menu__selected':''}"><a href="<c:url value='/admin/'/>" >현황관리</a></li>
					<li class="navbar__menu__item ${menu=='Class'?'menu__selected':''}">
						<div class="dropdown">
							<a class="dropdown-toggle" href="#" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								강의관리
							</a>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="<c:url value='/admin/class/on'/>">온라인</a>
								<a class="dropdown-item" href="<c:url value='/admin/class/off1'/>">오프라인</a>
							</div>
						</div>
					</li>
					<li class="navbar__menu__item ${menu=='Order'?'menu__selected':''}">
						<div class="dropdown">
							<a class="dropdown-toggle" href="#" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								주문관리
							</a>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
								<a class="dropdown-item" href="<c:url value='/admin/order/on'/>">온라인</a>
								<a class="dropdown-item" href="<c:url value='/admin/order/off'/>">오프라인</a>
							</div>
						</div>
					</li>
					<li class="navbar__menu__item ${menu=='User'?'menu__selected':''}"><a href="<c:url value='/admin/user/'/>">고객관리</a></li>
					<li class="navbar__menu__item ${menu=='Qna'?'menu__selected':''}"><a href="<c:url value='/admin/qna/'/>">문의관리</a></li>
				</ul>
			</div>
		</nav>
