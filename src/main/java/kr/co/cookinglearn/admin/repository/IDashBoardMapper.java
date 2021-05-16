package kr.co.cookinglearn.admin.repository;

import java.util.List;

import kr.co.cookinglearn.admin.model.process.DashBoardProcessVO;

public interface IDashBoardMapper {
	
	//오늘 날짜를 입력하여 클래스 타입별, 진행상태별 개수반환
	List<DashBoardProcessVO> classOrderCount(String today);
	
	//날짜별, 온/오프라인 클래스별, 진행상태별 건수/비용 반환
	List<DashBoardProcessVO> classPaymentCount();
}
