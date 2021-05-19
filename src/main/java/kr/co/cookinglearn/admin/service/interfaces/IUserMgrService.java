package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.SearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;
import kr.co.cookinglearn.admin.model.process.ReviewClassVO;

public interface IUserMgrService {
	
	//검색 구분자를 전달받아 현재 페이지의 고객 리스트 반환
	List<UserVO> getUserList(SearchVO search);
	
	//고객번호를 이용하여 고객 전체정보 반환
	UserVO getUserInfo(int userNo);
	
	//고객의 관리자권한을 설정
	void setAdmin(UserVO user);
	
	//검색조건에 맞는 전체 고객 수를 반환
	int userCount(SearchVO search);
	
	//고객번호를 받아 주문정보 리스트 반환
	List<OrderViewVO> getOrderListByUser(int userNo);
		
	//유저번호를 받아 리뷰리스트 반환
	List<ReviewClassVO> getUserReviewWithClass(int userNo);
	
	//유저정보를 받아 해당 유저의 문의내역리스트 반환
	List<QnaVO> getQnaListByUser(int userNo);
	
	//사용자정보를 받아 적립금 현재금액 반환
	int getUserPoint(int userNo);
	
}
