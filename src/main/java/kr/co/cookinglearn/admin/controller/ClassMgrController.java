package kr.co.cookinglearn.admin.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;

import kr.co.cookinglearn.admin.common.page.ClassSearchVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.model.ClassVO;
import kr.co.cookinglearn.admin.model.OrderVO;
import kr.co.cookinglearn.admin.model.process.ClassStudentsVO;
import kr.co.cookinglearn.admin.service.interfaces.IClassMgrService;

@Controller
@RequestMapping("/admin/class")
public class ClassMgrController {

	@Autowired
	private IClassMgrService service;
	
	private final String imgRootPath = "C:/class/img/";
	
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
		
		model.addAttribute("menu", "Class");
		
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			
			List<ClassStudentsVO> students = service.getStudents(classCode);
			model.addAttribute("students", students);
			return "admin/classMgr/onlineClassContent";
		} else {
			ra.addFlashAttribute("msg", "noClass");
			return "redirect:/admin/class/on";
		}
	}
	
	//오프라인 강의 상세현황 페이지 Mapping
	@GetMapping("/off/{classCode}")
	public String offlineClassContent(@PathVariable int classCode, Model model, RedirectAttributes ra, @RequestParam(name="offOption", defaultValue="1" ) int offOption) {
		
		model.addAttribute("menu", "Class");
		
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(!classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			
			List<ClassStudentsVO> students = service.getStudents(classCode);
			model.addAttribute("students", students);
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
		model.addAttribute("pageMgr", new PageMgr(search, service.classCountByOrder(search)));
		model.addAttribute("search", search);
		model.addAttribute("classList",service.getClassListByOrder(search));
		return "admin/classMgr/offlineClassManager";
		
	}
	
	//강의 번호를 받아 강의 삭제
	@GetMapping("/delete")
	public String classDelete(ClassVO classInfo, RedirectAttributes ra, @RequestParam(name="offOption", defaultValue="1" ) int offOption) {
		
		String path = classInfo.isClassType() ? "redirect:/admin/class/on" : "redirect:/admin/class/off"+offOption;
		
		List<String> contentImgList = service.getContentImg(classInfo.getClassCode());
		
		if(contentImgList != null) {
			for(String contentImg : contentImgList) {
				if(contentImg.length() >= 10) {
					try {
						File targetFile = new File(imgRootPath + contentImg.substring(10));	
						FileUtils.deleteQuietly(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		if(service.classDelete(classInfo.getClassCode())) {
			ra.addFlashAttribute("msg", "deleteSuccess");
		} else {
			ra.addFlashAttribute("msg", "deleteFail");
		}
		
		return path;
	}

	//온라인 강의등록 화면 Mapping
	@GetMapping("/regon")
	public String regonClass(Model model) {
		
		model.addAttribute("menu", "Class");
		
		model.addAttribute("classType", true);
		return "admin/classMgr/onlineClassReg";
	}
	
	//오프라인 강의등록 화면 Mapping
	@GetMapping("/regoff")
	public String regoffClass(Model model) {
		
		model.addAttribute("menu", "Class");
		
		model.addAttribute("classType", false);
		return "admin/classMgr/offlineClassReg";
	}
	
	//강의등록 이미지 파일저장
	@PostMapping(value="/regimg", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadImgFile(@RequestParam("file") MultipartFile multipartFile, String part, String classType)  {
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot = imgRootPath + classType + part;
		String originalFileName = multipartFile.getOriginalFilename();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = classType + "_" + UUID.randomUUID().toString().substring(0,6) + extension;
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			jsonObject.addProperty("url", "/classImg/"+classType+part+savedFileName);
			jsonObject.addProperty("responseCode", "success");
			
		} catch (Exception e) {
			FileUtils.deleteQuietly(targetFile);
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
	//등록된 이미지 삭제
	@PostMapping("/delimg")
	@ResponseBody
	public void deleteImgFile(String filePath) {
		
		if(filePath.length() >= 10) {
			File targetFile = new File(imgRootPath + filePath.substring(10));	
			
			try {
				FileUtils.deleteQuietly(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//강의등록 실행
	@PostMapping("/regClass")
	public String registerClass(ClassVO classInfo, Model model, RedirectAttributes ra) {
		
		service.regClass(classInfo);
		
		String classPath = classInfo.isClassType()?"on":"off1";
		
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/admin/class/" + classPath;
	}
	
	//온라인강의 수정화면 Mapping
	@GetMapping("/modon/{classCode}")
	public String modonClass(@PathVariable int classCode, Model model, RedirectAttributes ra) {	
		
		model.addAttribute("menu", "Class");
		
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			return "admin/classMgr/onlineClassMod";
		} else {
			ra.addFlashAttribute("msg", "noClass");
			return "redirect:/admin/class/on";
		}
	}

	//오프라인강의 수정화면 Mapping
	@GetMapping("/modoff/{classCode}")
	public String modoffClass(@PathVariable int classCode, Model model, RedirectAttributes ra) {	
		
		model.addAttribute("menu", "Class");
		
		ClassVO classInfo = service.getClassInfo(classCode);
		
		if(!classInfo.isClassType()) {
			model.addAttribute("classInfo", classInfo);
			return "admin/classMgr/offlineClassMod";
		} else {
			ra.addFlashAttribute("msg", "noClass");
			return "redirect:/admin/class/off1";
		}
	}
	
	//강의수정 실행
	@PostMapping("/modClass")
	public String modifyClass(ClassVO classInfo, RedirectAttributes ra) {
		
		service.modClass(classInfo);
		
		ra.addFlashAttribute("msg", "modSuccess");
		
		String classType = classInfo.isClassType()?"on":"off";
		return "redirect:/admin/class/"+classType+"/"+classInfo.getClassCode()+"?currentPage=1";
	}
	
	
	//강의 수강완료 상태전환
	@PostMapping("/orderprocess")
	@ResponseBody
	public void setOrderProcess(OrderVO order) {
		
		service.setProcess(order);
		
	}
	
	
	
	
	
}
