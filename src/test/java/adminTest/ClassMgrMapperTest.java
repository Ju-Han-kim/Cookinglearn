package adminTest;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.model.process.ClassStudentsVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;


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

	/*
	//클래스 번호를 받아 클래스삭제 테스트
	@Test
	public void classDeleteTest() {
		int classCode = 10;
		
		mapper.classDelete(classCode);
	}
	*/
	
	/*
	//강의등록 단위테스트
	@Test
	public void regClassTest() {
		
		ClassVO classInfo = new ClassVO();
		
		classInfo.setClassType(false);
		classInfo.setClassCategory("한식");
		classInfo.setThumbnailImg("/img/0");
		classInfo.setClassName("강의이름25");
		classInfo.setClassContent("상세내용25");
		classInfo.setRunTime(60);
		classInfo.setStartDate(Timestamp.valueOf("2021-05-15 24:59:59.99"));
		classInfo.setContentImg("");
		classInfo.setClassUrl("");
		classInfo.setPrice(60000);
		classInfo.setMaxStudent(4);
		
		mapper.regClass(classInfo);

	}
	*/
	
	/*
	//강의수정 단위테스트
	@Test
	public void modClassTest() {
		
		ClassVO classInfo = new ClassVO();
		
		classInfo.setClassCode(142);
		classInfo.setClassType(false);
		classInfo.setClassCategory("한식");
		classInfo.setThumbnailImg("/img/0");
		classInfo.setClassName("강의이름25");
		classInfo.setClassContent("상세내용25");
		classInfo.setRunTime(60);
		classInfo.setStartDate(new Timestamp(System.currentTimeMillis()));
		classInfo.setContentImg("");
		classInfo.setClassUrl("");
		classInfo.setPrice(60000);
		classInfo.setMaxStudent(4);
		
		mapper.modClass(classInfo);

	}
	*/
	
	/*
	//classCode를 입력받아 contentImg 반환후 split 단위테스트
	@Test
	public void contentImgTest() {
		int classCode = 144;
		
		String contentImg = mapper.getContentImg(classCode);
		
		List<String> list = Arrays.asList(contentImg.split("\\|"));
		
		System.out.println("=======================");
		for(String cImg : list) {
			System.out.println(cImg);
		}
		System.out.println("=======================");

	}
	*/
	
	/*
	//선택된 강의의 신청인원 정보 List반환 테스트
	@Test
	public void getStudents() {
		
		int classCode = 1;
		
		List<ClassStudentsVO> list = mapper.getStudents(classCode);
		
		System.out.println("================");
		if(!list.isEmpty()) {
			for(ClassStudentsVO student : list) {
				System.out.println(student);
			}
		}
		System.out.println("================");
		
	}
	*/
	
	/*
	//주문번호를 받아 결제내역의 진행상태를 '수강완료(2)'으로 변경테스트
	@Test
	public void setProcessTest() {
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		int orderNo = 70;
		int orderProcess = 2;
		
		datas.put("orderNo", orderNo);
		datas.put("orderProcess", orderProcess);
		
		mapper.setProcess(datas);
		
	}
	*/
	
	
	
	
	
}
