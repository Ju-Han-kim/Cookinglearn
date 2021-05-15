package kr.co.cookinglearn.point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class PointController {
	
	@GetMapping("cart")
	public String cart() {
		return "order/cart";
	}
	
	
	
	
	
	
	
	
}
