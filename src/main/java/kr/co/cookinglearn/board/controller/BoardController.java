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
	
	
	// 전체 게시물 목록
	@RequestMapping(value="/online-all", method=RequestMethod.GET)
	public String getList(Model model) throws Exception{
		List<BoardVO> list = service.list();
		model.addAttribute("list", list);
		return "/board/online-all";
	}
	
	//카테고리 별 게시글 목록
	@RequestMapping(value="/online-kat", method=RequestMethod.GET)
	public String getKategorieList(Model model, String kategorie) throws Exception{
		List<BoardVO> kategorieList = service.kategorieList(kategorie);
		model.addAttribute("kategorie", kategorieList);
		return "/board/online-kat";
	}
	
	// 게시물 상세 조회
	@RequestMapping(value="/viewDetail", method=RequestMethod.GET)
	public String getView(Model model, int viewDetail) throws Exception {
		BoardVO detail = service.detail(viewDetail);
		model.addAttribute("detail", detail);
	
		List<ReviewVO> reviewList = reviewService.reviewList(viewDetail);
		model.addAttribute("review", reviewList);
		return "board/viewDetail";
	}

	//댓글 작성
	@RequestMapping(value="/ReviewInsert", method=RequestMethod.POST)
	public String reviewWrite(HttpSession session, ReviewVO vo, @RequestParam String classCode) throws Exception {
		UserVO userVO = (UserVO) session.getAttribute("login");

		//user객체 있을경우 
		if(userVO != null) {
			Integer userNo = userVO.getUserNo();
			String nickname = userVO.getNickname();
			Integer no = Integer.parseInt(classCode);	
			
			vo.setUserNo(userNo);
			vo.setClassCode(no);
			vo.setWriter(nickname);
			
			service.write(vo);
		}
			
		return "redirect:/board/list";
	}
	
	//장바구니
	@RequestMapping(value = "/cart",  method=RequestMethod.POST)
	public String Cart(HttpSession session, int classCode) throws Exception {
		UserVO userVO = (UserVO) session.getAttribute("login");
		BoardVO vo = service.detail(classCode);
		
		if(userVO != null) {
			System.out.println(vo.getClassCode());
			//classCode만 넘김.
//			session.setAttribute("classCode", vo.getClassCode());
			
			//객체 넘김
			session.setAttribute("classInfo", vo);
		}
		return "redirect:/order/cart";
	}
}

// 수강 신청 시 : session.setAttribute("ReviewVO", vo);