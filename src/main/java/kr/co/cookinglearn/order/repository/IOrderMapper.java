package kr.co.cookinglearn.order.repository;

import kr.co.cookinglearn.order.model.OrderVO;

public interface IOrderMapper {

	void insert(OrderVO OrderList);

	OrderVO getOrderList(int orderNo);

}
