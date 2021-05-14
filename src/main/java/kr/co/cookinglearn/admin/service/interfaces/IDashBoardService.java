package kr.co.cookinglearn.admin.service.interfaces;

import kr.co.cookinglearn.admin.model.process.DashBoardTodayVO;

public interface IDashBoardService {
	
	//오늘의 할 일 항목별 개수 반환
	DashBoardTodayVO todayWork();
	
}
