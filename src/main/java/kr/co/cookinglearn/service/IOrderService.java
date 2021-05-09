package kr.co.cookinglearn.service;

import kr.co.cookinglearn.model.OrderVO;

public interface IOrderService {
	
	//결제 완료 내역 등록 기능
	void insert(OrderVO OrderList);
	
	//결제 내역 조회 기능
	OrderVO getOrderList(int orderNo);
	
	//결제 취소 기능 (필요한가?)
	

}
