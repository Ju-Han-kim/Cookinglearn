package kr.co.cookinglearn.service;

import kr.co.cookinglearn.model.OrderVO;

public interface IOrderService {
	
	//���� �Ϸ� ���� ��� ���
	void insert(OrderVO OrderList);
	
	//���� ���� ��ȸ ���
	OrderVO getOrderList(int orderNo);
	
	//���� ��� ��� (�ʿ��Ѱ�?)
	

}
