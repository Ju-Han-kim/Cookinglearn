package qnaTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.repository.IQnaMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class qnaMapperTest {

	@Autowired
	private IQnaMapper mapper;
	
	@Test
	public void qnaSubmitTest() {
		
		QnaVO qna = new QnaVO();
		
		for (int i = 0; i < 10; i++) {
			qna.setTitle(i + "번째 글");
			qna.setQnaContent(10 - i + "초 남았습니다.");
			qna.setUserNo(1);
			qna.setWriter("소벌도리");
			
			mapper.insert(qna);
		}
	}
	
	
	
}
