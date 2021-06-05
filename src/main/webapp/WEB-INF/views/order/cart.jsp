<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="<c:url value='/css/orderstyle.css'/>" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="/js/order1.js"></script>


    	<c:choose>
    		<c:when test="${empty cartList }">
    			<script>
    				console.log('test')
    				alert("장바구니가 비었습니다");
    				location.href="<c:url value="/"/>";
    			</script>
    		</c:when>
    		<c:otherwise>


 <!-- <p>끝값:${status.end+1}</p> -->
 <body>
    	
    <form name="orderform" class="orderform" id="orderform" method="post" class="orderform" action="/Page" onsubmit="return false;">
    	<input type="hidden" name="cmd" value="order">
    	
            <div class="basketdiv" id="basket">
    			<h3>온라인 강의</h3>
                <div class="row head">
                    <div class="subdiv">
                        <div class="check">선택</div>
                        <div class="img">이미지</div>
                        <div class="pname">상품명</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice">가격</div>                   
                    </div>
                    <div class="subdiv">
    
                        <div class="basketcmd">삭제</div>
                    </div>
                    <div class="split"></div>
                </div>
                 <c:forEach items="${cartList}" var="BoardVO" varStatus="status">
                <c:if test="${BoardVO.classType}">
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" id="p_num" name="buy" checked="checked" value="${BoardVO.className }" onclick="javascript:basket.checkItem();">&nbsp;</div>
                        <div class="img"><img src="/resources/board/img/${BoardVO.thumbnailImg }" width="60"></div>
                        <div class="pname">
                            <span>${BoardVO.className }</span>
                        </div>
                        <input type="hidden"  value="${status.end+1 }">
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="${BoardVO.price }">${BoardVO.price }원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
            </c:if>
    	</c:forEach>                      
            </div>
            <div class="basketdiv" id="basket">
    			<h3>오프라인 강의</h3>
                <div class="row head">
                    <div class="subdiv">
                        <div class="check">선택</div>
                        <div class="img">이미지</div>
                        <div class="pname">상품명</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice">가격</div>                   
                    </div>
                    <div class="subdiv">
    
                        <div class="basketcmd">삭제</div>
                    </div>
                    <div class="split"></div>
                </div>
                
                 <c:forEach items="${cartList}" var="BoardVO" varStatus="status">
                <c:if test='${!BoardVO.classType}'>
        
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox"  name="buy" id="p_num" checked="checked" value="${BoardVO.className }" onclick="javascript:basket.checkItem();">&nbsp;</div>
                        <div class="img"><img src="resources/board/img/${BoardVO.thumbnailImg }" width="60"></div>
                        <div class="pname">
                            <span>${BoardVO.className }</span>
                        </div>
                        <input type="hidden"  value="${status.end+1}">
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="${BoardVO.price }">${BoardVO.price }원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>

       			 </c:if>
       			 </c:forEach>
       			 
            </div>
       		 
    		
    		<div class="basketrowcmd-wrapper">
	           <div class="right-align basketrowcmd">
	               <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a>
	               <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delAllItem();">장바구니비우기</a>
	           </div>
	   
	           <div class="bigtext right-align sumcount" id="sum_p_num">상품갯수: 4개</div>
	           <div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액: 74,200원</div>
    		</div>
    		
    		<div class="payment-wrapper">
    			<h3>결제정보</h3>
    				<ul class="payment-content">
	    				<li>
	    					<div class="total">총 주문 금액</div>
	    				</li>
	    				<li>
	    					<div class="point">포인트</div>
	    					<div class="point-body">사용가능한 포인트는  입니다.
	    						<a href="javascript:void(0)"  class="point-use" onclick="javascript:pointUseFunc()">포인트 사용하기</a>
	    					</div>
	    				</li>
	    				<li>
	    					<div class="payment-method">결제수단
		    					<input type="radio" name="payment_method" id="kg" value="kg" checked="checked">신용카드
		    					<input type="radio" name="payment_method" id="naverpay" value="naverpay">실시간 계좌이체
		    					<input type="radio" name="payment_method" id="kakaopay" value="kakaopay">카카오페이					
	    					</div>
	    				</li>
	    				</ul>
    		</div>
    		<div class="orderbtn">
    			<button id="orderbtn" type="button" onclick="getOrderM()">결제하기</button>
    		</div>
    		
        </form>
        
        </c:otherwise>
    		</c:choose>
