package com.tommystore.controller.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommystore.bean.json.OrderItemBeanJson;
import com.tommystore.service.OrderItemService;

@Controller
@RequestMapping(value = "/ajax/order-item", produces = "application/json")
public class OrderItemAjaxController {

	private OrderItemService orderItemService;
	
	@Autowired
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	@RequestMapping
	@ResponseBody
	public List<OrderItemBeanJson> list(@RequestParam("id") Integer id) {
		return orderItemService.findOrderItemsByProductId(id).stream().map(OrderItemBeanJson::new).collect(Collectors.toList());
	}
	
}