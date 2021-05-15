<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/css/user/login.css">
</head>

<body>

<div class="wrapper">
	<form action="<c:url value="/user/loginCheck"/>" method="post">
	<div class="wrap">
		<div class="logo_wrap">
			<span>쿠킹런</span>
		</div>
		<div class="login_wrap"> 
			<div class="id_wrap">
				<div class="id_input_box">
					<input type="text" name="userId" class="id_input" placeholder="이메일 계정을 입력해주세요." size="30"/>
				</div>
			</div>
			<div class="pw_wrap">
				<div class="pw_input_box">
					<input type="password" name="userPassword" class="pw_input" placeholder="비밀번호를 입력해주세요." size="30"/>
				</div>
			</div>
			<div class="login_submit_wrap">
				<input type="submit" class="login_submit" value="로그인" />
			</div>			
		</div>
		
		
	</div>
	</form>
	<div class="button_wrap">
		<div style="display: inline-block">
		    <input type="button" onclick="location.href='<c:url value="/user/join"/>'" value="회원 가입" class="join_button"/>
		</div>
		<div style="display: inline-block">
     		<input type="button" onclick="location.href='<c:url value=""/>'" value="비밀번호 찾기" class="pwFind_button"/>
		</div>
	</div>
</div>



	
	
	
	
	
	
	

<script>
		const result = "${msg}"
		if(result === "idFail"){
			alert("가입되지 않은 아이디입니다. 회원가입을 해주세요!");
		} else if(result==="pwFail") {
			alert("비밀번호가 일치 하지 않습니다!")
		}
</script>

</body>
</html>