package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.model.ClassVO;
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
	
	//온라인 강의 상세현황 페이지 Mapping
	@GetMapping("/on/{classCode}")
	public String onlineClassContent(@PathVariable int classCode, Model model, RedirectAttributes ra) {
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			return "admin/classMgr/onlineClassContent";
		} else {
			ra.addFlashAttribute("msg", "noClass");
			return "redirect:/admin/class/on";
		}
	}
	
	//오프라인 강의 상세현황 페이지 Mapping
	@GetMapping("/off/{classCode}")
	public String offlineClassContent(@PathVariable int classCode, Model model, RedirectAttributes ra, int offOption) {
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(!classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			return "admin/classMgr/offlineClassContent";
		} else {
			ra.addFlashAttribute("msg", "noClass");
			return "redirect:/admin/class/off"+offOption;
		}
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
	
	//강의 번호를 받아 강의 삭제
	@GetMapping("/delete")
	public String classDelete(ClassVO classInfo, RedirectAttributes ra, @RequestParam(name="offOption", defaultValue="1" ) int offOption) {
		
		String path = classInfo.isClassType() ? "redirect:/admin/class/on" : "redirect:/admin/class/off"+offOption;
		
		if(service.classDelete(classInfo.getClassCode())) {
			ra.addFlashAttribute("msg", "deleteSuccess");
		} else {
			ra.addFlashAttribute("msg", "deleteFail");
		}
		
		return path;
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
