package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.model.OrderVO;
import kr.co.cookinglearn.admin.model.ReviewVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;

public interface IOrderMgrService {

	//검색 구분자를 전달받아 현재 페이지의 주문 리스트 반환
	List<OrderViewVO> getOrderList(OrderSearchVO search);
	
	//검색 구분자를 전달받아 주문 수 반환
	int orderCount(OrderSearchVO search);
	
	//주문번호를 받아 주문정보 반환
	OrderViewVO getOrderInfo(int orderNo);
	
	//주문정보를 받아 해당고객/해당강의 리뷰리스트 반환
	List<ReviewVO> getUserReview(OrderVO order);
	
	//주문정보를 받아 해당고객정보 반환
	UserVO getUserInfo(int userNo);
	
	//주문정보를 받아 해당강의정보 반환
	ClassVO getClassInfo(int classCode);
	
}
