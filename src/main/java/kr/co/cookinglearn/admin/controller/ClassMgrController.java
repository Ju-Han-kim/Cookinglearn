package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.service.interfaces.IClassMgrService;

@Controller
@RequestMapping("/admin/class")
public class ClassMgrController {

	@Autowired
	private IClassMgrService service;
	
	//온라인 강의관리 페이지 Mapping
	@GetMapping("/on")
	public String onlineClassMgr(ClassSearchVO search, Model model) {
		
		model.addAttribute("menu", "Class");
		
		search.setClassType(true);
		model.addAttribute("pageMgr", new PageMgr(search, service.classCount(search)));
		model.addAttribute("classList",service.getClassList(search));
		return "admin/classMgr/onlineClassManager";
	}
	
	//오프라인 강의관리 페이지-예정강의 Mapping
	@GetMapping("/off1")
	public String offlineClassMgr1(ClassSearchVO search, Model model) {
		
		model.addAttribute("menu", "Class");
		search.setMinDate();
		
		search.setClassType(false);
		model.addAttribute("offOption", "1");
		model.addAttribute("pageMgr", new PageMgr(search, service.classCount(search)));
		model.addAttribute("search", search);
		model.addAttribute("classList",service.getClassList(search));
		return "admin/classMgr/offlineClassManager";
		
	}
	
	//오프라인 강의관리 페이지-완료대기 Mapping
	@GetMapping("/off2")
	public String offlineClassMgr2(ClassSearchVO search, Model model) {
		
		model.addAttribute("menu", "Class");
		search.setMaxDate();
		
		search.setClassType(false);
		model.addAttribute("offOption", "2");
		model.addAttribute("pageMgr", new PageMgr(search, service.classCountByOrder(search)));
		model.addAttribute("search", search);
		model.addAttribute("classList",service.getClassListByOrder(search));
		return "admin/classMgr/offlineClassManager";
		
	}
	
	//오프라인 강의관리 페이지-완료강의 Mapping
	@GetMapping("/off3")
	public String offlineClassMgr3(ClassSearchVO search, Model model) {
		
		model.addAttribute("menu", "Class");
		search.setMaxDate();
		
		search.setComplete(false);
		search.setClassType(false);
		model.addAttribute("offOption", "3");
		model.addAttribute("pageMgr", new PageMgr(search, service.classCount(search)));
		model.addAttribute("search", search);
		model.addAttribute("classList",service.getClassList(search));
		return "admin/classMgr/offlineClassManager";
		
	}
		
	
}
