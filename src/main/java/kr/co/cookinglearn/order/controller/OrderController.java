package kr.co.cookinglearn.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.order.model.OrderVO;
import kr.co.cookinglearn.order.service.OrderService;
import kr.co.cookinglearn.point.model.PointVO;
import kr.co.cookinglearn.point.service.PointService;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("/order")
public class OrderController {

	private IamportClient api;
	
	 @Autowired
	 	private OrderService service;
	 @Autowired
	 	private PointService pointservice;
	 
	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) {

		this.api = new IamportClient("3516296101724753",
				"zk2K0YxlwE0NADWDNHRcqpwmjnjew9W5tYPuXmPt1QgCucfhU7ukx1GQo05Va10D0Q8XdXqeOHQiU6zO");

		UserVO uvo = (UserVO) session.getAttribute("login");
	
		List<BoardVO> bvo = (List<BoardVO>) session.getAttribute("classInfo");
		System.out.println(uvo);
		System.out.println(bvo);
		
		System.out.println(pointservice);
		int point = pointservice.getUserPoint(uvo.getUserNo());
			
				
			//int code = 1;
			//List<BoardVO> 세션으로 받아와서 그중에 각각의 코드를 통해서 연결되게 넘겨주는걸로 하기
			List<BoardVO> cartList = new ArrayList<>();
			int code;
			if(bvo != null) {
				System.out.println(bvo.size());
				for(int i=0;i<bvo.size();i++) {
					System.out.println("bvo : "+bvo);
					System.out.println("bvo.get(i) : "+bvo.get(i));
					
					code = bvo.get(i).getClassCode();
					cartList.addAll(service.cartList(code));
				}
				System.out.println(cartList);
				//int code = bvo.getClassCode();  
			}
			model.addAttribute("cartList",cartList);
			System.out.println(cartList+" : "+cartList.size());
			model.addAttribute("loginUser",uvo);
			model.addAttribute("point",point);
					
			return "order/cart";
		
		
	}

	//@ResponseBody
	@GetMapping("/complete")
	public String complete(HttpSession session, Model model, PointVO pointVO) {
		//System.out.println(amount);
		
		//UserVO uvo = (UserVO) session.getAttribute("login");
		
		
		
		
		
		
		
		return "order/complete";
	}
	
	@PostMapping("/sessionDelete")
	public @ResponseBody void sessionDelete(HttpSession session, RequestParam request) {
		UserVO uvo = (UserVO) session.getAttribute("login");
		List<BoardVO> bvo = (List<BoardVO>) session.getAttribute("classInfo");
		
		String deleteSession = request.value();
		
		
		//List에서 하나만 삭제되게 해야하는데 그 번호를 어떻게 받아와야하나...
	}
	
	@PostMapping("/refund")
	public void refund(OrderVO orderVO, HttpSession session) {
		
	}
	
}
