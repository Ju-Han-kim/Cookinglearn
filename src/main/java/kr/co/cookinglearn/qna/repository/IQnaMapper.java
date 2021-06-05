package kr.co.cookinglearn.qna.repository;

import java.util.List;

import kr.co.cookinglearn.qna.model.QnaVO;

public interface IQnaMapper {
	
	//QNA 폼 저장
	void insert(QnaVO qna);
	
	//QNA 리스트 불러오기
	List<QnaVO> getList(int userNo);
	
}
