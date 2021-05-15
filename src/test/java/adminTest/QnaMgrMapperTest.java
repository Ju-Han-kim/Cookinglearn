package adminTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.repository.IQnaMgrMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class QnaMgrMapperTest {

	@Autowired
	private IQnaMgrMapper mapper;

	/*
	//검색결과와 답변여부에 따라 문의리스트 반환테스트
	@Test
	public void getQnaListTest() {

		QnaSearchVO search = new QnaSearchVO();

		search.setCurrentPage(2);
		search.setMessagePerPage(3);
		search.setCondition("writer");
		search.setKeyword("작");
		search.setComplete(false);

		List<QnaVO> list = mapper.getQnaList(search);

		System.out.println("========================");

		for(QnaVO qna : list) {

			System.out.println(qna);

		}

		System.out.println("========================");
	}
	 */
	
	/*
	//검색결과와 답변여부에 따른 문의 수 반환
	@Test
	public void qnaCountTest() {

		QnaSearchVO search = new QnaSearchVO();

		search.setCurrentPage(2);
		search.setMessagePerPage(3);
		search.setCondition("writer");
		search.setKeyword("작");
		search.setComplete(false);
		
		int count = mapper.qnaCount(search);
		
		System.out.println("문의 수 : " + count);
		
	}
	*/
	
	/*
	//해당 문의정보를 받아 답변내용 등록
	@Test
	public void setAnswerTest() {
		
		QnaVO qna = new QnaVO();
		
		qna.setQnaNo(1);
		qna.setAnswer("테스트 답변입니다.");
		
		mapper.setAnswer(qna);
		
	}
	*/
























}
