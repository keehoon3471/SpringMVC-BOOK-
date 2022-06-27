package book.keehoon.web.spring;

import java.util.List;

public interface BoardDAO {
	public abstract List<BoardVO> list();
		
	public abstract void insert(BoardVO boardVO);
	
	public abstract BoardVO select(int seq);
	
	public abstract List<BoardVO> list(String keyword);
	
//public abstract List<BoardVO> searchBookname(String keyword);
	
//public abstract List<BoardVO> searchAuthor(String keyword);
}
