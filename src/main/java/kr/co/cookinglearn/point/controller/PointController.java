package kr.co.cookinglearn.point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/point")
public class PointController {
	
	@GetMapping("point")
	public String cart() {
		return "point";
	}
	
	
	
	
	
	
	
	
}
