<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" href="<c:url value='/css/orderstyle.css'/>" />
<script type="text/javascript" src="/js/order.js"></script>

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
        
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket1.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강1</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="20000">20,000원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="261" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket2.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강2</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price2" class="p_price" value="19000">19,000원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="262" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket3.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강3</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price3" class="p_price" value="15200">15,200원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
        
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
        
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket1.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강1</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="20000">20,000원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="261" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket2.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강2</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price2" class="p_price" value="19000">19,000원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
                <div class="row data">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name="buy" value="262" checked="">&nbsp;</div>
                        <div class="img"><img src="./img/basket3.jpg" width="60"></div>
                        <div class="pname">
                            <span>인강3</span>
                        </div>
                    </div>
                    <div class="subdiv">
                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price3" class="p_price" value="15200">15,200원</div>
                    </div>
                    <div class="subdiv">
                        <div class="basketcmd"><a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a></div>
                    </div>
                </div>
        
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
    				<div class="payment-content">
    					<div class="total">총 주문 금액</div>
    					<div class="point">포인트</div>
    					<div class="payment-method">결제수단
    					<input type="radio" name="payment_method" value="" checked="checked">
    					
    					</div>
    				</div>
    		</div>
    		
        </form>

<jsp:include page="../include/footer.jsp" />