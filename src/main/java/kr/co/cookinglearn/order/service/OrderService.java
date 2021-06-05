package kr.co.cookinglearn.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.order.model.OrderVO;
import kr.co.cookinglearn.order.repository.IOrderMapper;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderMapper mapper;
	
	@Override
	public ArrayList<BoardVO> cartList(int code){
		return mapper.cartList(code);
	}
	
	@Override
	public void insert(OrderVO OrderList) {
		mapper.insert(OrderList);

	}

	@Override
	public OrderVO getOrderList(int orderNo) {
		return mapper.getOrderList(orderNo);
		
	}

}
