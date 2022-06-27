package book.keehoon.web.service;

import java.util.List;

import book.keehoon.web.spring.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> list();
		
	public abstract void write(BoardVO boardVO);
	
	public abstract BoardVO read(int seq);
	
	public abstract List<BoardVO> list(String keyword);
	
//	public abstract List<BoardVO> searchB(String keyword);
	
//	public abstract List<BoardVO> searchA(String keyword);
}
