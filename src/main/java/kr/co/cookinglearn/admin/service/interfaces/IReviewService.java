package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.model.ReviewVO;

public interface IReviewService {

	//강의번호를 받아 리뷰리스트 반환
	List<ReviewVO> getReview(int classCode);
	
}
