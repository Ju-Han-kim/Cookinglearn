package kr.co.cookinglearn.board.dao;

import java.util.List;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;

public interface BoardDAO {

	public List<BoardVO> list() throws Exception;
	public List<BoardVO> kategorieList(String no) throws Exception;
	public BoardVO detail(int no) throws Exception;
	public List<ReviewVO> reviewList(int no) throws Exception;
}