<script>  
	
//체크박스 체크된 항목 값 더하기 (총 얼마인지)

	/* $(function(){
		
		var sum = 0;
		
		$('#buy').each(function(){
			if($(this).is(":checked"))
			{
				const psum = 
				parseInt($(this).parents().find('input[name="buy"]').val());
				sum = sum + psum;
			}
				$("#sum_p_price").html("합계금액:"+sum+"원");
		});
		
	}); */
	
	$( document ).ready(function() {
		const s = "$(cartList.size())";
		basket.reCalc(s); 
		basket.updateUI();
	});

	$(function() {
		
		$("#orderbtn").click(function() {
			const kg = $("#kg").is(":checked");
			const naverpay = $("#naverpay").is(":checked");
			const kakaopay = $("#kakaopay").is(":checked");
			console.log(kg);
			console.log(naverpay);
			console.log(kakaopay);
		
		});
		
	});
	
	
		//결제 메소드 선택 여부 확인
		function getOrderM(){
			console.log("결제메소드선택까지 들어왔나?");
			const OrderMList 
			= document.getElementsByName("payment_method");
			
			iamport();
			
			/*  
			OrderMList.forEach((node)=>{
				if(node.checked == kg){
					alert("asd 구현전");
					iamport();
				}else if(node.checked == naverpay){
					alert("네이버페이 구현전");
				}else if(node.checked == kakaopay){
					alert("카카오페이 구현전");
				}
			});
			*/
		};
		


        function iamport(){
        	
        	var merchant_uid =  new Date().getTime()+'${userNo}';
	        var pay_method = 'card';
	        var name = classNameArray.toString();
	        //총합 어떻게 넣어줄 지 
	        var amount = totalPrice;
	        var buyer_name = '${userLogin.nickname}';
	        var buyer_email = '${userLogin.userId}';
	        
        	var classNameArray =[];
        	$("input[name=buy]:checked").each(function(){
        		classNameArray.push(this.value);
        	})
        	
        	//console.log;(document.getElemntBy)
			//가맹점 식별코드
			IMP.init('imp99899187');
			IMP.request_pay({
			    pg : 'kcp',
			    pay_method : pay_method,
			    merchant_uid : merchant_uid ,
			    name : name , //결제창에서 보여질 이름
			    amount : amount, //실제 결제되는 가격
			    buyer_name : buyer_name,
			    buyer_tel : '010-1234-5678',
			    buyer_email : buyer_email

			    //m_redirect_url: '<c:url value="/order/complete"/>' //결제완료시 넘어가는 페이지
			}, function(rsp) {
				console.log(rsp);
			    if ( rsp.success ) {
			    	var msg = '결제가 완료되었습니다.';
			        msg += '고유ID : ' + rsp.imp_uid;
			        msg += '상점 거래ID : ' + rsp.merchant_uid;
			        msg += '결제 금액 : ' + rsp.paid_amount;
			        msg += '카드 승인번호 : ' + rsp.apply_num;
			        
			        //여기 어떻게 할지 생각좀 해보기 ㅜㅜ
			        
			        var param = {}
			       
			        $.ajax({
	                    type: "POST", 
	                    url: "/order/complete", //충전 금액값을 보낼 url 설정
	                    data: {
// 	                        "amount" : 100//결제금액
// 	                        "pay_method" : 'card'//결제방법
// 	                        "merchant_uid" : 'merchant_' + new Date().getTime()//주문번호
// 	                        //유저번호는 controller에서 session으로 넣어주기
// 	                        name//강의번호
// 	                        //이거 allData로 jsp에서 c태그 가져와서 추가하기 
	                        
	                    },
	                });
			    } else {
			    	 var msg = '결제에 실패하였습니다.';
			         msg += '에러내용 : ' + rsp.error_msg;
			    }
			    alert(msg);
			});
		};
</script>
<jsp:include page="../include/footer.jsp" />