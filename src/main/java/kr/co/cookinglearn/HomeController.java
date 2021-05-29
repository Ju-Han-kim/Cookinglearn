package kr.co.cookinglearn;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.service.BoardService;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService boardService;
	
	@GetMapping("/")
	public String topClass(Model model) throws Exception {
		List<BoardVO> list = boardService.topClass();
		model.addAttribute("list", list);
		return "home";
	}
	
}
