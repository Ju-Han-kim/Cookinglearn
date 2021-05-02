package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.UserSearchVO;
import kr.co.cookinglearn.admin.service.IUserMgrService;

@Controller
@RequestMapping("/admin/user")
public class UserMgrController {

	@Autowired
	private IUserMgrService service;
	
	//고객관리 페이지 mapping
	@GetMapping("/")
	public String userMgr(UserSearchVO search, Model model) {
		
		model.addAttribute("userList",service.getUserList(search));
		return "admin/userMgr/usermanager";
	}
	
}
