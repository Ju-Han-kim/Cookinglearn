package kr.co.cookinglearn.repository;

import kr.co.cookinglearn.model.OrderVO;

public interface IOrderMapper {

	
	//���� �Ϸ� ���� ��� ���
		void insert(OrderVO OrderList);
		
		//���� ���� ��ȸ ���
		OrderVO getOrderList(int orderNo);
		
		//���� ��� ��� (�ʿ��Ѱ�?)
}
