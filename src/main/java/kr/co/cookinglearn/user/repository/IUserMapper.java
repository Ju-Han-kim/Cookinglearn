package kr.co.cookinglearn.user.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.co.cookinglearn.user.model.ClassVO;
import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.model.process.MyClassVO;

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
	
	//계정 활성화
	void activationUser(String userId);
	
	//계정정보와 강의상태를 입력받아 강의리스트 반환
	List<MyClassVO> getMyClassList(Map<String, Integer> datas);
	
	//선택된 신청강의의 상태를 변경
	void setOrderProcess(Map<String, Integer> datas);
	
}
