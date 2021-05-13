package kr.co.cookinglearn.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.qna.model.QnaVO;
import kr.co.cookinglearn.qna.sevice.IQnaService;
import kr.co.cookinglearn.user.controller.UserController;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
public class QnaController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IQnaService service;
	
	@PostMapping("/")
	public String comment(QnaVO qna, RedirectAttributes ra, HttpServletRequest request, HttpSession session) {
		
		session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("login");
		
		System.out.println(qna.getQnaContent());
		
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
	
