package kr.co.cookinglearn.board.service;

import java.util.List;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;

public interface BoardService {

	//전체 페이지
	public List<BoardVO> list() throws Exception;
	
	//카테고리 페이지
	public List<BoardVO> kategorieList(String no) throws Exception;
	
	
	//상세보기 페이지
	public BoardVO detail(int no) throws Exception;
	
	//댓글 상세보기
	public List<ReviewVO> reviewList(int no) throws Exception;
	
}
