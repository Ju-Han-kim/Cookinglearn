package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.common.page.QnaSearchVO;
import kr.co.cookinglearn.admin.service.interfaces.IQnaMgrService;

@Controller
@RequestMapping("/admin/qna")
public class QnaMgrController {
	
	@Autowired
	private IQnaMgrService service;
	
	//문의관리 화면 mapping
	@GetMapping("/")
	public String qnaMgr(QnaSearchVO search, Model model) {
		
		model.addAttribute("menu", "Qna");
		
		model.addAttribute("pageMgr", new PageMgr(search, service.qnaCount(search)));
		model.addAttribute("search", search);
		model.addAttribute("qnaList", service.getQnaList(search));
		
		return "admin/qnaMgr/qnaManager";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
