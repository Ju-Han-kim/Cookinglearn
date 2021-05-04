package kr.co.cookinglearn.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;

@Service
public class ClassMgrService implements IClassMgrService {
	
	@Autowired
	private IClassMgrMapper mapper;
	
	@Override
	public List<ClassVO> getClassList(ClassSearchVO search) {
		return mapper.getClassList(search);
	}

	@Override
	public ClassVO getClassInfo(int classCode) {
		return mapper.getClassInfo(classCode);
	}

	@Override
	public int classCount(ClassSearchVO search) {
		return mapper.classCount(search);
	}

}
