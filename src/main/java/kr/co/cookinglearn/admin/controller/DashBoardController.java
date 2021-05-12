package kr.co.cookinglearn.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashBoardController {
	
	
	@GetMapping("/")
	public String dashBoardView() {
		
		
		return "admin/dashBoard/dashBoard";
	}
	
}
