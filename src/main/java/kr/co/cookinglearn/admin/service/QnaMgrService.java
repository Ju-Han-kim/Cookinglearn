package kr.co.cookinglearn.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.repository.IQnaMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IQnaMgrService;

@Service
public class QnaMgrService implements IQnaMgrService {

	@Autowired
	private IQnaMgrMapper mapper;
	
	@Override
	public List<QnaVO> getQnaList(QnaSearchVO search) {
		return mapper.getQnaList(search);
	}

	@Override
	public int qnaCount(QnaSearchVO search) {
		return mapper.qnaCount(search);
	}

	@Override
	public void setAnswer(QnaVO qna) {
		mapper.setAnswer(qna);
	}

}
