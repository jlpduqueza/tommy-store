package com.tommystore.controller.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.CreditCardBean;
import com.tommystore.bean.LoginBean;
import com.tommystore.bean.RoleFilterBean;
import com.tommystore.bean.ShippingAddressBean;
import com.tommystore.bean.SignUpBean;
import com.tommystore.bean.json.CreditCardBeanJson;
import com.tommystore.bean.json.ShippingAddressBeanJson;
import com.tommystore.bean.json.UserBeanJson;
import com.tommystore.constant.Role;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.CreditCard;
import com.tommystore.domain.JsonResponse;
import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;
import com.tommystore.service.CreditCardService;
import com.tommystore.service.ShippingAddressService;
import com.tommystore.service.UserService;

@Controller
@RequestMapping(value = "/ajax", produces = "application/json")
public class UserAjaxController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private ShippingAddressService shippingAddressService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageController messageController;
	
    @RequestMapping("/login")
    public String loginTest(Model model) {
    	
//    	User user = new User();
//
//    	user.setFirstName("admin");
//    	user.setLastName("admin");
//    	user.setContactNumber("123123");
//    	user.setPassword("admin");
//    	user.setEmail("admin");
//    	user.setRole(Role.ADMIN);
//    	
//    	userService.save(user);
    	
    	model.addAttribute(new LoginBean());
        return "loginTest";
    }  
	
    @PostMapping(value = "/loggingInTest")
    @ResponseBody
    public JsonResponse<User> loggingInTest(@Valid LoginBean login,  
          BindingResult result, HttpSession session) {

       JsonResponse<User> response = new JsonResponse<>();

       User user = userService.validateLogin(login); 
       																																																																																																
       if (result.hasErrors() || user == null) {
       		
	        response.setValidated(false);
	        response.setCustomMessage(messageController.getInvalidUser());
       }
       else {
    	    session.setAttribute("user", user);
            response.setValidated(true);
   	   		response.setLocation("/tommystore/");
       }
	   	
	   	return response;
    }
	
	@RequestMapping("/user")
	@ResponseBody
	public List<UserBeanJson> list() {
		
		return userService.findUsers().stream().map(UserBeanJson::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	@ResponseBody
	public List<UserBeanJson> filter(@Valid RoleFilterBean roleBean) {
		
		try {
			return userService.findByRole(Role.valueOf(roleBean.getRole())).stream().map(UserBeanJson::new).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			// this is when none enum is sent to roleBean which pertains to defaul "All" users are found
			return userService.findUsers().stream().map(UserBeanJson::new).collect(Collectors.toList());
		}
		
	}
	
	@RequestMapping("/new-user")
	@ResponseBody
	public List<UserBeanJson> newUserlist() {
		
		return userService.viewNewUser().stream().map(UserBeanJson::new).collect(Collectors.toList());
	}
	
    @RequestMapping(value = "/add-admin", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<User> addAdministrator(@Valid SignUpBean signUpBean, BindingResult result, Model model, 
    		HttpSession session, RedirectAttributes attributes) {
    	
    	JsonResponse<User> response = new JsonResponse<>();
    	
        if(!signUpBean.getConfirmPassword().equals(signUpBean.getPassword())) {
        	result.rejectValue("confirmPassword", "error.signUpBean", messageController.getPasswordNotMatch());
        }
        
        if(userService.isExistByEmail(signUpBean.getEmail())) {
        	result.rejectValue("email", "error.signUpBean", messageController.getEmailUsedMessage());
        }
    	
        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
            	if(errors.containsKey(error.getField())) {
                	errors.replace(error.getField(), errors.get(error.getField())+", "+error.getDefaultMessage());
            	}
            	else {
                	errors.put(error.getField(), error.getDefaultMessage());
            	}
            }
            
            response.setErrorMessages(errors);
            response.setValidated(false);
            
            return response;
        }	
        
		User user = new User();
		user.setEmail(signUpBean.getEmail());
		user.setPassword(signUpBean.getPassword());
		user.setContactNumber(signUpBean.getContactNumber());
		user.setFirstName(signUpBean.getFirstName());
		user.setLastName(signUpBean.getLastName());
		user.setRole(Role.ADMIN);
        
        userService.save(user);
        
        response.setCustomMessage(messageController.getSuccessAddingAdmin());
        response.setValidated(true);
        response.setData(user);
        
		return response;
    }
	
    @RequestMapping(value = "/add-address", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<ShippingAddressBeanJson> addAddressView(@Valid ShippingAddressBean shippingAddressBean, BindingResult result, Model model, HttpSession session, RedirectAttributes attributes) {
    	
    	JsonResponse<ShippingAddressBeanJson> response = new JsonResponse<>();
    	
    	if(result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
            	if(errors.containsKey(error.getField())) {
                	errors.replace(error.getField(), errors.get(error.getField())+", "+error.getDefaultMessage());
            	}
            	else {
                	errors.put(error.getField(), error.getDefaultMessage());
            	}
            }
			response.setValidated(false);
			response.setErrorMessages(errors);
			  
			return response;
    	}
    	
    	User user = (User) session.getAttribute("user");
    	
    	ShippingAddress shippingAddress = new ShippingAddress();
    	shippingAddress.setAddress1(shippingAddressBean.getAddress1());
    	shippingAddress.setAddress2(shippingAddressBean.getAddress2());
    	shippingAddress.setCountry(shippingAddressBean.getCountry());
    	shippingAddress.setZipCode(shippingAddressBean.getZipCode());
    	shippingAddress.setUser(userService.find(user.getId()));

    	response.setData(new ShippingAddressBeanJson(shippingAddressService.save(shippingAddress)));
    	response.setCustomMessage(messageController.getSuccessAddingAddress());
    	response.setValidated(true);
    	
		return response;
    }
    
    @RequestMapping(value = "/add-credit-card", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<CreditCardBeanJson> addCreditCard(@Valid CreditCardBean creditCardBean, BindingResult result, Model model, HttpSession session, RedirectAttributes attributes) {
    	
    	JsonResponse<CreditCardBeanJson> response = new JsonResponse<>();

    	if(result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
            	if(errors.containsKey(error.getField())) {
                	errors.replace(error.getField(), errors.get(error.getField())+", "+error.getDefaultMessage());
            	}
            	else {
                	errors.put(error.getField(), error.getDefaultMessage());
            	}
            }
			response.setValidated(false);
			response.setErrorMessages(errors);
			  
			return response;
    	}

    	User user = (User) session.getAttribute("user");
    	
    	CreditCard creditCard = new CreditCard();
    	creditCard.setCardNumber(creditCardBean.getCardNumber());
    	creditCard.setSecurityCode(creditCardBean.getSecurityCode());
    	creditCard.setUser(userService.find(user.getId()));
    	
    	response.setData(new CreditCardBeanJson(creditCardService.save(creditCard)));
    	response.setCustomMessage(messageController.getSuccessAddingCreditCard());
    	response.setValidated(true);
    	
    	return response;
    }
    
    @RequestMapping(value = "/delete-credit-card", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<?> deleteCreditCard(Model model, @RequestParam("id") Integer id, RedirectAttributes attributes) {
    	
    	JsonResponse<?> response = new JsonResponse<>();
    	
    	creditCardService.delete(id);
    	response.setCustomMessage(messageController.getSuccessDeletingCreditCard());
    	
		return response;
    }
    
    @RequestMapping(value = "/delete-shipping-address", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<?> deleteShippingAddress(Model model, @RequestParam("id") Integer id, RedirectAttributes attributes) {
    	
    	JsonResponse<?> response = new JsonResponse<>();
    	
    	shippingAddressService.delete(id);
    	response.setCustomMessage(messageController.getSuccessDeletingAddress());
    	
		return response;
    }
    
}
