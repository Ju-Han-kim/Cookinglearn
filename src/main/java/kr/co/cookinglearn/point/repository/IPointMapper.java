package kr.co.cookinglearn.point.repository;

import java.util.ArrayList;

import kr.co.cookinglearn.admin.model.PointVO;

public interface IPointMapper {

	//포인트 사용&적립
	void insert(PointVO addpoint);

	//포인트 리스트 출력
	ArrayList<PointVO> pointList(int userNo);
	
	//포인트 합계
		int getUserPoint(int userNo);


	
	
}
