package book.keehoon.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import book.keehoon.web.service.BoardService;
import book.keehoon.web.spring.BoardVO;

@Controller
public class BoardController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
//	@RequestMapping(value="/board/list")
//	public String list(Model model) {
//		model.addAttribute("boardList", boardService.list());
//		if(model.containsAttribute("keyword") == true) {
//			model.addAttribute("boardList", boardService.list());
//		}
//		return "/board/list";
//	}
	
	@RequestMapping(value="/board/list")
	public String list(HttpServletRequest request, Model model) {
		/* 추가 */
		
		String keyword = request.getParameter("keyword");
		//System.out.println(keyword);
		model.addAttribute("keyword", keyword);
		if(keyword != null) {
			model.addAttribute("boardList", boardService.list(keyword));
			return "/board/list";
		} else {
			model.addAttribute("boardList", boardService.list());
			return "/board/list";
		}
	}
	
	@RequestMapping(value="/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		model.addAttribute("boardVO", boardService.read(seq));
		return "/board/read";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "/board/write";
	}
	
//	@RequestMapping(value="/board/write", method=RequestMethod.POST)
//	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "/board/write";
//		}
//		boardService.write(boardVO);
//		return "redirect:/board/list";
//	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) throws IOException {
		if(bindingResult.hasErrors()) {
			return "/board/write";
		}
		String image = null;
		MultipartFile uploadFile = boardVO.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			
			UUID uuid = UUID.randomUUID();
			image = uuid+"."+ext;
			uploadFile.transferTo(new File("C:\\javastudy\\stsbundle\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\bookweb\\resources\\images\\" + image));
			//uploadFile.transferTo(new File("C:\\javastudy\\stsbundle\\bookweb\\src\\main\\webapp\\resources\\images\\" + image));
		}
		boardVO.setImage(image);
		boardService.write(boardVO);
		return "redirect:/board/list";
	}
	
//	@RequestMapping(value="board/list/{keyword}", method=RequestMethod.GET)
//	public String show(Model model) {
//		model.addAttribute("keyword", boardService.show());
//		return "/board/list";
//	}
}
