package com.tommystore.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.SignUpBean;
import com.tommystore.constant.Role;
import com.tommystore.domain.User;
import com.tommystore.service.UserService;;

@Controller
@PropertySource("/WEB-INF/properties")
public class SignUpController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageController messageController;
	
	@RequestMapping(value = "ajax/sign-up", method = RequestMethod.GET)
	public String signUp(Model model) {
		
		model.addAttribute("signUpBean", new SignUpBean());
		
		return "sign-up";
	}
	
	@RequestMapping(value = "ajax/signing-up", method = RequestMethod.POST)
	public String signingUp(@Valid SignUpBean signUpBean, BindingResult result, Model model, 
			HttpSession session, RedirectAttributes attributes) {
		
	    if(!signUpBean.getConfirmPassword().equals(signUpBean.getPassword())) {
	    	result.rejectValue("confirmPassword", "error.signUpBean", messageController.getPasswordNotMatch());
	    }
	    
	    if(userService.isExistByEmail(signUpBean.getEmail())) {
	    	result.rejectValue("email", "error.signUpBean", messageController.getEmailUsedMessage());
	    }
		
	    if (result.hasErrors()) {
	    	
	        return "sign-up";
	    }
	    
		User user = new User();
		user.setEmail(signUpBean.getEmail());
		user.setPassword(signUpBean.getPassword());
		user.setContactNumber(signUpBean.getContactNumber());
		user.setFirstName(signUpBean.getFirstName());
		user.setLastName(signUpBean.getLastName());
		user.setRole(Role.USER);

	    session.setAttribute("user", userService.save(user));
	    attributes.addFlashAttribute("successMessage", messageController.getSuccessSignUp());
	    
		return "redirect:/";
	}
	    
	
}
