package kr.co.cookinglearn.board.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;
import kr.co.cookinglearn.board.paging.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace="kr.co.cookinglearn.board.mappers.board";
	
	@Override
	public List<BoardVO> list(PagingVO vo) throws Exception {
		return sql.selectList(namespace + ".list", vo);
	}
	
	@Override
	public List<BoardVO> getOfflineClass() throws Exception {
		return sql.selectList(namespace + ".selectOfflineAllClass");
	}
	
	@Override
	public List<BoardVO> getOfflineKateClass(String kategorie) throws Exception {
		return sql.selectList(namespace + ".selectOfflineKateClass", kategorie);
	}

	@Override
	public List<BoardVO> kategorieList(Map map) throws Exception {
		return sql.selectList(namespace + ".category", map);
	}

	@Override
	public BoardVO offlineKategorieList(int viewDetail) {
		return sql.selectOne(namespace + ".offlineDetail", viewDetail);
	}
	
	@Override
	public BoardVO detail(int no) throws Exception {
//		System.out.println("DAO : ");
		return sql.selectOne(namespace + ".detail", no);
	}

	@Override
	public List<ReviewVO> reviewList(int no) throws Exception {
		return sql.selectList(namespace + ".reviewList", no);
	}

	@Override
	public void reviewInsert(ReviewVO vo) throws Exception {

		sql.insert(namespace + ".reviewInsert", vo);
	}

	@Override
	public void reviewDelete(int reviewNo) {
		sql.delete(namespace + ".reviewDelete", reviewNo);
		
	}

	@Override
	public int countBoard() {
		return sql.selectOne(namespace + ".getOnelineClassCount");
	}

	@Override
	public int onlineCateCountBoard(String classCategory) {
		return sql.selectOne(namespace + ".getOnelineClassCateCount", classCategory);
	}

	@Override
	public List<BoardVO> topClass() throws Exception {
		return sql.selectList(namespace + ".topClass");
	}

	@Override
	public BoardVO offlineClassDetail(int no) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".offlineDetail", no);
	}

	
	
}
