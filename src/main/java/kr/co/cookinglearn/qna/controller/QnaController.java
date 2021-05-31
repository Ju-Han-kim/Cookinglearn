package kr.co.cookinglearn.qna.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
public class QnaController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private IQnaService service;
	
	//QNA 폼 처리
	@PostMapping("/")
	public String comment(QnaVO qna, RedirectAttributes ra, HttpSession session) {
		
		UserVO user = (UserVO) session.getAttribute("login");
				
		if (user != null) {
			service.insert(qna, user);
			ra.addFlashAttribute("msg", "modSuccess");
		}
		else {
			ra.addFlashAttribute("msg", "modFail");
		}
		return "redirect:/";
	}
	
}
	
