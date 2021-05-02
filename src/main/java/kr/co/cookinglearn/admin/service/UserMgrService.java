package kr.co.cookinglearn.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.UserSearchVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;

@Service
public class UserMgrService implements IUserMgrService {

	@Autowired
	private IUserMgrMapper mapper;
	
	@Override
	public List<UserVO> getUserList(UserSearchVO search) {
		return mapper.getUserList(search);
	}

	@Override
	public UserVO getUserInfo(int userNo) {
		return mapper.getUserInfo(userNo);
	}

	@Override
	public void setAdmin(UserVO user) {
		mapper.setAdmin(user);
	}

}
