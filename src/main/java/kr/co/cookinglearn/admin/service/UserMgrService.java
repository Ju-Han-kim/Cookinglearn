package kr.co.cookinglearn.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cookinglearn.admin.common.page.SearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.model.process.OrderViewVO;
import kr.co.cookinglearn.admin.model.process.ReviewClassVO;
import kr.co.cookinglearn.admin.repository.IOrderMgrMapper;
import kr.co.cookinglearn.admin.repository.IPointMgrMapper;
import kr.co.cookinglearn.admin.repository.IQnaMgrMapper;
import kr.co.cookinglearn.admin.repository.IReviewMgrMapper;
import kr.co.cookinglearn.admin.repository.IUserMgrMapper;
import kr.co.cookinglearn.admin.service.interfaces.IUserMgrService;

@Service
public class UserMgrService implements IUserMgrService {

	@Autowired
	private IUserMgrMapper mapper;

	@Autowired
	private IOrderMgrMapper orderMapper;
	
	@Autowired
	private IReviewMgrMapper reviewMapper;

	@Autowired
	private IQnaMgrMapper qnaMapper;
	
	@Autowired
	private IPointMgrMapper poingMapper;
	
	@Override
	public List<UserVO> getUserList(SearchVO search) {
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
	
	@Override
	public int userCount(SearchVO search) {
		return mapper.userCount(search);
	}
	
	@Override
	public List<OrderViewVO> getOrderListByUser(int userNo) {
		return orderMapper.getOrderListByUser(userNo);
	}
	
	@Override
	public List<QnaVO> getQnaListByUser(int userNo) {
		return qnaMapper.getQnaListByUser(userNo);
	}
	
	@Override
	public List<ReviewClassVO> getUserReviewWithClass(int userNo) {
		return reviewMapper.getUserReviewWithClass(userNo);
	}
	
	@Override
	public int getUserPoint(int userNo) {
		return poingMapper.getUserPoint(userNo);
	}
	
}
