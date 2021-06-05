package kr.co.cookinglearn.order.repository;

import java.util.ArrayList;
import java.util.List;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.order.model.OrderVO;

public interface IOrderMapper {

	ArrayList<BoardVO> cartList(int code);

	void insert(OrderVO OrderList);

	OrderVO getOrderList(int orderNo);


}
