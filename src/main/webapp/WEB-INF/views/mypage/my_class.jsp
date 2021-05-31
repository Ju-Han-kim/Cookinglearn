<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />

	<!-- Mypage -->
    <div class="mypage__wrapper">
      <ul class="mypage__navmenu__sidebar">
        <h3>안녕하세요 <c:out value="${login.nickname}"/>님!</h3>
        <p>내 포인트:&nbsp;&nbsp;<c:out value="${point}"/>p</p>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/myclass" />"><b style="color: #fcba03;" onMouseOver="this.style.color='black'" onMouseOut="this.style.color='#fcba03'"><i class="fas fa-book"></i>&nbsp;&nbsp;&nbsp;내 강의</b></a>
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
          <a href="<c:url value="/user/mypage" />"><i class="fas fa-cog"></i>&nbsp;&nbsp;내 정보</a>
        </li>
        <li class="mypage__navmenu__item">
          <a href="<c:url value="/user/logout" />"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;로그아웃</a>
        </li>
      </ul>
      <div class="mypage__content">
        <div class="classes">
          <div class="classes_left">
            <h2>수강중인 클래스</h2>
            <c:if test="${fn:length(takingClassList) != 0}">
	            <c:forEach var="takingClass" items="${takingClassList}">
		            <div class="classes_wrap_left">
		              <div class="class_left">
		                  <div class="class">
		                  <div class="class_thumb">
		                    <img src="${takingClass.thumbnailImg}" alt="클래스 썸네일">
		                  </div>
		                  <div class="class_contents">
		                    <div class="class_button_wrap">
		                      <c:if test="${takingClass.classType}">
		                        <button class="button_left show-btn" id="${takingClass.classCode}">시청하기</button>
		                      </c:if>
		                      <c:if test="${!takingClass.classType}">
		                        <button class="button_left" disabled="disabled"><fmt:formatDate pattern="yyyy-MM-dd" value="${takingClass.startDate}"/><br><fmt:formatDate pattern="HH시 mm분" value="${takingClass.startDate}"/></button>
		                      </c:if>
		                    </div>
		                    <div class="class_title">
		                      <h4>
		                      	<c:if test="${takingClass.classType}">
		                      	  온)
		                      	</c:if>
		                      	<c:if test="${!takingClass.classType}">
		                      	  오프)
		                      	</c:if>
		                      	${takingClass.className}
	                      	  </h4>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
	            </c:forEach>
           </c:if>
           <c:if test="${fn:length(takingClassList) == 0}">
				강의를 신청해보세요!
           </c:if>
          </div>
          <div class="classes_right">
            <h2>대기중인 클래스</h2>
            
            <c:if test="${fn:length(waitingClassList) != 0}">
	            <c:forEach var="waitingClass" items="${waitingClassList}">
		            <div class="classes_wrap_right">
		              <div class="class_right">
		                <div class="class">
		                  <div class="class_thumb">
		                    <img src="${waitingClass.thumbnailImg}" alt="클래스 썸네일">
		                  </div>
		                  <div class="class_contents">
		                    <div class="class_button_wrap" id="${waitingClass.orderNo}">
		                      <button class="button_left agree-btn" id="${waitingClass.orderNo}">수강동의</button>
		                      <button class="button_right return-btn" id="${waitingClass.orderNo}">반품하기</button>
		                    </div>
		                    <div class="class_title">
		                      <h4>
		                        <c:if test="${waitingClass.classType}">
		                      	  온)
		                      	</c:if>
		                      	<c:if test="${!waitingClass.classType}">
		                      	  오프)
		                      	</c:if>
		                      	${waitingClass.className}
		                      </h4>
		                    </div>
		                  </div>
		                </div>
		              </div>
		            </div>
	            </c:forEach>
            </c:if>
             <c:if test="${fn:length(waitingClassList) == 0}">
             	<!-- 별도카드 구현필요 -->
				강의를 신청해보세요!
             </c:if>
          </div>
        </div>
      </div>
    </div>
	
	
<jsp:include page="../include/footer.jsp" />

<script>
	
	$(function() {
		
		//시청하기
		$(".show-btn").click(function() {
			
			const classCode = $(this).attr("id");
			const url = "/user/myclasswatch?classCode="+classCode;
			
			location.href=url;
			
		});

		
		//수강동의
		$(".agree-btn").click(function() {
			
			const orderNo = $(this).attr("id");
			if(confirm("수강동의하시겠습니까?")){
				$.ajax({
					type: "POST",
					data:{
						"orderNo": orderNo,
						"orderProcess": 1
					},
					url:"/user/setOrderProcess",
					success: function() {
						alert("수강동의처리되었습니다.");
						location.href="/user/myclass";
						
					},
					error: function() {
						console.log("통신오류 : 프로세스변경");
					}
				});
			}
			
		});
		
		
		//반품하기
		$(".return-btn").click(function() {
			
			const orderNo = $(this).attr("id");
			if(confirm("반품하시겠습니까?")){
				$.ajax({
					type: "POST",
					data:{
						"orderNo": orderNo,
						"orderProcess": 3
					},
					url:"/user/setOrderProcess",
					success: function() {
						alert("반품처리되었습니다.");
						location.href="/user/myclass";
					},
					error: function() {
						console.log("통신오류 : 프로세스변경");
					}
				});
			}
		});
		
		
	});


</script>