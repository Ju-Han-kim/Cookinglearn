package kr.co.cookinglearn.admin.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.DateVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;

@Service
public class ClassMgrService implements IClassMgrService {
	
	@Autowired
	private IClassMgrMapper mapper;
	
	@Override
	public List<ClassVO> getClassList(ClassSearchVO search, DateVO seDate) {
		if(seDate.getSDate() != null && !seDate.getSDate().equals("")) {
			Timestamp startDate;
			Timestamp endDate;
			
			/* TimeStamp format Setting */
			startDate = Timestamp.valueOf(seDate.getSDate()+" 00:00:00");
			endDate = Timestamp.valueOf(seDate.getEDate()+" 23:59:59");
			
			search.setStartDate(startDate);
			search.setEndDate(endDate);
			
		}
		return mapper.getClassList(search);
	}

	@Override
	public ClassVO getClassInfo(int classCode) {
		return mapper.getClassInfo(classCode);
	}

	@Override
	public int classCount(ClassSearchVO search, DateVO seDate) {
		if(seDate.getSDate() != null && !seDate.getSDate().equals("")) {
			Timestamp startDate;
			Timestamp endDate;
			
			/* TimeStamp format Setting */
			startDate = Timestamp.valueOf(seDate.getSDate()+" 00:00:00");
			endDate = Timestamp.valueOf(seDate.getEDate()+" 23:59:59");
			
			search.setStartDate(startDate);
			search.setEndDate(endDate);
			
		}
		return mapper.classCount(search);
	}

}
