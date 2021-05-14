package kr.co.cookinglearn.admin.repository;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.SearchVO;
import kr.co.cookinglearn.admin.model.UserVO;

public interface IUserMgrMapper {

	//검색 구분자를 전달받아 현재 페이지의 고객 리스트 반환
	List<UserVO> getUserList(SearchVO search);
	
	//고객번호를 이용하여 고객 전체정보 반환
	UserVO getUserInfo(int userNo);
	
	//고객의 관리자권한을 설정
	void setAdmin(UserVO user);
	
	//검색조건에 맞는 전체 고객 수를 반환
	int userCount(SearchVO search);
	
	//오늘 날짜를 입력받아 가입한 회원 수 반환
	int regCount(String today);
}
