<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="include/header.jsp" />

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

<jsp:include page="include/footer.jsp" />