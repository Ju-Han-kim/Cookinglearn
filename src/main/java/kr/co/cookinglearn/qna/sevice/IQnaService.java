package kr.co.cookinglearn.qna.sevice;

import java.util.List;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.user.model.UserVO;

public interface IQnaService {
	
	//QNA 폼 저장
	void insert(QnaVO qna, UserVO user);
	
	//QNA 리스트 불러오기
	List<QnaVO> getList(int userNo);
	
}
