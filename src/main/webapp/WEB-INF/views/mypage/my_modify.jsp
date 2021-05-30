<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />

	<!-- Mypage -->
    <div class="mypage__wrapper">
      <ul class="mypage__navmenu__sidebar">
        <h3>안녕하세요 <c:out value="${login.nickname}"/>님!</h3>
        <p>내 포인트:&nbsp;&nbsp;<c:out value="${point}"/>p</p>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myclass" />"><i class="fas fa-book"></i>&nbsp;&nbsp;&nbsp;내 강의</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypoint" />"><i class="fab fa-product-hunt"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내 포인트</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypayment" />"><i class="fas fa-receipt"></i>&nbsp;&nbsp;결제 내역</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myqna" />"><i class="fas fa-question-circle"></i>&nbsp;&nbsp;내 문의</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/mypage" />"><b style="color: #fcba03;" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='#fcba03'"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</b></a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
        </li>
      </ul>
      <div class="mypage__content">
      	<div id="my_info">
          <h3>내 정보 수정</h3>
          <form id="modify_form" action="/user/modify" method="POST">
            <div class="input_bar">
              <input type="text" id="userId" name="userId" class="id_input" placeholder="아이디(이메일)" value="${login.userId}" disabled/>
              <div id="id_small">*아이디(이메일)는 바꾸실 수 없습니다</div>
              <input type="password" id="password" name="userPassword" class="pw_input" placeholder="비밀번호"/>
              <input type="password" id="confirmPassword" class="pwck_input" placeholder="비밀번호 확인" value="" />
              <div id="password_check" class="check"></div>
              <input type="text" id="nickname" name="nickname" class="nick_input" placeholder="닉네임" value="${login.nickname}" />
              <button type="button" class="nick_check_button" onclick="fn_nickChk();" value="N">중복 확인</button>
              <div id="nickname_check" class="check"></div>
            </div>
            <div class="radio-input">
              <label for="radio-1">남성&nbsp;</label>
              <input
                id="radio-1"
                type="radio"
                name="gender"
                class="radio gender_male_radio"
                value="1" ${login.gender == 1?'checked':''}/>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <label for="radio-2">여성&nbsp;</label>
              <input
                id="radio-2"
                type="radio"
                name="gender"
                class="radio gender_female_radio"
                value="0" ${login.gender == 0?'checked':''}/>
            </div>
            <div id="join_check" class="check"></div>  
            <div class="button_wrapper">
              <input type="button" id="finish_update-btn" value="수정 완료" />
            </div>
          </form>
      </div>
    </div>
  </div>
  <script>
  
  
  var chk1 = false
  
  function fn_nickChk(){
	  	
		if($("#nickname").val()=="") {
			alert("닉네임을 입력 후 중복 확인해주세요");
		} else {
			$.ajax({
		        url : "/user/nicknameMod",
		        type : "POST",
		        dataType : "json",
		        data : {"nickname" : $("#nickname").val()},
		        success : function(result) {
		            if(result > 0){
		                alert("중복된 닉네임입니다");
		            }else if(result <= 0){
		                $(".nick_check_button").attr("value", "Y");
		                alert("사용가능한 닉네임입니다");
		                chk1 = true;
		            }
		        }
		    });//ajax end
		}
	}
	
  $(function(){

	    const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	    
	    let chk2 = false, chk3 = false;
	    
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
	            if(chk1 && chk2 && chk3){
	                $("#join_check").html('<span style="color:green;"></span>');
	            } else {
	                $("#join_check").html('<span style="color:red;"></span>');
	            }
	        }
	    });

	     //pwChk check
	    $("#confirmPassword").on("keyup", function(){
	        if($(this).val() === ""){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호 확인란을 입력해주세요</span>');
	            chk2 = false;
	        }else if($("#password").val() != $(this).val()){
	            $(this).css("background-color", "#ffeceb");
	            $("#password_check").html('<span style="color:red;">*비밀번호가 일치하지 않습니다</span>');
	            chk2 = false;
	        }else{
	            chk2 = true;
	            $(this).css("background-color", "#ebf1ff");
	            $("#password_check").html('<span style="color:green;"></span>');
	            $("#join_check").html('<span style="color:green;"></span>');
	            if(chk1 && chk2 && chk3){
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
	            if(chk1 && chk2 && chk3){
	                $("#join_check").html('<span style="color:green;"></span>');
	            } else {
	                $("#join_check").html('<span style="color:red;"></span>');
	            }
	        }
	    });

	     //finsih update button click
	    $("#finish_update-btn").click(function(){

	        const radio = $("#radio-1").is(":checked") || $("#radio-2").is(":checked");
	        const check = $(".nick_check_button").attr('value') == "Y";
	        
	        if(chk1 && chk2 && chk3 && radio && check){
	            $("#modify_form").submit();
	            alert("회원 정보가 성공적으로 수정되었습니다");
	      	} else if (chk1 && chk2 && chk3 && check) {
	        	alert("성별을 입력해주세요");
	        } else if(chk1 && chk2 && chk3 && radio) {
	        	alert("닉네임 중복 확인을 해주세요");
	        } else {
	            alert("입력 정보를 다시 확인해주세요");
	        }
	    });
	});//jQuery
  
  </script>
	
<jsp:include page="../include/footer.jsp" />