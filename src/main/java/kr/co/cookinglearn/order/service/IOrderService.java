package kr.co.cookinglearn.order.service;

import kr.co.cookinglearn.order.model.OrderVO;

public interface IOrderService {
	
	//주문정보 등록
	void insert(OrderVO OrderList);
	
	//결제 리스트 받아오기
	OrderVO getOrderList(int orderNo);
	
	//결제 취소하기
	
	

}
