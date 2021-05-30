package userTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class userMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	/*
	@Test
	public void userRegisterTest() {
		
		UserVO user = new UserVO();
		
		for (int i = 0; i < 10; i++) {
			
			user.setUserId("choijunwoo"+i+"@gmail.com");
			user.setUserPassword("1234!!!!");
			user.setGender(1);
			user.setNickname("준우"+i);
			//user.setAuthStatus(1);
			
			mapper.register(user);
			
		}
	}
	
	@Test
	public void userSettingAuthStatusTest() {
		
		for (int i = 0; i < 10; i++) {
			
			String userId = "choijunwoo"+i+"@gmail.com";
			String authKey = "11111"+i;
			
			mapper.updateAuthKey(userId, authKey);
			mapper.updateAuthStatus(userId, authKey);
		}
		
		
		
		
		
	}
	*/
	
	
}
