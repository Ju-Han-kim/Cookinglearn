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
	<form id="join_form" method="post">
		<div class="wrap">
			<div class="id_wrap">
				<input id="email" type="text" name="userId" class="id_input" placeholder="이메일(아이디)" /> 
				<input class="mail_check_input" disabled="disabled" placeholder="인증번호" />
				<button type="button" class="mail_check_button" disabled="disabled">이메일인증</button>
				<span class="id_input_re_1">*사용 가능한 아이디입니다</span> 
				<span class="id_input_re_2">*아이디가 이미 존재합니다</span>
				<span id="email_check"></span>
				<div class="clearfix"></div>
			</div>
			<input id="password" type="password" name="userPassword" class="pw_input" placeholder="비밀번호" /> 
			<input id="confirmPassword" type="password" class="pwck_input" placeholder="비밀번호 확인" /> 
			<div id="password_check"></div>
			<input id="nickname" type="text" name="nickname" class="nick_input" placeholder="닉네임" />
			<span id="nickname_check"></span>
			<span class="nick_input_re_1">*사용 가능한 닉네임입니다</span> 
			<span class="nick_input_re_2">*닉네임이 이미 존재합니다</span>
			<div class="radio-input">
				<label for="radio-1">남성&nbsp;</label> 
				<input id="radio-1" type="radio" name="gender" class="radio gender_male_radio" value="1" /> &nbsp;&nbsp;&nbsp;&nbsp; 
				<label for="radio-2">여성&nbsp;</label>
				<input id="radio-2" type="radio" name="gender" class="radio gender_female_radio" value="0" />
			</div>
			<div id="join_check"></div>
			<input type="button" class="join_button" value="회원가입" />
		</div>
	</form>
	
	
	
	<script>
      $(document).ready(function () {
        //회원가입 버튼(회원가입 기능 작동)

        $(".join_button").click(function () {
          $("#join_form").attr("action", "<c:url value="/user/register"/>");
          $("#join_form").submit();
        });

        //인증번호 이메일 전송
        $(".mail_check_button").click(function () {
          let email = $(".id_input").val(); //사용할 이메일 계정

          $.ajax({
            type: "get",
            url: "/user/mailCheck?email=" + email,
          });
        });
      });

      //이메일(아이디) 중복검사
      $(".id_input").on("propertychange change keyup paste input", function () {
        let userId = $(".id_input").val();
        let data = { userId: userId };

        $.ajax({
          type: "post",
          url: "/user/userIdChk",
          data: data,
          success: function (result) {
            if (result == "success") {
              $(".id_input_re_1").css("display", "inline-block");
              $(".id_input_re_2").css("display", "none");          
              $(".mail_check_button").prop("disabled", false);
            } else if (result == "blank") {
            	$(".id_input_re_1").css("display", "none");
                $(".id_input_re_2").css("display", "none");              
                $(".mail_check_button").prop("disabled", false);
            } else {
              $(".id_input_re_1").css("display", "none");
              $(".id_input_re_2").css("display", "inline-block");
              $(".mail_check_button").prop("disabled", true);
            }
          },
        }); //ajax종료
      });
      
      //닉네임 중복검사
      $(".nick_input").on("propertychange change keyup paste input", function () {
          let userId = $(".nick_input").val();
          let data = { nickname: nickname };

          $.ajax({
            type: "post",
            url: "/user/nicknameChk",
            data: data,
            success: function (result) {
              if (result == "success") {
                $(".nick_input_re_1").css("display", "inline-block");
                $(".nick_input_re_2").css("display", "none");          
              } else if (result == "blank") {
              	$(".nick_input_re_1").css("display", "none");
                $(".nick_input_re_2").css("display", "none");              
              } else {
                $(".nick_input_re_1").css("display", "none");
                $(".nick_input_re_2").css("display", "inline-block");
              }
            },
          }); //ajax종료
        });
      
      
      //검사
      $(function(){
    	   
    	   const getEmailCheck = RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
    	   const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
    	   
    	   let chk1 = false, chk2 = false, chk3 = false, chk4 = false;
    	   
    	   //email check(id)
    	   $("#email").on("keyup", function(){
    	      if($(this).val() === ""){
    	         chk2 = false;
    	         $(this).css("background-color", "#ffeceb");
    	         $("#email_check").html('<span style="color:red;">*아이디를 입력해주세요</span>');
    	      }else if(!getEmailCheck.test($(this).val())){
    	         chk2 = false;
    	         $(this).css("background-color", "#ffeceb");
    	         $("#email_check").html('<span style="color:red;">*이메일 양식으로 입력해주세요</span>');
    	      }else{
    	         chk2 = true;
   	             $("#email_check").html('<span style="color:green;">*이메일 양식입니다</span>');
    	         $(this).css("background-color", "#ebf1ff");
    	         if(chk1 && chk2 && chk3 && chk4){
    	            $("#join_check").html('<span style="color:green;">*OK</span>');
    	         } else {
    	            $("#join_check").html('<span style="color:red;">*다른 값을 확인해주세요</span>');
    	         }
    	      }
    	   });//email 검증
    	   
    	   //비밀번호 입력 검증
    	   $("#password").on("keyup", function(){
    	      if($(this).val() === ""){
    	         $(this).css("background-color", "#ffeceb");
    	         $("#password_check").html('<span style="color:red;">*비밀번호를 입력해주세요</span>');
    	         chk3 = false;
    	      }else if(!getPwCheck.test($(this).val()) || $(this).val().length < 8){
    	         $(this).css("background-color", "#ffeceb");
    	         $("#password_check").html('<span style="color:red;">*비밀번호는 영어, 숫자 특수문자 포함 8글자 이상입니다</span>');
    	         chk3 = false;
    	      }else{
    	         chk3 = true;
    	         $(this).css("background-color", "#ebf1ff");
    	         if(chk1 && chk2 && chk3 && chk4){
    	            $("#join_check").html('<span style="color:green;">*OK</span>');
    	         } else {
    	            $("#join_check").html('<span style="color:red;">*다른 값을 확인해주세요</span>');
    	         }
    	      }
    	   });//비밀번호 입력 검증
    	   
    	   //비밀번호 확인 검증
    	   $("#confirmPassword").on("keyup", function(){
    		   console.log("opassword: " +( $("#password").val()))
 	    	  console.log("cpassword: " + $(this).val())
 	    	  console.log("result: " +$("#password").val() != $(this).val())
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
    	         $("#password_check").html('<span style="color:green;">비밀번호가 일치합니다</span>');
    	         if(chk1 && chk2 && chk3 && chk4){
    	            $("#join_check").html('<span style="color:green;">*OK</span>');
    	         } else {
    	            $("#join_check").html('<span style="color:red;">*다른 값을 확인해주세요</span>');
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
    	         $(this).css("background-color", "#ebf1ff");
    	         if(chk1 && chk2 && chk3 && chk4){
    	            $("#join_check").html('<span style="color:green;">*OK</span>');
    	         } else {
    	            $("#join_check").html('<span style="color:red;">*다른 값을 확인해주세요</span>');
    	         }
    	      }
    	   });//이름 값 검증
    	   
    	   //회원가입 버튼 활성화
    	   $("#sign-up-btn").click(function(){
    	      
    	      const nickname = $("#nickname").val();
    	      const email = $("#email").val();
    	      const password = $("#password").val();
    	      const gender = $("#radio-1" || "#radio-2").is(":checked");
    	      
    	      if(!chk1 && chk2 && chk3 && chk4 && gender){
    	    	  $('.join_button').attr('disabled', true);
    	      }
    	         
    	   });//회원가입 버튼 활성화 끝
    	   
    	});//JQuery
      
      
    </script>
</body>
</html>
