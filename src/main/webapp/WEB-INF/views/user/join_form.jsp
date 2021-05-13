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
<meta name="author" content="권우희, 김주한, 양다정, 유한기, 최준우" />
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
				<input type="text" name="userId" class="id_input" placeholder="이메일(아이디)" /> 
				<input class="mail_check_input" disabled="disabled" placeholder="인증번호" />
				<button type="button" class="mail_check_button" disabled="disabled">이메일인증</button>
				<span class="id_input_re_1">사용 가능한 아이디입니다.</span> 
				<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
				<div class="clearfix"></div>
			</div>
			<input type="password" name="userPassword" class="pw_input"
				placeholder="비밀번호" /> <input type="password" class="pwck_input"
				placeholder="비밀번호 확인" /> <input type="text" name="nickname"
				class="nick_input" placeholder="닉네임" />
			<div class="radio-input">
				<label for="radio-1">남성&nbsp;</label> 
				<input id="radio-1" type="radio" name="gender" class="radio gender_male_radio" value="1" /> &nbsp;&nbsp;&nbsp;&nbsp; 
				<label for="radio-2">여성&nbsp;</label>
				<input id="radio-2" type="radio" name="gender" class="radio gender_female_radio" value="0" />
			</div>
			<input type="button" class="join_button" value="회원가입" />
		</div>
	</form>
	</div>
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

      //아이디 중복검사
      $(".id_input").on("propertychange change keyup paste input", function () {
        let userId = $(".id_input").val();
        let data = { userId: userId };

        $.ajax({
          type: "post",
          url: "/user/userIdChk",
          data: data,
          success: function (result) {
            if (result !== "fail") {
              $(".id_input_re_1").css("display", "inline-block");
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
    </script>
</body>
</html>
