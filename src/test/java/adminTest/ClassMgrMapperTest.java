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
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;
import kr.co.cookinglearn.admin.model.ClassVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ClassMgrMapperTest {

	@Autowired
	private IClassMgrMapper mapper;

	/*
	//검색 구분자를 전달받아 현재 페이지의 강의 리스트 반환테스트
	@Test
	public void getClassListTest() {

		ClassSearchVO search = new ClassSearchVO();

		search.setClassType(false);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-07 24:59:59.99"));
		search.setClassCategory("한식");
		search.setCondition("classNameContent");
		search.setKeyword("1");

		List<ClassVO> classList = mapper.getClassList(search);

		System.out.println("=======================");

		for(ClassVO classInfo : classList) {
			System.out.println(classInfo);
		}

		System.out.println("=======================");

	}
	 */

	/*
	//강의번호를 이용하여 강의 전체정보 반환테스트
	@Test
	public void getClassInfoTest() {

		int classCode = 2;
		ClassVO classInfo = mapper.getClassInfo(classCode);

		System.out.println(classInfo);

	}
	 */

	/*
	//검색조건에 맞는 전체 강의 수를 반환테스트
	@Test
	public void classCountTest() {

		ClassSearchVO search = new ClassSearchVO();

		search.setClassType(true);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-07 24:59:59.99"));
		search.setClassCategory("한식");
		search.setCondition("classNameContent");
		search.setKeyword("1");
		
		int classCount = mapper.classCount(search);
		
		System.out.println("강의 수 : " + classCount);

	}
	*/
	
	/*
	//초기 오늘 ~ 1년 뒤 날짜세팅을 위한 날짜계산 테스트
	@Test
	public void DateTest() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date from = new Date();
		Date to = new Date(from.getTime() + 60*60*24*365*1000L);
		
		System.out.println(sdf.format(from)+" ~ "+sdf.format(to));
	}
	*/

	/*
	//오프라인 완료대기 강의리스트 반환테스트
	@Test
	public void classOrderListTest() {
		
		ClassSearchVO search = new ClassSearchVO();

		search.setComplete(true);
		search.setClassType(false);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setClassCategory("all");
		search.setCondition("classNameContent");
		search.setKeyword("");
		
		List<ClassVO> classList = mapper.getClassListByOrder(search);

		System.out.println("=======================");

		for(ClassVO classInfo : classList) {
			System.out.println(classInfo);
		}

		System.out.println("=======================");
		
	}
	*/
	
	/*
	//오프라인 완료대기 강의수를 반환테스트
	@Test
	public void classCountByOrderTest() {

		ClassSearchVO search = new ClassSearchVO();

		search.setComplete(true);
		search.setClassType(false);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setClassCategory("all");
		search.setCondition("classNameContent");
		search.setKeyword("");
		
		int classCount = mapper.classCountByOrder(search);
		
		System.out.println("강의 수 : " + classCount);

	}
	*/
	
	/*
	//오프라인 완료 강의리스트 반환테스트
	@Test
	public void classOrderListTest() {
		
		ClassSearchVO search = new ClassSearchVO();

		search.setComplete(false);
		search.setClassType(false);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setClassCategory("all");
		search.setCondition("classNameContent");
		search.setKeyword("");
		
		List<ClassVO> classList = mapper.getClassListByOrder(search);

		System.out.println("=======================");

		for(ClassVO classInfo : classList) {
			System.out.println(classInfo);
		}

		System.out.println("=======================");
		
	}
	*/
	
	/*
	//오프라인 완료대기 강의수를 반환테스트
	@Test
	public void classCountByOrderTest() {

		ClassSearchVO search = new ClassSearchVO();

		search.setComplete(false);
		search.setClassType(false);
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setClassCategory("all");
		search.setCondition("classNameContent");
		search.setKeyword("");
		
		int classCount = mapper.classCountByOrder(search);
		
		System.out.println("강의 수 : " + classCount);

	}
	*/







}
