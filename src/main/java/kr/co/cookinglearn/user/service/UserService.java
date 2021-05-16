package kr.co.cookinglearn.user.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.repository.IUserMapper;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int checkId(String account) {
		return mapper.checkId(account);
	}
	
	@Override
	public int checkNickname(String nickname) {
		return mapper.checkNickname(nickname);
	}
	
	
	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public void changeInfo(UserVO user) {

	}

	@Override
	public void register(UserVO user) {
		mapper.register(user);
	}

	@Override
	public UserVO selectOne(String account) {
		int result = mapper.selectOne(account).getAdminLevel();
		System.out.println("service AdminLevel: " + result);
		return mapper.selectOne(account);
	}

	@Override
	public void delete(String account) {

	}

	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href=document.referrer;");
		out.println("</script>");
		out.close();
	}

}
