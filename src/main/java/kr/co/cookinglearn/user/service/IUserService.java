package kr.co.cookinglearn.user.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kr.co.cookinglearn.user.model.UserVO;

public interface IUserService {

	//아이디 중복 체크 기능
	int checkId(String account);
	
	//닉네임 중복 체크 기능
	int checkNickname(String nickname);
	
	//회원 정보 전체 조회 기능
	List<UserVO> selectAll();

	//회원 정보 수정
	void changeInfo(UserVO user);

	//회원 가입 기능
	void register(UserVO user);

	//회원 정보 조회 기능
	UserVO selectOne(String account);

	//회원 탈퇴 기능
	void delete(String account);
	
	//로그아웃 기능
	void logout(HttpServletResponse response) throws Exception;

}