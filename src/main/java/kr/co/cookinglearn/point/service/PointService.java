package kr.co.cookinglearn.point.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.cookinglearn.admin.model.PointVO;
import kr.co.cookinglearn.point.repository.IPointMapper;

public class PointService implements IPointService {

	@Autowired
	private IPointMapper mapper;
	
	@Override
	public void insert(PointVO addpoint) {
		mapper.insert(addpoint);

	}

	@Override
	public PointVO pointList(PointVO user_no) {
		return mapper.pointList(user_no);
	}

}
