package kr.co.cookinglearn.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.user.model.UserVO;
import kr.co.cookinglearn.user.repository.IUserMapper;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int checkId(String account) {
		return mapper.checkId(account);
	}

	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public void changeInfo(UserVO user) {

	}

	@Override
	public void register(UserVO user) {
		mapper.register(user);
	}

	@Override
	public UserVO selectOne(String account) {
		return mapper.selectOne(account);
	}

	@Override
	public void delete(String account) {
		// TODO Auto-generated method stub

	}

}
