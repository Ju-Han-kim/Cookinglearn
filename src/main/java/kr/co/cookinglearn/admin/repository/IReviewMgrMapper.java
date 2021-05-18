package kr.co.cookinglearn.admin.repository;

import java.util.List;
import java.util.Map;

import kr.co.cookinglearn.admin.model.ReviewVO;
import kr.co.cookinglearn.admin.model.process.ReviewClassVO;

public interface IReviewMgrMapper {
	
	//강의번호를 받아 리뷰리스트 반환
	List<ReviewVO> getReview(int classCode);
	
	//강의번호와 유저번호를 받아 리뷰리스트 반환
	List<ReviewVO> getUserReview(Map<String, Integer> datas);
	
	//유저번호를 받아 리뷰리스트 반환
	List<ReviewClassVO> getUserReviewWithClass(int userNo);
	
}
