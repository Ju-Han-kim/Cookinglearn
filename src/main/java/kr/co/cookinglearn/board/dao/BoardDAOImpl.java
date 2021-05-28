package kr.co.cookinglearn.board.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list", vo);
	}
	
	@Override
	public List<BoardVO> getOfflineClass() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".selectOfflineAllClass");
	}
	
	@Override
	public List<BoardVO> getOfflineKateClass(String kategorie) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".selectOfflineKateClass", kategorie);
	}

	@Override
	public List<BoardVO> kategorieList(String kategorie) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".kategorie", kategorie);
	}

	@Override
	public BoardVO offlineKategorieList(int viewDetail) {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".offlineDetail", viewDetail);
	}
	
	@Override
	public BoardVO detail(int no) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("DAO : ");
		return sql.selectOne(namespace + ".detail", no);
	}

	@Override
	public List<ReviewVO> reviewList(int no) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".reviewList", no);
	}

	@Override
	public void reviewInsert(ReviewVO vo) throws Exception {

		sql.insert(namespace + ".reviewInsert", vo);
	}

	@Override
	public void reviewDelete(int reviewNo) {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".reviewDelete", reviewNo);
		
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".getOnelineClassCount");
	}
}