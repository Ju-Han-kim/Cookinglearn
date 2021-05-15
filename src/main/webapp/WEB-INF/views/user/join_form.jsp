<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="/resources/css/user/join_form.css">
</head>
<!-- jquery -->
<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
<body>

<div class="wrapper">
	<form id="join_form" method="post">
	<div class="wrap">
			<div class="subject">
				<span>회원가입</span>
			</div>
			<div class="id_wrap">
				<div class="id_name">계정</div>
				<div class="id_input_box">
					<input type="text" name="userId" class="id_input">
				</div>
				<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
				<div class="mail_check_wrap">
					<div class="mail_check_input_box" id="mail_check_input_box_false">
						<input class="mail_check_input" disabled="disabled">
					</div>
					<button type="button" class="mail_check_button" disabled="disabled">이메일인증</button>
					
					<div class="clearfix"></div>
				</div>
				
			</div>
			<div class="pw_wrap">
				<div class="pw_name">비밀번호</div>
				<div class="pw_input_box">
					<input type="password" name="userPassword" class="pw_input">
				</div>
			</div>
			<div class="pwck_wrap">
				<div class="pwck_name">비밀번호 확인</div>
				<div class="pwck_input_box">
					<input type="password" class="pwck_input">
				</div>
			</div>
			<div class="nick_wrap">
				<div class="nick_name">닉네임</div>
				<div class="nick_input_box">
					<input type="text" name="nickname" class="nick_input">
				</div>
			</div>
			<div class="gender_wrap">
				<div class="gender_name">성별</div> 
				<div class="gender_radio_box">
					<input type="radio" name="gender" class="gender_male_radio" value="1"> 남&nbsp;
   					<input type="radio" name="gender" class="gender_female_radio" value="0"> 여&nbsp;
				</div>
				
			</div>
			
			<div class="join_button_wrap">
				<input type="button" class="join_button" value="회원가입">
			</div>
		</div>
	</form>
</div>


<script>
$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	
	$(".join_button").click(function(){
		$("#join_form").attr("action", "<c:url value="/user/register"/>");
		$("#join_form").submit();
	});
	
	//인증번호 이메일 전송
	$('.mail_check_button').click(function(){
		let email = $('.id_input').val(); //사용할 이메일 계정
		
		
		$.ajax({
			type : "get",
			url : "/user/mailCheck?email="+email
		});
		
	});
	
});


//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){

	let userId = $('.id_input').val();
	let data = {userId : userId}
	
	
	$.ajax({
		type : "post",
		url : "/user/userIdChk",
		data : data,
		success : function(result) {
			if(result !=='fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display","none");
				$('.mail_check_button').prop("disabled",false);
			} else {
				$('.id_input_re_1').css("display","none");
				$('.id_input_re_2').css("display","inline-block");
				$('.mail_check_button').prop("disabled",true);
				
			}
			
		}
	}); //ajax종료

});



</script>


	
		
</body>
</html>