package kr.co.cookinglearn.order.service;

import kr.co.cookinglearn.order.model.OrderVO;

public interface IOrderService {
	
	//���� �Ϸ� ���� ��� ���
	void insert(OrderVO OrderList);
	
	//���� ���� ��ȸ ���
	OrderVO getOrderList(int orderNo);
	
	//���� ��� ��� (�ʿ��Ѱ�?)
	

}
