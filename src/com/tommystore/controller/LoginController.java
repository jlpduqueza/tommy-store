package com.tommystore.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.LoginBean;
import com.tommystore.bean.SearchBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.Cart;
import com.tommystore.domain.CartItem;
import com.tommystore.domain.User;
import com.tommystore.service.ProductService;
import com.tommystore.service.UserService;;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageController messageController;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    	
    	model.addAttribute("loginBean", new LoginBean());
    	
		return "login";
    }
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session)  {
    	
    	User user = (User) session.getAttribute("user");
    	
    	if(user == null) {
        	model.addAttribute("searchCriteria", productService.findSearchCriterias());
        	model.addAttribute("searchBean", new SearchBean());
        	model.addAttribute("cartItem", new CartItem());
        	
    		return "home";
    	}
    	
    	if(userService.find(user.getId()).getRole().equals(Role.ADMIN)) {
    		
    		return "redirect:/admin/dashboard";
    	}

    	model.addAttribute("searchCriteria", productService.findSearchCriterias());
    	model.addAttribute("searchBean", new SearchBean());
    	model.addAttribute("cartItem", new CartItem());
    	
		return "home";
    }
    
    @RequestMapping(value = "/logging-in", method = RequestMethod.POST)
    public String loggingIn(@Valid LoginBean login, BindingResult result, Model model, HttpSession session, RedirectAttributes attributes) {
        
        User user = userService.validateLogin(login); 
        
        if (result.hasErrors() || user == null) {
        	attributes.addFlashAttribute("errorMessage", messageController.getInvalidUser());
        	
            return "redirect:login";
        }	
        
    	session.setAttribute("user", user);
        
        if(user.getRole().equals(Role.ADMIN)) {

        	return "redirect:/";
        }
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	
    	if(cart != null) {
    		
    		return "redirect:/user/checkout-view";
    	}
    	
    	return "redirect:/";
        
    }
}
