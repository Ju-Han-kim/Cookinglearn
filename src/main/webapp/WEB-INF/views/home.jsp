<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="include/header.jsp" />
<link rel="stylesheet" type="text/css" href="/board/css/style.css">

    <!-- Rolling banner -->
    <div class="slidebox">
      <input type="radio" name="slide" id="slide1" checked />
      <input type="radio" name="slide" id="slide2" />
      <input type="radio" name="slide" id="slide3" />
      <input type="radio" name="slide" id="slide4" />
      <ul class="slidelist">
        <li class="slideitem">
          <div>
            <label for="slide4" class="left"></label>
            <label for="slide2" class="right"></label>
            <a><img src="<c:url value='/img/slide1.png'/>" /></a>
          </div>
        </li>
        <li class="slideitem">
          <div>
            <label for="slide1" class="left"></label>
            <label for="slide3" class="right"></label>
            <a><img src="<c:url value='/img/slide2.png'/>" /></a>
          </div>
        </li>
        <li class="slideitem">
          <div>
            <label for="slide2" class="left"></label>
            <label for="slide4" class="right"></label>
            <a><img src="<c:url value='/img/slide3.png'/>" /></a>
          </div>
        </li>
        <li class="slideitem">
          <div>
            <label for="slide3" class="left"></label>
            <label for="slide1" class="right"></label>
            <a><img src="<c:url value='/img/slide4.png'/>" /></a>
          </div>
        </li>
      </ul>
    </div>

	
	<div class="container">
		<div id="contents_area_full" style="clear: both">
			<div class="contents_title">
				클래스
			</div>
			<div class="class_list">
				<div class="class_container">
					<c:forEach items="${list}" var="list">
					    <div class="class_item">
							<a href="/board/viewDetail?viewDetail=${list.classCode}">
								<img src="<spring:url value='/resources/board/img/${list.thumbnailImg}'/>" class="img-thumbnail" alt="Cinque Terre" width="200" height="auto"> <br/>
								<div class="cli_caption_title"> 
									${list.className} 
								</div>
								<div class="cli_caption_price_box">
				                  	<strong class="cli_caption_price">
										${list.price}
										<small>
											원
										</small> 
									</strong>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />

<script>
	const msg = "${param.msg}";
	
	if(msg === "noadmin"){
		alert("비정상적인 접근입니다.");
	}else if(msg === "login"){
		alert("로그인 후 이용해주세요.");
	}
	
</script>