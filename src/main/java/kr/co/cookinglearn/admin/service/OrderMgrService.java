package kr.co.cookinglearn.admin.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;
import kr.co.cookinglearn.admin.repository.IOrderMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IOrderMgrService;

@Service
public class OrderMgrService implements IOrderMgrService {

	@Autowired
	private IOrderMgrMapper mapper;
	
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

}
