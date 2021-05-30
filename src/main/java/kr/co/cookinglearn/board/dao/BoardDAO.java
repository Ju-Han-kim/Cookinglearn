package kr.co.cookinglearn.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;
import kr.co.cookinglearn.board.paging.PagingVO;

public interface BoardDAO {

	// 클래스 전체 목록
//	public List<BoardVO> list() throws Exception;
	
	// 클래스 전체 목록 + 페이지
	public List<BoardVO> list(PagingVO vo) throws Exception;
	
	// 온라인 클래스 카테고리 별 목록
	public List<BoardVO> kategorieList(Map map) throws Exception;
	
	//온라인 클래스 상세보기 페이지
	public BoardVO detail(int no) throws Exception;
	
	//리뷰 리스트
	public List<ReviewVO> reviewList(int no) throws Exception;
	
	//리뷰 작성
	void reviewInsert(ReviewVO vo) throws Exception;
	
	// 오프라인 클래스 목록
	public List<BoardVO> getOfflineClass() throws Exception;
	
	// 오프라인 카테고리 별 클래스 목록(1)
	List<BoardVO> getOfflineKateClass(String kategorie) throws Exception;
	
	// 오프라인 카테고리 별 클래스 목록(2) 
	public BoardVO offlineKategorieList(int viewDetail);

	//온라인 클래스 상세보기 페이지
	public BoardVO offlineClassDetail(int no) throws Exception;
	
	// 댓글 삭제
	public void reviewDelete(int reviewNo);
	
	// 온라인 게시판 개수 가지고 오기.
	public int countBoard();
	
	public int onlineCateCountBoard(String category);
	
	public List<BoardVO> topClass() throws Exception;
}
