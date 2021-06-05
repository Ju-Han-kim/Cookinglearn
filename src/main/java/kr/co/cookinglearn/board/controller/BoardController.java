package kr.co.cookinglearn.board.controller;

import java.util.ArrayList;
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
import kr.co.cookinglearn.board.paging.PagingVO;
import kr.co.cookinglearn.board.service.BoardService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	@Inject
	private BoardService reviewService;
	
	private String referer;
	
	// 오프라인 게시물 목록
	@RequestMapping(value="/offline", method=RequestMethod.GET)
	public String getOfflineClass(Model model) throws Exception{
		List<BoardVO> getOfflineClass = service.getOfflineClass();
		model.addAttribute("getOfflineClass", getOfflineClass);
		return "/board/offline";
	}

	// 오프라인 카테고리 별 클래스 목록
	@RequestMapping(value="/offline-kat", method=RequestMethod.GET)
	public String getOfflineKateClass(Model model, String kategorie) throws Exception{
		List<BoardVO> getOfflineKateClass = service.getOfflineKateClass(kategorie);
		model.addAttribute("kategorie", getOfflineKateClass);
		return "/board/offline-kat";
	}
	
	// 오프라인 게시물 상세 조회
	@RequestMapping(value="/offline-detail", method=RequestMethod.GET)
	public String getOfflineKateDetailView(Model model, int viewDetail, HttpServletRequest request) throws Exception {
		BoardVO detail = service.offlineClassDetail(viewDetail);
		model.addAttribute("detail", detail);
		
		List<ReviewVO> reviewList = reviewService.reviewList(viewDetail);
		model.addAttribute("review", reviewList);
		referer = request.getHeader("REFERER");
		return "board/offline-detail";
	}

	// 온라인 전체 게시물 목록 + 페이징
	@RequestMapping(value="/online-all", method=RequestMethod.GET)
	public String getList(Model model, PagingVO vo, 
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception{
		
		int total = service.countBoard();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "12";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "12";
		}
		
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("list", service.list(vo));
			
		return "/board/online-all";
	}
	
	// 온라인 카테고리 별 게시글 목록 + 페이징
	@RequestMapping(value="/online-kat", method=RequestMethod.GET)
	public String getKategorieList(Model model, String category,
			@RequestParam(value="nowPage", required=false)String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception{
		int total = service.onlineCateCountBoard(category);
		
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "12";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "12";
		}

		PagingVO vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BoardVO> categoryList = service.kategorieList(category, vo);
		
		model.addAttribute("paging", vo);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("kategorie", category);

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
	public String reviewInsert(HttpServletRequest request, HttpSession session, ReviewVO vo, @RequestParam String classCode) throws Exception {
		UserVO userVO = (UserVO) session.getAttribute("login");
		String referer = request.getHeader("REFERER");
		//user객체 있을경우 
		if(userVO != null) {
			Integer userNo = userVO.getUserNo();
			String nickname = userVO.getNickname();
			Integer no = Integer.parseInt(classCode);	
			
			vo.setUserNo(userNo);
			vo.setClassCode(no);
			vo.setWriter(nickname);
			
			service.reviewInsert(vo);
		}
			
		referer = referer.replace("http://localhost/", "");
	      
		return "redirect:/" + referer;
	}
	
	//댓글 삭제
	@RequestMapping(value="/reviewDelete", method=RequestMethod.POST)
	public String reviewDelete(@RequestParam int reviewNo) throws Exception {
			System.out.println("댓글 삭제");
			service.reviewDelete(reviewNo);
			
		return "redirect:/board/online-all";
	}
	
	
	//장바구니 세션 생성
	@RequestMapping(value = "/cart",  method=RequestMethod.POST)
	public String cart(HttpSession session, int classCode) throws Exception {
		List<BoardVO> classInfo = new ArrayList<BoardVO>();
		
		UserVO userVO = (UserVO) session.getAttribute("login");
		BoardVO vo = service.detail(classCode);
		
		if(vo == null) {
			vo = service.offlineClassDetail(classCode);
		}

		if(userVO != null) {

			List<BoardVO> tempList = (List<BoardVO>)session.getAttribute("classInfo");
			
			//객체가 비어있지 않으면 삭제 후 다시 넘김
			if (tempList != null) {
				classInfo.addAll(tempList);
			} 
			
			classInfo.add(vo);

			session.setAttribute("classInfo", classInfo);

			System.out.println(classInfo.toString());
		}
		
		return "redirect:/order/cart";
	}
	
}

