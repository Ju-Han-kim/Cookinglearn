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
	
	//QNA 폼 저장
	@Override
	public void insert(QnaVO qna, UserVO user) {
		
		qna.setUserNo(user.getUserNo());
		qna.setWriter(user.getNickname());
		String originalContent = qna.getQnaContent();
		String changedContent;
		changedContent = originalContent.replaceAll("\n", "<br>");
		changedContent = changedContent.replaceAll(" ", "&nbsp;");
		qna.setQnaContent(changedContent);
		
		mapper.insert(qna);
	}
	
	//QNA 리스트 불러오기
	@Override
	public List<QnaVO> getList(int userNo) {
		List<QnaVO> qna = mapper.getList(userNo);
		
		for (QnaVO vo : qna) {
			String originalContent = vo.getQnaContent();
			String changedContent;
			changedContent = originalContent.replaceAll("<br>", "\n");
			changedContent = changedContent.replaceAll("&nbsp;", " ");
			vo.setQnaContent(changedContent);
		}
		
		return qna;
	}

}
