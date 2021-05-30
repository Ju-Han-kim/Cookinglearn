<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="<c:url value='/css/orderstyle.css'/>" />
<div class="orderComplete">
<!-- 주문완료 -->
    <div class="orderInfo">
        <p>
            <strong>고객님의 주문이 완료 되었습니다.</strong>
            주문내역 및 배송에 관한 안내는 <a href="javascript:void(0)" onclick="payListFunc();">주문조회</a> 를 통하여 확인 가능합니다.
        </p>
        <ul>
            <li>주문번호 : <strong>{$order_id}</strong></li>
            <li>주문일자 : <span>{$order_date}</span></li>
        </ul>
    </div>
    <div class="btnArea">
    	 <span class="right">
            <a href="/list"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_order_ing.gif" alt="쇼핑계속하기" /></a>
            <a href="javascript:void(0)" onclick="payListFunc();"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_order_check.gif" alt="주문확인하기" /></a>
        </span>
    </div>
</div>
<script>
	function payListFunc(){
		location.href="<c:url value='/order/getList'/>";
	}

</script>
<jsp:include page="../include/footer.jsp" />

