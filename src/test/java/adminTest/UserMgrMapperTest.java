package adminTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.common.page.SearchVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMgrMapperTest {
	
	@Autowired
	private IUserMgrMapper mapper;
	
	/*
	//고객번호를 이용한 고객정보 반환
	@Test
	public void getUserInfoTest() {
		
		int userNo = 2;
		UserVO user = mapper.getUserInfo(userNo);
		System.out.println(user);
		
	}
	*/
	
	/*
	//고객의 관리자권한 설정
	@Test
	public void setAdminTest() {
		
		UserVO user = new UserVO();
		user.setUserNo(1);
		user.setAdminLevel(1);
		
		mapper.setAdmin(user);
		
	}
	*/
	
	/*
	//검색 구분자를 전달받아 현재 페이지의 고객 리스트 반환
	@Test
	public void getUserListTest() {
		
		UserSearchVO search = new UserSearchVO();
		
		search.setCondition("");
		search.setKeyword("");
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		
		List<UserVO> userList = mapper.getUserList(search);
		
		System.out.println("=================");
		for(UserVO user : userList) {
			System.out.println(user);
		}
		System.out.println("=================");
		
	}
	*/
	
	/*
	//검색조건에 맞는 전체 고객 수를 반환
	@Test
	public void userCountTest() {
		
		UserSearchVO search = new UserSearchVO();
		
		search.setCondition("");
		search.setKeyword("");
		
		System.out.println("전체 고객 수 : " + mapper.userCount(search));
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
}
