package kr.co.cookinglearn.admin.service.interfaces;

import java.util.List;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;

public interface IClassMgrService {

	//검색 구분자를 전달받아 현재 페이지의 강의 리스트 반환
	List<ClassVO> getClassList(ClassSearchVO search);
	
	//강의번호를 이용하여 강의 전체정보 반환
	ClassVO getClassInfo(int classCode);
	
	//검색조건에 맞는 전체 강의 수를 반환
	int classCount(ClassSearchVO search);
	
	//오프라인 완료대기 강의리스트 반환
	List<ClassVO> getClassListByOrder(ClassSearchVO search);
	
	//오프라인 완료대기 강의수를 반환
	int classCountByOrder(ClassSearchVO search);
	
	//클래스 번호를 받아 클래스 삭제
	boolean classDelete(int classCode);
	
	//강의 등록
	void regClass(ClassVO classInfo);
	
	//강의 수정
	void modClass(ClassVO classInfo);
	
	//강의 이미지List 반환
	List<String> getContentImg(int classCode);
	
}
