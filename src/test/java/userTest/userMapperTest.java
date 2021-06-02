package userTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class userMapperTest {
	
	@Autowired
	private IUserMapper userMapper;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {

	       return new BCryptPasswordEncoder();
	}
	
	/*
	@Test
	public void userRegisterTest() {
		
		UserVO user = new UserVO();
		BCryptPasswordEncoder encoder = passwordEncoder();
		
		for (int i = 1; i <= 10; i++) {
			
			user.setUserId("user"+i+"@gmail.com");
			String password = encoder.encode("user"+i+"_password");
			user.setUserPassword(password);
			user.setGender(1);
			user.setNickname("user"+i);
			user.setAdminLevel(0);
			
			userMapper.register(user);
			
		}
	}
	
	
	@Test
	public void selectOneTest() {
		
		for (int i = 1; i < 10; i++) {
			UserVO user = userMapper.selectOne("user"+i+"@gmail.com");
			System.out.println(user.toString());
		}
		
	}*/
	
}
