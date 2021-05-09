package kr.co.cookinglearn.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;

@Controller
public class QnaController {
	
	@Autowired
	private IQnaService service;
	
	@PostMapping("/")
	public String comment(QnaVO qna, RedirectAttributes ra) {
		service.insert(qna);
		ra.addFlashAttribute("msg", "modSuccess");
		return "redirect:/";
	}
	
}
	
