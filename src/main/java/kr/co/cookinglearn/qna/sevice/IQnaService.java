package kr.co.cookinglearn.qna.sevice;

import java.util.List;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.user.model.UserVO;

public interface IQnaService {
	
	void insert(QnaVO qna, UserVO user);
	
	List<QnaVO> getList(int userNo);
	
}
