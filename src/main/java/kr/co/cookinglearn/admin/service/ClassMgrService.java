package kr.co.cookinglearn.admin.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.model.OrderVO;
import kr.co.cookinglearn.admin.model.process.ClassStudentsVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IClassMgrService;

@Service
public class ClassMgrService implements IClassMgrService {
	
	@Autowired
	private IClassMgrMapper mapper;
	
	@Override
	public List<ClassVO> getClassList(ClassSearchVO search) {

		calcDate(search);
		return mapper.getClassList(search);
	}

	@Override
	public ClassVO getClassInfo(int classCode) {
		return mapper.getClassInfo(classCode);
	}

	@Override
	public int classCount(ClassSearchVO search) {
		calcDate(search);
		return mapper.classCount(search);
	}
	
	@Override
	public List<ClassVO> getClassListByOrder(ClassSearchVO search) {
		calcDate(search);
		return mapper.getClassListByOrder(search);
	}
	
	@Override
	public int classCountByOrder(ClassSearchVO search) {
		calcDate(search);
		return mapper.classCountByOrder(search);
	}
	
	private void calcDate(ClassSearchVO search) {
		if(!search.getSeDate().equals("")) {
			Timestamp startDate;
			Timestamp endDate;
			
			/* TimeStamp format Setting */
			String sDate = search.getSeDate().substring(0, 10);
			String eDate = search.getSeDate().substring(13, 23);
			startDate = Timestamp.valueOf(sDate + " 00:00:00");
			endDate = Timestamp.valueOf(eDate + " 23:59:59");
			
			search.setStartDate(startDate);
			search.setEndDate(endDate);
		}
	}
	
	@Override
	public boolean classDelete(int classCode) {
		boolean flag = true;
		
		try {
			mapper.classDelete(classCode);
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	@Override
	public void regClass(ClassVO classInfo) {
		
		if(classInfo.isClassType()) {
			String url = classInfo.getClassUrl();
			if(url.contains("youtube")) {
				String chUrl = url.replace("watch?v=", "embed/");
				classInfo.setClassUrl(chUrl);
			}
			classInfo.setRunTime(classInfo.getRunTime()*60*24);
			classInfo.setStartDate(new Timestamp(System.currentTimeMillis()));
		}
		
		mapper.regClass(classInfo);
	}
	
	@Override
	public void modClass(ClassVO classInfo) {
		
		if(classInfo.isClassType()) {
			String url = classInfo.getClassUrl();
			if(url.contains("youtube")) {
				String chUrl = url.replace("watch?v=", "embed/");
				classInfo.setClassUrl(chUrl);
			}
			classInfo.setRunTime(classInfo.getRunTime()*60*24);
		}
		
		mapper.modClass(classInfo);
	}
	
	@Override
	public List<String> getContentImg(int classCode) {
		List<String> contentImg = null;

		String contentImgStr = mapper.getContentImg(classCode);
		
		if(contentImgStr != null) {
			contentImg = Arrays.asList(contentImgStr.split("\\|"));
		}
		
		return contentImg;
	}
	
	@Override
	public List<ClassStudentsVO> getStudents(int classCode) {
		return mapper.getStudents(classCode);
	}
	
	@Override
	public void setProcess(OrderVO order) {
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		datas.put("orderNo", order.getOrderNo());
		datas.put("orderProcess", OrderVO.COMPLETE_CLASS);
		
		mapper.setProcess(datas);
		
	}
	
	
	
	
	
	
}

