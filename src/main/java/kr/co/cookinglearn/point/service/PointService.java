package kr.co.cookinglearn.point.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.point.model.PointVO;
import kr.co.cookinglearn.point.repository.IPointMapper;

@Service
public class PointService implements IPointService {

	@Autowired
	private IPointMapper mapper;
	
	@Override
	public void insertPoint(PointVO addPoint) {
		mapper.insertPoint(addPoint);

	}

	@Override
	public int getUserPoint(int userNo) {
		return mapper.getUserPoint(userNo);
	}
	
	@Override
	public List<PointVO> getUserPointList(int userNo) {
		return mapper.getUserPointList(userNo);
	}
	
}
