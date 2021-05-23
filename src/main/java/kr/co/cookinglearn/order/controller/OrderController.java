package kr.co.cookinglearn.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.order.service.OrderService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("/order")
public class OrderController {
	

	
	 @Autowired
	 	private OrderService service;
	 
	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) { 		
		
		UserVO uvo = (UserVO) session.getAttribute("login");
		BoardVO bvo = (BoardVO) session.getAttribute("classCode");
		
		
		if(uvo == null) {		
			return "order/cart";
		}else {
			
			int code = bvo.getClassCode();  
			List<BoardVO> cartList = service.cartList(code);
			model.addAttribute("cartList",cartList);
					
		}
		return "order/cart";
		
		//일단 세션이 없으니까
		//return "order/cart";
	}
	
	@GetMapping("/complete")
	public String complete() {
		return "order/complete";
	}
	
	
	
	
	
	
	
	
}
