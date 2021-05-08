package kr.co.cookinglearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.cookinglearn.admin.common.page.OrderSearchVO;
import kr.co.cookinglearn.admin.common.page.PageMgr;
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
	
}
