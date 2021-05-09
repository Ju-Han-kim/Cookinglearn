package kr.co.cookinglearn.qna.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.repository.IQnaMapper;

@Service
public class QnaService implements IQnaService {
	
	@Autowired
	private IQnaMapper mapper;
	
	@Override
	public void insert(QnaVO qna) {
		mapper.insert(qna);

	}

}
