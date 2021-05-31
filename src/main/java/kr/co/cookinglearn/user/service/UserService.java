package kr.co.cookinglearn.user.service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.user.model.ClassVO;
import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.model.process.MyClassVO;
import kr.co.cookinglearn.user.repository.IUserMapper;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Autowired
	BCryptPasswordEncoder  passwordEncoder;
	
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
		mapper.changeInfo(user);
	}

	@Override
	public void register(UserVO user) {
		String encPassword = passwordEncoder.encode(user.getUserPassword());
		user.setUserPassword(encPassword);
		mapper.register(user);
	}

	@Override
	public UserVO selectOne(String account) {
		return mapper.selectOne(account);
	}

	@Override
	public void delete(String account, HttpSession session, HttpServletResponse response) throws Exception {
		mapper.delete(account);
		session.invalidate();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.replace('/');");
		out.println("alert('회원 탈퇴에 성공했습니다');");
		out.println("</script>");
		out.close();
	}

	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.replace('/');");
		out.println("</script>");
		out.close();
	}

	@Override
	public ClassVO myClassWatch(int classCode) {
		return mapper.myClassWatch(classCode);
	}

	@Override
	public void activationUser(String userId) {
		mapper.activationUser(userId);
	}
	
	@Override
	public List<MyClassVO> getMyClassList(int userNo, int orderProcess) {
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		datas.put("userNo", userNo);
		datas.put("orderProcess", orderProcess);
		
		return mapper.getMyClassList(datas);
	}
	
	@Override
	public void setOrderProcess(int orderNo, int orderProcess) {
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		datas.put("orderNo", orderNo);
		datas.put("orderProcess", orderProcess);
		
		mapper.setOrderProcess(datas);
		
	}
	
}
