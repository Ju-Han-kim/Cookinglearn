package kr.co.cookinglearn.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.model.ReviewVO;
import kr.co.cookinglearn.admin.repository.IReviewMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IReviewService;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	private IReviewMgrMapper mapper;
	
	@Override
	public List<ReviewVO> getReview(int classCode) {
		return mapper.getReview(classCode);
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
