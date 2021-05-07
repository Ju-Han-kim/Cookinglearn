package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.DateVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.service.IClassMgrService;

@Controller
@RequestMapping("/admin/class")
public class ClassMgrController {

	@Autowired
	private IClassMgrService service;
	
	//온라인 강의관리 페이지 Mapping
	@GetMapping("/on")
	public String onlineClassMgr(ClassSearchVO search, DateVO seDate, Model model) {
		
		model.addAttribute("menu", "Class");
		
		search.setClassType(true);
		model.addAttribute("pageMgr", new PageMgr(search, service.classCount(search, seDate)));
		model.addAttribute("classList",service.getClassList(search, seDate));
		return "admin/classMgr/onlineClassManager";
	}
	
	
}
