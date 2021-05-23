package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
import kr.co.cookinglearn.admin.model.OrderVO;
import kr.co.cookinglearn.admin.service.interfaces.IOrderMgrService;

@Controller
@RequestMapping("/admin/order")
public class OrderMgrController {
	
	@Autowired
	private IOrderMgrService service;
	
	//주문관리-온라인 mapping
	@GetMapping("/on")
	public String onlineOrderMgr(OrderSearchVO search, Model model) {
	
		model.addAttribute("menu", "Order");
		
		search.setClassType(true);
		model.addAttribute("pageMgr", new PageMgr(search, service.orderCount(search)));
		model.addAttribute("search", search);
		model.addAttribute("orderList",service.getOrderList(search));
		
		return "admin/orderMgr/onlineOrderManager";
	}
	
	//주문관리-오프라인 mapping
	@GetMapping("/off")
	public String offlineOrderMgr(OrderSearchVO search, Model model) {
	
		model.addAttribute("menu", "Order");
		
		search.setClassType(false);
		model.addAttribute("pageMgr", new PageMgr(search, service.orderCount(search)));
		model.addAttribute("search", search);
		model.addAttribute("orderList",service.getOrderList(search));
		
		return "admin/orderMgr/offlineOrderManager";
	}
	
	//주문관리-상세현황 mapping
	@GetMapping("/{orderNo}")
	public String orderView(@PathVariable int orderNo,OrderSearchVO search, Model model) {
		
		model.addAttribute("menu", "Order");
		
		OrderVO order = service.getOrderInfo(orderNo);

		String orderPath = new PageMgr(search , service.orderCount(search)).mkOrderUri(search.getCurrentPage());
		
		model.addAttribute("orderInfo", order);
		model.addAttribute("userInfo", service.getUserInfo(order.getUserNo()));
		model.addAttribute("classInfo", service.getClassInfo(order.getClassCode()));
		model.addAttribute("reviewInfo", service.getUserReview(order));
		model.addAttribute("orderPath", orderPath);
		
		return "admin/orderMgr/orderInfo";
	}
	
	
	
	
	
	
	
	
	
	
	
}
