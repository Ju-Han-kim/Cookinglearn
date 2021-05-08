package adminTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.model.OrderViewVO;
import kr.co.cookinglearn.admin.repository.IOrderMgrMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class OrderMgrMapperTest {
	
	@Autowired
	private IOrderMgrMapper mapper;
	
	/*
	//검색 구분자를 전달받아 현재 페이지의 주문 리스트 반환테스트
	@Test
	public void getOrderListTest() {
		
		OrderSearchVO search = new OrderSearchVO();
		
		int[] orderList = {3};
		
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setOrderProcess(orderList);
		
		List<OrderViewVO> orders = mapper.getOrderList(search);
		
		System.out.println("=======================");

		for(OrderViewVO order : orders) {
			System.out.println(order);
		}

		System.out.println("=======================");
		
	}
	*/
	
	/*
	//검색 구분자를 전달받아 현재 페이지의 주문 수 반환테스트
	@Test
	public void orderCountTest() {
		
		OrderSearchVO search = new OrderSearchVO();
		
		int[] orderList = {1,3};
		
		search.setCurrentPage(1);
		search.setMessagePerPage(10);
		search.setStartDate(Timestamp.valueOf("2021-05-01 00:00:00.0"));
		search.setEndDate(Timestamp.valueOf("2021-05-08 24:59:59.99"));
		search.setOrderProcess(orderList);
		
		int orderCount = mapper.orderCount(search);
		
		System.out.println("강의 수 : " + orderCount);
		
	}
	*/
	
	/*
	//주문번호를 받아 주문정보 반환테스트
	@Test
	public void getOrderInfoTest(){
		
		int orderNo = 2;
		
		OrderViewVO orderInfo = mapper.getOrderInfo(orderNo);
		
		System.out.println(orderInfo);
		
	}
	*/
	
	
	
	
	
	
}
