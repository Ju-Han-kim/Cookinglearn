package kr.co.cookinglearn.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.board.domain.ReviewVO;
import kr.co.cookinglearn.board.service.BoardService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@Inject
	private BoardService reviewService;
	
	
	// 게시물 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	//카테고리 별 게시글 목록
	@RequestMapping(value="/kategorie-list", method=RequestMethod.GET)
	public String getKategorieList(Model model, String kategorie) throws Exception{
		List<BoardVO> kategorieList = service.kategorieList(kategorie);
		model.addAttribute("kategorie", kategorieList);
		return "/board/kategorie-list";
	}
	
	// 게시물 조회
	@RequestMapping(value="/viewDetail", method=RequestMethod.GET)
	public String getView(Model model, int viewDetail) throws Exception {
		BoardVO detail = service.detail(viewDetail);
		model.addAttribute("detail", detail);
	
		List<ReviewVO> reviewList = reviewService.reviewList(viewDetail);
		model.addAttribute("review", reviewList);
//		System.out.println(viewDetail);
//		System.out.println(reviewList);
		return "board/viewDetail";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String reviewWrite(HttpSession session, @RequestParam String reviewComment, @RequestParam String classCode) throws Exception {
		UserVO user = (UserVO) session.getAttribute("login");

		System.out.println(classCode);
		ReviewVO vo = new ReviewVO();
		
		vo.setUserNo(user.getUserNo());
		vo.setClassCode(Integer.parseInt(classCode));
		vo.setWriter(user.getNickname());
		vo.setReviewComment(reviewComment);

		service.write(vo);
		return "redirect:/board/list";
	}
}