package com.tommystore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tommystore.bean.CreditCardBean;
import com.tommystore.bean.ShippingAddressBean;
import com.tommystore.service.ShippingAddressService;

@Controller
@RequestMapping(value = "/user")
@PropertySource("/WEB-INF/properties")
public class UserController {

	@Autowired
	private ShippingAddressService shippingAddressService;
	
    @RequestMapping(value = "/my-account", method = RequestMethod.GET)
    public String myAccount(Model model) {
    	
    	model.addAttribute("countryList", shippingAddressService.findCountries());
    	model.addAttribute("shippingAddressBean", new ShippingAddressBean());
    	model.addAttribute("creditCardBean", new CreditCardBean());
    	
		return "user-myaccount";
    }
//    
//    @RequestMapping(value = "/add-address-view", method = RequestMethod.GET)
//    public String addAddress(Model model) {
//    	
//    	model.addAttribute("countryList", shippingAddressService.findCountries());
//    	model.addAttribute("shippingAddressBean", new ShippingAddressBean());
//
//		return "user-add-address";
//    }
//    
//    @RequestMapping(value = "/add-credit-card-view", method = RequestMethod.GET)
//    public String addCreditCardView(Model model) {
//    	
//    	model.addAttribute("creditCardBean", new CreditCardBean());
//    	
//		return "user-add-creditcard";
//    }
//    
//    @RequestMapping(value = "/credit-card-view", method = RequestMethod.GET)
//    public String creditCardView(Model model, HttpSession session) {
//    	
//    	User user = (User) session.getAttribute("user");
//    	model.addAttribute("creditCardList", creditCardService.findCreditCardsByUser(user));
//    	
//		return "user-creditcard-view";
//    }
//
//    @RequestMapping(value = "/shipping-address-view", method = RequestMethod.GET)
//    public String addressView(Model model, HttpSession session) {
//    	
//    	User user = (User) session.getAttribute("user");
//    	model.addAttribute("shippingAddressList", shippingAddressService.findShippingAddresses(user));
//    	
//		return "user-shippingaddress-view";
//    }
	
	
}
