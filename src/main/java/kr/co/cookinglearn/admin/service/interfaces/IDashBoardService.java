package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.model.process.DashBoardSalesVO;
import kr.co.cookinglearn.admin.model.process.DashBoardTodayVO;

public interface IDashBoardService {
	
	//오늘의 할 일 항목별 개수 반환
	DashBoardTodayVO todayWork();
	
	//날짜별, 온/오프라인 클래스별, 진행상태별 건수/비용 반환
	List<DashBoardSalesVO> dailySales();
	
	//최신 문의건 3건 리스트 반환
	List<QnaVO> getQnaList();
}
