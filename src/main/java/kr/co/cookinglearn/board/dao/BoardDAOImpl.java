package kr.co.cookinglearn.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace="kr.co.cookinglearn.board.mappers.board";
	
	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".list");
	}
	
	@Override
	public List<BoardVO> kategorieList(String kategorie) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace + ".kategorie", kategorie);
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
	public void write(ReviewVO vo) throws Exception {

		sql.insert(namespace + ".write", vo);
	}

}