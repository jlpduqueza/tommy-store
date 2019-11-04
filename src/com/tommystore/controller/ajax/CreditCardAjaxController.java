package com.tommystore.controller.ajax;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommystore.bean.json.CreditCardBeanJson;
import com.tommystore.domain.User;
import com.tommystore.service.CreditCardService;

@Controller
@RequestMapping(value = "/ajax", produces = "application/json")
public class CreditCardAjaxController {
	
	private CreditCardService creditCardService;

	@Autowired
	public void setCategoryService(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}
	
	@RequestMapping("/creditCard")
	@ResponseBody
	public List<CreditCardBeanJson> list(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		return creditCardService.findCreditCardsByUser(user).stream().map(CreditCardBeanJson::new).collect(Collectors.toList());
	}
	
}
