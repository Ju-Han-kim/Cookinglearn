package kr.co.cookinglearn.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.siot.IamportRestClient.IamportClient;
import kr.co.cookinglearn.board.domain.BoardVO;
import kr.co.cookinglearn.order.service.OrderService;
import kr.co.cookinglearn.point.model.PointVO;
import kr.co.cookinglearn.user.model.UserVO;

@Controller
@RequestMapping("/order")
public class OrderController {

	private IamportClient api;

	@Autowired
	private OrderService service;

	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) {

		this.api = new IamportClient("3516296101724753",
				"zk2K0YxlwE0NADWDNHRcqpwmjnjew9W5tYPuXmPt1QgCucfhU7ukx1GQo05Va10D0Q8XdXqeOHQiU6zO");

		UserVO uvo = (UserVO) session.getAttribute("login");
		BoardVO bvo = (BoardVO) session.getAttribute("classInfo");
		PointVO point = (PointVO) session.getAttribute("point");

		if (uvo == null) {
			return "order/cart";
		} else {

//			int code = 1;
			int code = bvo.getClassCode();
			List<BoardVO> cartList = service.cartList(code);
			model.addAttribute("cartList", cartList);
			System.out.println(cartList);
			model.addAttribute("loginUser", uvo);
			model.addAttribute("point", point);

		}
		return "order/cart";

	}

	@GetMapping("/complete")
	// @ResponseBody
	public String complete(HttpSession session, Model model) {
		// System.out.println(amount);

		// UserVO uvo = (UserVO) session.getAttribute("login");

		return "order/complete";
	}

	@GetMapping("/getList")
	public String getOrderList(HttpSession session) {

		return "mypage/my_payment";
	}

}
