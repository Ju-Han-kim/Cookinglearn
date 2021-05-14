package kr.co.cookinglearn.admin.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.process.DashBoardProcessVO;
import kr.co.cookinglearn.admin.model.process.DashBoardTodayVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;
import kr.co.cookinglearn.admin.repository.IDashBoardMapper;
import kr.co.cookinglearn.admin.repository.IQnaMgrMapper;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IDashBoardService;

@Service
public class DashBoardService implements IDashBoardService {
	
	@Autowired
	private IDashBoardMapper dashBoardMapper;
	
	@Autowired
	private IUserMgrMapper userMapper;
	
	@Autowired
	private IQnaMgrMapper qnaMapper;
	
	@Autowired
	private IClassMgrMapper classMapper;
	
	@Override
	public DashBoardTodayVO todayWork() {
		
		DashBoardTodayVO todayWork = new DashBoardTodayVO();
		//결제완료, 반품건수 setting
		int onComplete = 0;
		int offComplete = 0;
		int onReturn = 0;
		int offReturn = 0;
		
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		List<DashBoardProcessVO> countList = dashBoardMapper.classOrderCount(sdf1.format(now));
		
		for(DashBoardProcessVO count : countList) {
			if(count.isClassType()) {
				switch (count.getOrderProcess()) {
				case 0:
				case 1:
				case 2:
					onComplete += count.getCount();
					break;
				case 3:
					onReturn += count.getCount();
					break;
				}
			} else {
				switch (count.getOrderProcess()) {
				case 0:
				case 1:
				case 2:
					offComplete += count.getCount();
					break;
				case 3:
					offReturn += count.getCount();
					break;
				}
			}
		}
		
		todayWork.setOnComplete(onComplete);
		todayWork.setOffComplete(offComplete);
		todayWork.setOnReturn(onReturn);
		todayWork.setOffReturn(offReturn);
		
		
		//오늘강의, 내일강의, 완료대기강의 setting
		ClassSearchVO classSearch = new ClassSearchVO();
		classSearch.setClassType(false);
		String today = sdf2.format(now);
		String tomorrow = sdf2.format(new Date(now.getTime()+ 1000 * 60 * 60 * 24L));
		String startTime = " 00:00:00.0";
		String endTime = " 24:59:59.99";
		
		//1.오늘강의
		classSearch.setStartDate(Timestamp.valueOf(today+startTime));
		classSearch.setEndDate(Timestamp.valueOf(today+endTime));
		
		int todayOffClass = classMapper.classCount(classSearch);
		todayWork.setTodayOffClass(todayOffClass);
		
		//2.내일강의
		classSearch.setStartDate(Timestamp.valueOf(tomorrow+startTime));
		classSearch.setEndDate(Timestamp.valueOf(tomorrow+endTime));
		
		int tomorrowOffClass = classMapper.classCount(classSearch);
		todayWork.setTomorrowOffClass(tomorrowOffClass);
		
		//3.완료대기강의
		classSearch.setComplete(true);
		classSearch.setStartDate(null);
		classSearch.setEndDate(null);
		
		int WaitForCompletion = classMapper.classCountByOrder(classSearch);
		todayWork.setWaitForCompletion(WaitForCompletion);
		
		//신규가입자 수 setting
		int newUser = userMapper.regCount(sdf1.format(now));
		todayWork.setNewUser(newUser);
		
		//미처리 문의건 수 setting
		QnaSearchVO qnaSearch = new QnaSearchVO();
		qnaSearch.setComplete(false);
		
		int qnaCount = qnaMapper.qnaCount(qnaSearch);
		todayWork.setQnaCount(qnaCount);
		return todayWork;
	}

}
