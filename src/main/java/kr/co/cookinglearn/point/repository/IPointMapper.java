package kr.co.cookinglearn.point.repository;

import java.util.List;

import kr.co.cookinglearn.point.model.PointVO;

public interface IPointMapper {

	//포인트 사용&적립
	void insertPoint(PointVO addPoint);

	//사용자정보를 받아 적립금 리스트 반환
	List<PointVO> getUserPointList(int userNo);
	
	//사용자정보를 받아 적립금 현재금액 반환
	int getUserPoint(int userNo);

	
}
