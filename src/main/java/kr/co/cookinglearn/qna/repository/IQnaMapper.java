package kr.co.cookinglearn.qna.repository;

import java.util.List;

import kr.co.cookinglearn.qna.model.QnaVO;

public interface IQnaMapper {
	
	void insert(QnaVO qna);
	
	List<QnaVO> getList(int userNo);
	
}
