package kr.co.cookinglearn.order.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/cart")
	public String cart(HttpSession session) { 
		
		/*
		//세션이 존재하면 페이지이동 (아직 상품관련내용이 없어서 vo를추가 안함 , 
		  세션으로 강의 코드 받아오면 상품vo에서 정보 빼오기
		if(session.getAttribute("classCode") != null) {
			
			return "order/cart";
		}
		return "order/emptycart";
		*/
		
		//일단 세션이 없으니까
		return "order/cart";
	}
	
	@GetMapping("/complete")
	public String complete() {
		return "order/complete";
	}
	
	
	
	
	
	
	
	
}
