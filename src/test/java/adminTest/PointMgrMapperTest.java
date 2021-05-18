package adminTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;import kr.co.cookinglearn.admin.model.PointVO;
import kr.co.cookinglearn.admin.repository.IPointMgrMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PointMgrMapperTest {
	
	@Autowired
	private IPointMgrMapper mapper;
	
	/*
	//사용자정보를 받아 적립금 리스트 반환테스트
	@Test
	public void getUserPointListTest() {
		
		int userNo = 1;
		
		List<PointVO> pointList = mapper.getUserPointList(userNo);
		
		if(!pointList.isEmpty()) {
			System.out.println("===============================");
			for(PointVO point : pointList) {
				System.out.println(point);
			}
			System.out.println("===============================");
		} else {
			System.out.println("포인트 내역이 존재하지 않습니다.");
		}
	}
	*/
	
	/*
	//사용자정보를 받아 적립금 현재금액 반환테스트
	@Test
	public void getUserPointTest() {
		
		int userNo = 1;
		
		int point = mapper.getUserPoint(userNo);
		
		System.out.println("잔여포인트 : " + point);
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
