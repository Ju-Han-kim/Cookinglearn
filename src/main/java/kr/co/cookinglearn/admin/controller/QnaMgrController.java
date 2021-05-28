package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.model.QnaVO;
import kr.co.cookinglearn.admin.service.interfaces.IQnaMgrService;

@RestController
@RequestMapping("/admin/qna")
public class QnaMgrController {
	
	@Autowired
	private IQnaMgrService service;
	
	//문의관리 화면 mapping
	@GetMapping("/")
	public ModelAndView qnaMgr(QnaSearchVO search, Model model) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("menu", "Qna");
		mav.addObject("pageMgr", new PageMgr(search, service.qnaCount(search)));
		mav.addObject("search", search);
		mav.addObject("qnaList", service.getQnaList(search));
		
		mav.setViewName("admin/qnaMgr/qnaManager");
		
		return mav;
	}
	
	
	//문의관리 답변등록 mapping
	@PostMapping("/updateAnswer")
	public String updateAnswer(@RequestBody QnaVO qna) {

		return service.setAnswer(qna);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
