package kr.co.cookinglearn.user.service;

import java.util.List;

import kr.co.cookinglearn.user.model.UserVO;

public interface IUserService {
	
	//���̵� �ߺ� üũ ���
		int checkId(String account);
		
		//ȸ�� ���� ��ü ��ȸ ���
		List<UserVO> selectAll();
		
		//ȸ�� ���� ����
	    void changeInfo(UserVO user);
		
		//ȸ�� ���� ���
		void register(UserVO user);
		
		//ȸ�� ���� ��ȸ ���
		UserVO selectOne(String account);
		
		//ȸ�� Ż�� ���
		void delete(String account);
	
}
