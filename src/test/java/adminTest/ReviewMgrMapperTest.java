package adminTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.model.ReviewVO;
import kr.co.cookinglearn.admin.model.process.ReviewClassVO;
import kr.co.cookinglearn.admin.repository.IReviewMgrMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReviewMgrMapperTest {
	
	@Autowired
	private IReviewMgrMapper mapper;
	
	/*
	//강의번호를 받아 리뷰리스트 반환테스트
	@Test
	public void getReviewTest() {
		
		int classCode = 1;
		
		List<ReviewVO> list = mapper.getReview(classCode);
		
		if(!list.isEmpty()) {
			System.out.println("===================");
			for(ReviewVO review : list) {
				System.out.println(review);
			}
			System.out.println("===================");
		} else {
			System.out.println("리뷰가 없습니다.");
		}
		
	}
	 */
	
	/*
	//강의번호와 유저번호를 받아 리뷰리스트 반환테스트
	@Test
	public void getUserReviewTest() {
		
		int classCode = 2;
		int userNo = 1;
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		datas.put("classCode", classCode);
		datas.put("userNo", userNo);
		
		List<ReviewVO> list = mapper.getUserReview(datas);
		
		if(!list.isEmpty()) {
			System.out.println("===================");
			for(ReviewVO review : list) {
				System.out.println(review);
			}
			System.out.println("===================");
		} else {
			System.out.println("리뷰가 없습니다.");
		}
		
	}
	*/
	
	/*
	//유저번호를 받아 리뷰리스트 반환테스트
	@Test
	public void getUserReviewWithClassTest() {
		
		int userNo = 2;
		
		List<ReviewClassVO> list = mapper.getUserReviewWithClass(userNo);
		
		if(!list.isEmpty()) {
			System.out.println("===================");
			for(ReviewClassVO review : list) {
				System.out.println(review);
			}
			System.out.println("===================");
		} else {
			System.out.println("리뷰가 없습니다.");
		}
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
}
