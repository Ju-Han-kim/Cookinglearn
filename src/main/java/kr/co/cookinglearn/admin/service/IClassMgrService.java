package kr.co.cookinglearn.admin.service;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.DateVO;
import kr.co.cookinglearn.admin.model.ClassVO;

public interface IClassMgrService {

	//검색 구분자를 전달받아 현재 페이지의 강의 리스트 반환
	List<ClassVO> getClassList(ClassSearchVO search, DateVO seDate);
	
	//강의번호를 이용하여 강의 전체정보 반환
	ClassVO getClassInfo(int classCode);
	
	//검색조건에 맞는 전체 강의 수를 반환
	int classCount(ClassSearchVO search, DateVO seDate);
	
}
