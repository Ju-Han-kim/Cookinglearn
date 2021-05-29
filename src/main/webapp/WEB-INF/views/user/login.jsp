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
<body>
    <div class="logo">
        <a href="/">CookingLearn</a>
    </div>
    <div class="login_title">
        <h2>로그인</h2>
    </div>
    <form action="<c:url value="/user/loginCheck"/>" method="post">
		<div class="login_wrap"> 
			<input type="text" name="userId" class="id_input" placeholder="이메일 계정을 입력해주세요"/>
			<input type="password" name="userPassword" class="pw_input" placeholder="비밀번호를 입력해주세요"/>
			<input type="submit" class="login_submit" value="로그인" />		
            <hr>
		</div>
	</form>
	<div class="button_wrap">
		<input type="button" onclick="location.href='<c:url value="/user/join"/>'" value="회원 가입" class="join_button"/>
     	<input type="button" onclick="location.href='<c:url value="/user/searchPw"/>'" value="비밀번호 찾기" class="pwFind_button"/>
	</div>
</div>
<script>
		const result = "${msg}"
		if(result === "idFail"){
			alert("가입되지 않은 아이디입니다. 회원가입을 해주세요!");
		} else if(result==="pwFail") {
			alert("비밀번호가 일치 하지 않습니다!")
		} else if(result==="mailAuth") {
			alert("메일인증 후 이용해주세요!")
		}
</script>
</body>
</html>