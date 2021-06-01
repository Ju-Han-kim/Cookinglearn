<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
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
    <script
      src="https://kit.fontawesome.com/bab51a57cc.js"
      crossorigin="anonymous"
    ></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap"
      rel="stylesheet"
    />
	<link rel="stylesheet" href="/resources/css/user/login.css">
	<link
      href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap"
      rel="stylesheet"
    />
</head>
<!-- jquery -->
<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
<body>
    <div class="logo">
        <a href="/">CookingLearn</a>
    </div>
    <div class="login_title">
        <h2>비밀번호 찾기 </h2>
    </div>
    <form id="searchPw" method="post" action="/user/searchPw">
    	<div class="login_wrap"> 
			<input type="text" name="userId" class="pw_input" placeholder="아이디(이메일)를 입력해주세요"/>
			<input type="button" class="pw_submit" value="안내 메일 전송" />
		</div>
	</form>
<script>
	const msg = "${param.msg}";
	if(msg === "noId"){
		alert("없는 계정입니다. 아이디를 확인해주세요");
		$(".pw_submit").prop("disabled", false);
	}
	
	$(".pw_submit").click(function(){
		$(".pw_submit").prop("disabled", true);
		$("#searchPw").submit();
	});
	
</script>
</body>
</html>