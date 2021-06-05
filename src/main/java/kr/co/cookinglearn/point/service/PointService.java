package kr.co.cookinglearn.point.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.model.PointVO;
import kr.co.cookinglearn.point.repository.IPointMapper;

@Service
public class PointService implements IPointService {

	@Autowired
	private IPointMapper mapper;
	
	@Override
	public void insert(PointVO addpoint) {
		mapper.insert(addpoint);

	}

	@Override
	public ArrayList<PointVO> pointList(int userNo) {
		return mapper.pointList(userNo);
	}

	@Override
	public int getUserPoint(int userNo) {
		return mapper.getUserPoint(userNo);
	}
	
	

}
