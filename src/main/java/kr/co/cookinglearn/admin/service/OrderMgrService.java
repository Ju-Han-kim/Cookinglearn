package kr.co.cookinglearn.admin.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.model.OrderVO;
import kr.co.cookinglearn.admin.model.ReviewVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;
import kr.co.cookinglearn.admin.repository.IClassMgrMapper;
import kr.co.cookinglearn.admin.repository.IOrderMgrMapper;
import kr.co.cookinglearn.admin.repository.IReviewMgrMapper;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IOrderMgrService;

@Service
public class OrderMgrService implements IOrderMgrService {

	@Autowired
	private IOrderMgrMapper mapper;
	
	@Autowired
	private IReviewMgrMapper reviewMapper;
	
	@Autowired
	private IUserMgrMapper userMapper;
	
	@Autowired
	private IClassMgrMapper classMapper;
	
	@Override
	public List<OrderViewVO> getOrderList(OrderSearchVO search) {
		calcDate(search);
		return mapper.getOrderList(search);
	}

	@Override
	public int orderCount(OrderSearchVO search) {
		calcDate(search);
		return mapper.orderCount(search);
	}

	@Override
	public OrderViewVO getOrderInfo(int orderNo) {
		return mapper.getOrderInfo(orderNo);
	}
	
	private void calcDate(OrderSearchVO search) {
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
	
	@Override
	public List<ReviewVO> getUserReview(OrderVO order) {
		
		Map<String, Integer> datas = new HashMap<String, Integer>();
		
		datas.put("classCode", order.getClassCode());
		datas.put("userNo", order.getUserNo());
		
		return reviewMapper.getUserReview(datas);
	}
	
	@Override
	public ClassVO getClassInfo(int classCode) {
		return classMapper.getClassInfo(classCode);
	}
	
	@Override
	public UserVO getUserInfo(int userNo) {
		return userMapper.getUserInfo(userNo);
	}

}
