package kr.co.cookinglearn.qna.sevice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.repository.IQnaMapper;
import kr.co.cookinglearn.user.controller.UserController;
import kr.co.cookinglearn.user.model.UserVO;

@Service
public class QnaService implements IQnaService {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaService.class);
	
	@Autowired
	private IQnaMapper mapper;
	
	@Override
	public void insert(QnaVO qna, UserVO user) {
		
		qna.setUserNo(user.getUserNo());
		qna.setWriter(user.getNickname());
		mapper.insert(qna);
	}

	@Override
	public List<QnaVO> getList(int userNo) {
		return mapper.getList(userNo);
	}

}
