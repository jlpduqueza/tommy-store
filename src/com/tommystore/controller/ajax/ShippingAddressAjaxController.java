package com.tommystore.controller.ajax;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommystore.bean.json.ShippingAddressBeanJson;
import com.tommystore.domain.User;
import com.tommystore.service.ShippingAddressService;

@Controller
@RequestMapping(value = "/ajax", produces = "application/json")
public class ShippingAddressAjaxController {
	
	private ShippingAddressService shippingAddressService;

	@Autowired
	public void setCategoryService(ShippingAddressService shippingAddressService) {
		this.shippingAddressService = shippingAddressService;
	}
	
	@RequestMapping("/shippingAddress")
	@ResponseBody
	public List<ShippingAddressBeanJson> list(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		return shippingAddressService.findShippingAddresses(user).stream().map(ShippingAddressBeanJson::new).collect(Collectors.toList());
	}
	
}
