package kr.co.cookinglearn.board.service;

import java.util.List;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;
import kr.co.cookinglearn.board.paging.PagingVO;

public interface BoardService {

	// 온라인 전체 페이지
	public List<BoardVO> list(PagingVO vo) throws Exception;

	//온라인 카테고리 페이지
	public List<BoardVO> kategorieList(String category, PagingVO vo) throws Exception;

	//오프라인 페이지
	public List<BoardVO> getOfflineClass() throws Exception;
	
	//오프라인 카테고리 페이지
	List<BoardVO> getOfflineKateClass(String kategorie) throws Exception;
	
	//상세보기 페이지
	public BoardVO detail(int no) throws Exception;

	//오프라인 상세보기 페이지
	public BoardVO offlineClassDetail(int viewDetail) throws Exception;
	
	//댓글 상세보기
	public List<ReviewVO> reviewList(int no) throws Exception;
	
	//댓글 작성
	void reviewInsert(ReviewVO vo) throws Exception;

	//댓글 삭제
	public void reviewDelete(int reviewNo);
	
	// 온라인 게시물 총 갯수
	public int countBoard();
	
	public int onlineCateCountBoard(String category);

	//topClass
	public List<BoardVO> topClass() throws Exception;
	
}
