package kr.co.cookinglearn.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.cookinglearn.board.dao.BoardDAO;
import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;

@Service
public class BoardServiceImpl implements BoardService {

	 @Inject
	 private BoardDAO dao;
	 
	 @Override
	 public List<BoardVO> list() throws Exception {
		 return dao.list();	
	 }

	 @Override
	public List<BoardVO> kategorieList(String no) throws Exception {
		return dao.kategorieList(no);
	}

	@Override
	public BoardVO detail(int no) throws Exception {
		return dao.detail(no);
	}


	@Override
	public List<ReviewVO> reviewList(int no) throws Exception {
		return dao.reviewList(no);
	}

	@Override
	public void write(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
	
		dao.write(vo);
	}
	
	//TopClass
	@Override
	public List<BoardVO> topClass() throws Exception {
		return dao.topClass();
	}
	
	
}
