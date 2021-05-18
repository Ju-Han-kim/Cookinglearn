package kr.co.cookinglearn.admin.repository;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;

public interface IOrderMgrMapper {
	
	//검색 구분자를 전달받아 현재 페이지의 주문 리스트 반환
	List<OrderViewVO> getOrderList(OrderSearchVO search);
	
	//검색 구분자를 전달받아 주문 수 반환
	int orderCount(OrderSearchVO search);
	
	//주문번호를 받아 주문정보 반환
	OrderViewVO getOrderInfo(int orderNo);
	
	//고객번호를 받아 주문정보 리스트 반환
	List<OrderViewVO> getOrderListByUser(int userNo);
	
}
