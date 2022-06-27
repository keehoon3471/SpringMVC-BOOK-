package book.keehoon.web.spring;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOMybatis implements BoardDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDAOMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public void insert(BoardVO boardVO) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insert", boardVO);
	}

	@Override
	public BoardVO select(int seq) {
		// TODO Auto-generated method stub
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", seq);
		return vo;
	}
	
	

	@Override
	public List<BoardVO> list(String keyword) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("search", keyword);
	}

//	@Override
//	public List<BoardVO> searchBookname(String keyword) {
//		// TODO Auto-generated method stub
//		return sqlSessionTemplate.selectList("searchBookname", keyword);
//	}

//	@Override
//	public List<BoardVO> searchAuthor(String keyword) {
//		// TODO Auto-generated method stub
//		return sqlSessionTemplate.selectList("searchAuthor", keyword);
//	}
	
	
	
	

}
