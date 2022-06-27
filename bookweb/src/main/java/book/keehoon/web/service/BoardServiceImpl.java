package book.keehoon.web.service;

import java.util.List;
import org.springframework.stereotype.Service;

import book.keehoon.web.spring.BoardDAO;
import book.keehoon.web.spring.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;

	public BoardDAO getBoardDAO() {
		return boardDAO;
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	@Override
	public void write(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.insert(boardVO);
	}

	@Override
	public BoardVO read(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.select(seq);
	}
	
	@Override
	public List<BoardVO> list(String keyword) {
		// TODO Auto-generated method stub
		return boardDAO.list(keyword);
	}

//	@Override
//	public List<BoardVO> searchB(String keyword) {
//		// TODO Auto-generated method stub
//		return boardDAO.searchBookname(keyword);
//	}

//	@Override
//	public List<BoardVO> searchA(String keyword) {
//		// TODO Auto-generated method stub
//		return boardDAO.searchAuthor(keyword);
//	}
	
	
}
