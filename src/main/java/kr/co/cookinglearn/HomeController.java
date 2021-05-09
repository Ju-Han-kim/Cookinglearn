package kr.co.cookinglearn;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping("/")
	public String home() {
		logger.info("메인 페이지 들어감");

		return "home";
	}
	
}
