package kr.co.cookinglearn.admin.repository;

import java.util.List;

import kr.co.cookinglearn.admin.model.PointVO;

public interface IPointMgrMapper {

	//사용자정보를 받아 적립금 리스트 반환
	List<PointVO> getUserPointList(int userNo);
	
	//사용자정보를 받아 적립금 현재금액 반환
	int getUserPoint(int userNo);
	
}
