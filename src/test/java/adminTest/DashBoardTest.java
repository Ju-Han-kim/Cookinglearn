package adminTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.process.DashBoardProcessVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;
import kr.co.cookinglearn.admin.repository.IDashBoardMapper;
import kr.co.cookinglearn.admin.repository.IOrderMgrMapper;
import kr.co.cookinglearn.admin.repository.IQnaMgrMapper;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DashBoardTest {
	
	@Autowired
	private IOrderMgrMapper orderMapper;
	
	@Autowired
	private IUserMgrMapper userMapper;
	
	@Autowired
	private IQnaMgrMapper qnaMapper;
	
	@Autowired
	private IClassMgrMapper classMapper;
	
	@Autowired
	private IDashBoardMapper dashBoardMapper;
	
	/*
	//결제일자가 오늘인 결제완료<반품되지 않은 건>(온/오프), 반품건수 조회
	@Test
	public void orderCountTest() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Date now = new Date();
		
		List<DashBoardProcessVO> list = dashBoardMapper.classOrderCount(sdf.format(now));
		
		System.out.println("==================");

		for(DashBoardProcessVO dp : list) {
			System.out.println(dp);
		}
		
		System.out.println("==================");
		
		
	}
	*/
	
	/*
	//오프라인 오늘강의, 내일강의 / 완료대기강의 수 반환
	@Test
	public void classCountTest() {
		
		ClassSearchVO search = new ClassSearchVO();
		//오늘강의
		search.setClassType(false);
		search.setStartDate(Timestamp.valueOf("2021-05-14 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-14 24:59:59.99"));
		
		int todayOffClass = classMapper.classCount(search);
		System.out.println("오늘강의 수 : " + todayOffClass);
		
		//내일강의
		search.setClassType(false);
		search.setStartDate(Timestamp.valueOf("2021-05-15 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-15 24:59:59.99"));
		
		int tomorrowOffClass = classMapper.classCount(search);
		System.out.println("내일강의 수 : " + tomorrowOffClass);
		
		//완료대기강의
		search.setComplete(true);
		search.setClassType(false);
		search.setStartDate(null);
		search.setEndDate(null);
		
		int WaitForCompletion = classMapper.classCountByOrder(search);

		System.out.println("완료대기강의 수 : " + WaitForCompletion);
		
	}
	*/
	
	/*
	//신규가입자 수 반환
	@Test
	public void userCount() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Date now = new Date();
		
		int regUser = userMapper.regCount(sdf.format(now));
		
		System.out.println("금일 회원가입 user 수 : " + regUser);
	}
	*/
	/*
	//미처리 문의건 수 반환
	@Test
	public void qnaCountTest() {
		
		QnaSearchVO search = new QnaSearchVO();

		search.setComplete(false);
		
		int qnaCount = qnaMapper.qnaCount(search);
		
		System.out.println("문의 수 : " + qnaCount);
	}
	*/
	
	
	/******************************************************************/
	
	/*
	//날짜별, 온/오프라인 클래스별, 진행상태별 건수/비용 반환 테스트
	@Test
	public void classPaymentCountTest() {
		
		List<DashBoardProcessVO> list = dashBoardMapper.classPaymentCount();
		
		System.out.println("=======================");

		for(DashBoardProcessVO unit : list) {
			System.out.println(unit);
		}

		System.out.println("=======================");
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
