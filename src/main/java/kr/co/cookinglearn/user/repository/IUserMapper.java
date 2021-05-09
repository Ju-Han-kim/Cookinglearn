package kr.co.cookinglearn.user.repository;

import java.util.List;

import kr.co.cookinglearn.user.model.UserVO;

public interface IUserMapper {
	
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
