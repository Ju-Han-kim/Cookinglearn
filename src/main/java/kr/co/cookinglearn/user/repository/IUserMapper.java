package kr.co.cookinglearn.user.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.co.cookinglearn.user.model.ClassVO;
import kr.co.cookinglearn.user.model.UserVO;

public interface IUserMapper {
	
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
	
	//클래스 시청
	ClassVO myClassWatch(int classCode);
	
	//setAuthKey
	void updateAuthKey(@Param("userId") String userId, @Param("authKey") String authKey);

	//updateAuthStatus
	void updateAuthStatus(@Param("userId") String userId, @Param("authKey") String authKey);

}
