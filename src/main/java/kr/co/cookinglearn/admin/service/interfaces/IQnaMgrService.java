package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;

public interface IQnaMgrService {
	
	//검색결과와 답변여부에 따라 문의리스트 반환
	List<QnaVO> getQnaList(QnaSearchVO search);

	//검색결과와 답변여부에 따른 문의 수 반환
	int qnaCount(QnaSearchVO search);

	//해당 문의정보를 받아 답변내용 등록
	String setAnswer(QnaVO qna);
	
}
