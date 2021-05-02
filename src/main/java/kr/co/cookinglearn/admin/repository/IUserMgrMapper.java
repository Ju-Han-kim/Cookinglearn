package kr.co.cookinglearn.admin.repository;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.UserSearchVO;
import kr.co.cookinglearn.admin.model.UserVO;

public interface IUserMgrMapper {

	//검색 구분자를 전달받아 현재 페이지의 고객 리스트 반환
	List<UserVO> getUserList(UserSearchVO search);
	
	//고객번호를 이용하여 고객 전체정보 반환
	UserVO getUserInfo(int userNo);
	
	//고객의 관리자권한을 설정
	void setAdmin(UserVO user);
	
}
