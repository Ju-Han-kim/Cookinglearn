package kr.co.cookinglearn.order.repository;

import kr.co.cookinglearn.order.model.OrderVO;

public interface IOrderMapper {

	
	//���� �Ϸ� ���� ��� ���
		void insert(OrderVO OrderList);
		
		//���� ���� ��ȸ ���
		OrderVO getOrderList(int orderNo);
		
		//���� ��� ��� (�ʿ��Ѱ�?)
}
