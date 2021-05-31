package kr.co.cookinglearn.point.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.model.PointVO;
import kr.co.cookinglearn.point.service.IPointService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("user/mypoint")
public class PointController {
	
	@Autowired 
	private IPointService service;
	
	
	
	
	
	
	
	
	
}
