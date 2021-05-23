package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.common.page.SearchVO;
import kr.co.cookinglearn.admin.model.UserVO;
import kr.co.cookinglearn.admin.service.interfaces.IUserMgrService;

@Controller
@RequestMapping("/admin/user")
public class UserMgrController {

	@Autowired
	private IUserMgrService service;
	
	//고객관리 페이지 mapping
	@GetMapping("/")
	public String userMgr(SearchVO search, Model model) {
		model.addAttribute("menu", "User");
		
		model.addAttribute("pageMgr", new PageMgr(search, service.userCount(search)));
		model.addAttribute("userList",service.getUserList(search));
		return "admin/userMgr/userManager";
	}
	
	//고객 상세정보 화면 mapping
	@GetMapping("/{userNo}")
	public String userView(@PathVariable int userNo, Model model, SearchVO search) {
		
		model.addAttribute("menu", "User");
		
		String userPath = new PageMgr(search, service.userCount(search)).mkUserUri(search.getCurrentPage());
		
		model.addAttribute("userPath", userPath);
		model.addAttribute("userInfo", service.getUserInfo(userNo));
		model.addAttribute("orderInfo", service.getOrderListByUser(userNo));
		model.addAttribute("reviewInfo", service.getUserReviewWithClass(userNo));
		model.addAttribute("qnaInfo", service.getQnaListByUser(userNo));
		model.addAttribute("userPoint", service.getUserPoint(userNo));
		
		return "admin/userMgr/userInfo";
	}
	
	//관리자권한 설정
	@PostMapping("/setadmin")
	@ResponseBody
	public void setAdminLevel(UserVO user) {
		service.setAdmin(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
