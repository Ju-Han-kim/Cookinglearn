package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.service.interfaces.IDashBoardService;

@Controller
@RequestMapping("/admin")
public class DashBoardController {
	
	@Autowired
	private IDashBoardService service;
	
	//현황관리 페이지 mapping
	@GetMapping("/")
	public String dashBoardView(Model model) {
		
		model.addAttribute("menu", "DashBoard");
		
		model.addAttribute("todayWork", service.todayWork());
		model.addAttribute("dailySales", service.dailySales());
		model.addAttribute("qnaList", service.getQnaList());
		return "admin/dashBoard/dashBoard";
	}
	
}
