package kr.co.cookinglearn.point.service;

import kr.co.cookinglearn.admin.model.PointVO;

public interface IPointService {
	
	//포인트 사용&적립
	void insert(PointVO addpoint);

	//포인트 리스트 출력
	PointVO pointList(PointVO user_no);

}
