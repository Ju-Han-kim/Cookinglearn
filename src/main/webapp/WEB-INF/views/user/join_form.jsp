<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>쿠킹런 - 요리를 배울 수 있는 온오프라인 클래스 | 온오프라인 강의 플랫폼</title>
<meta name="description"
	content="요리 입문부터 심화까지 업계 최고 요리사들에게 배울 수 있는 곳. 우리는 맛있고 건강한 매일을 추구합니다...." />
<meta name="author" content="권우희, 김주한, 양다정, 최준우" />
<link rel="icon" type="image/png"
	href="<c:url value='/img/favicon.png' />" />
<script src="https://kit.fontawesome.com/bab51a57cc.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Noto+Sans+KR:wght@300;400;700&display=swap" rel="stylesheet" />
<link rel="stylesheet" href="/resources/css/user/join_form.css" />
</head>
<!-- jquery -->
<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>
<body>
	<div class="logo">
		<a href="/">CookingLearn</a>
	</div>
	<div class="register_title">
		<h2>회원 가입</h2>
	</div>
	<form id="join_form" method="post" action="/user/register">
		<div class="wrap">
          <div class="id_wrap">
              <input type="text" id="userId" name="userId" class="id_input" placeholder="이메일(아이디)"/>
              <button type="button" class="id_check_button" onclick="fn_idChk();" value="N">중복 확인</button>
			  <div id="userId_check"></div>
			  
          </div>
              <input type="password" id="password" name="userPassword" class="pw_input" placeholder="비밀번호" />
              <input type="password" id="confirmPassword" class="pwck_input" placeholder="비밀번호 확인" />
              <div id="password_check"></div>
              
              <input type="text" id="nickname" name="nickname" class="nick_input" placeholder="닉네임" />
              <button type="button" class="nick_check_button" onclick="fn_nickChk();" value="N">중복 확인</button>
              <div id="nickname_check"></div>
              
                <div class="radio-input">
                  <label for="radio-1">남성&nbsp;</label>
                  <input
                    id="radio-1"
                    type="radio"
                    name="gender"
                    class="radio gender_male_radio"
                    value="1"/>
                  &nbsp;&nbsp;&nbsp;&nbsp;
                  <label for="radio-2">여성&nbsp;</label>
                  <input
                    id="radio-2"
                    type="radio"
                    name="gender"
                    class="radio gender_female_radio"
                    value="0"/>
                </div>
                
                <div id="join_check"></div>  
                
            <input type="button" id="joinButton" class="join_button" value="회원가입" />
        </div>
	</form>
	<script>

	function fn_idChk(){
		
		const getEmailCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
		
		if($("#userId").val()=="") {
			alert("이메일(아이디)을 입력 후 중복 확인해주세요");
		} else if(!getEmailCheck.test($("#userId").val())){
			alert("이메일 양식으로 입력해주세요");
		} else {
			$.ajax({
		        url : "/user/userIdChk",
		        type : "POST",
		        dataType : "json",
		        data : {"userId" : $("#userId").val()},
		        success : function(result) {
		            if(result > 0){
		                alert("중복된 아이디입니다");
		            }else if(result == 0){
		                $(".id_check_button").attr("value", "Y");
		                alert("사용가능한 아이디입니다");
		            }
		        }
		    })//ajax end    
		}
	}

	function fn_nickChk(){
		
		if($("#nickname").val()=="") {
			alert("닉네임을 입력 후 중복 확인해주세요");
		} else {
			$.ajax({
		        url : "/user/nicknameChk",
		        type : "POST",
		        dataType : "json",
		        data : {"nickname" : $("#nickname").val()},
		        success : function(result) {
		            if(result > 0){
		                alert("중복된 닉네임입니다");
		            }else if(result == 0){
		                $(".nick_check_button").attr("value", "Y");
		                alert("사용가능한 닉네임입니다");
		            }
		        }
		    })//ajax end
		}
	}

	$(function(){

	    const getEmailCheck = RegExp(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
	    const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	    
	    let chk1 = false, chk2 = false, chk3 = false, chk4 = false;
	    
	     //email(id) check
	    $("#userId").on("keyup", function(){
	        if($(this).val() === ""){
	            chk2 = false;
	            $(this).css("background-color", "#ffeceb");
	            $("#userId_check").html('<span style="color:red;">*이메일(아이디)을 입력해주세요</span>');
	        }else if(!getEmailCheck.test($(this).val())){
	            chk2 = false;
	            $(this).css("background-color", "#ffeceb");
	            $("#userId_check").html('<span style="color:red;">*이메일 양식으로 입력해주세요</span>');
	        }else{
	            chk2 = true;
	            $("#userId_check").html('<span style="color:green;"></span>');
	            $("#join_check").html('<span style="color:green;"></span>');
	            $(this).css("background-color", "#ebf1ff");
	            if(chk1 && chk2 && chk3 && chk4){
	                $("#join_check").html('<span style="color:green;"></span>');
	            } else {
	                $("#join_check").html('<span style="color:red;"></span>');
	            }
	        }
	    });

	     //password check
	    $("#password").on("keyup", function(){
	        if($(this).val() === ""){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호를 입력해주세요</span>');
	            chk3 = false;
	        }else if(!getPwCheck.test($(this).val()) || $(this).val().length < 8){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호는 영어, 숫자, 특수문자 포함 8글자 이상입니다</span>');
	            chk3 = false;
	        }else{
	            chk3 = true;
	            $("#join_check").html('<span style="color:green;"></span>');
	            $("#password_check").html('<span style="color:green;"></span>');
	            $(this).css("background-color", "#ebf1ff");
	            
	            if ($(this).val() != $("#confirmPassword").val()) {
	            	chk4 = false;
	            	$("#confirmPassword").css("background-color", "#ffeceb");
	            	$("#password_check").html('<span style="color:red;">*비밀번호가 일치하지 않습니다</span>');
	            } else {
	            	chk4 = true;
	            	$("#confirmPassword").css("background-color", "#ebf1ff");
	            	if(chk1 && chk2 && chk3 && chk4){
		                $("#join_check").html('<span style="color:green;"></span>');
		            } else {
		                $("#join_check").html('<span style="color:red;"></span>');
		            }
	            }
	        }
	    });

	     //pwChk check
	    $("#confirmPassword").on("keyup", function(){
	        if($(this).val() === ""){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호 확인란을 입력해주세요</span>');
	            chk4 = false;
	        }else if($("#password").val() != $(this).val()){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호가 일치하지 않습니다</span>');
	            chk4 = false;
	        }else{
	            chk4 = true;
	            $(this).css("background-color", "#ebf1ff");
	            $("#password_check").html('<span style="color:green;"></span>');
	            $("#join_check").html('<span style="color:green;"></span>');
	            if(chk1 && chk2 && chk3 && chk4){
	                $("#join_check").html('<span style="color:green;"></span>');
	            } else {
	                $("#join_check").html('<span style="color:red;"></span>');
	            }
	        }
	    });

	    //nickname check
	    $("#nickname").on("keyup", function(){
	        if($(this).val() === ""){
	            $(this).css("background-color", "#ffeceb");
	            $("#nickname_check").html('<span style="color:red;">*닉네임을 입력해주세요</span>');
	            chk1 = false;
	        }else{
	            chk1 = true;
	            $("#nickname_check").html('<span style="color:red;"></span>');
	            $("#join_check").html('<span style="color:green;"></span>');
	            $(this).css("background-color", "#ebf1ff");
	            if(chk1 && chk2 && chk3 && chk4){
	                $("#join_check").html('<span style="color:green;"></span>');
	            } else {
	                $("#join_check").html('<span style="color:red;"></span>');
	            }
	        }
	    });

	     //join button click
	    $("#joinButton").click(function(){

	        const radio = $("#radio-1").is(":checked") || $("#radio-2").is(":checked");
	        const check = $(".id_check_button").attr('value') == "Y" && $(".nick_check_button").attr('value') == "Y";

	        if(chk1 && chk2 && chk3 && chk4 && radio && check){
	            $("#joinButton").prop("disabled", true); // 중복 회원가입 방지
	        	$("#join_form").submit();
	            
	        } else if (chk1 && chk2 && chk3 && chk4 && check) {
	        	alert("성별을 입력해주세요");
	        } else if(chk1 && chk2 && chk3 && chk4 && radio){
	        	alert("중복 확인을 모두 해주세요");
	        } else {
	            alert("입력 정보를 다시 확인해주세요");
	        }
	    });
	});//jQuery
      
    </script>
</body>
</html>
