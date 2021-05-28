package kr.co.cookinglearn.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.cookinglearn.board.dao.BoardDAO;
import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;
import kr.co.cookinglearn.board.paging.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {

	 @Inject
	 private BoardDAO dao;
	 
	 @Override
	 public List<BoardVO> list(PagingVO vo) throws Exception {
		 return dao.list(vo);	
	 }

	 @Override
	 public List<BoardVO> getOfflineClass() throws Exception {
		 // TODO Auto-generated method stub
		 return dao.getOfflineClass();
	 }

	@Override
	 public List<BoardVO> getOfflineKateClass(String kategorie) throws Exception {
		 // TODO Auto-generated method stub
		 return dao.getOfflineKateClass(kategorie);
	 }

	@Override
	public BoardVO offlineDetail(int viewDetail) {
		// TODO Auto-generated method stub
		return dao.offlineKategorieList(viewDetail);
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
	public void reviewInsert(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
	
		dao.reviewInsert(vo);
	}

	@Override
	public void reviewDelete(int reviewNo) {
		// TODO Auto-generated method stub
		dao.reviewDelete(reviewNo);
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return dao.countBoard();
	}
	
}
