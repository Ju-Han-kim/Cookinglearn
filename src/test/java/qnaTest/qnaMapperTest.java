package qnaTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.repository.IQnaMapper;
import kr.co.cookinglearn.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class qnaMapperTest {

	@Autowired
	private IQnaMapper qnaMapper;
	
	@Autowired
	private IUserMapper userMapper;
	
	/*
	@Test
	public void qnaSubmitTest() {
		
		QnaVO qna = new QnaVO();
		
		for (int i = 0; i < 10; i++) {
			qna.setTitle(i + "번째 글");
			qna.setQnaContent(i + "번째로 문의를 합니다." );
			qna.setUserNo(57);
			qna.setWriter(userMapper.selectOne("choi_jun_woo@naver.com").getNickname());
			
			qnaMapper.insert(qna);
		}
	}*/
	
	
	
}
