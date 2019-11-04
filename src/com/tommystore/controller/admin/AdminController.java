package com.tommystore.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tommystore.bean.RoleFilterBean;
import com.tommystore.bean.SignUpBean;
import com.tommystore.service.UserService;

@Controller
@RequestMapping(value = "/admin")
@PropertySource("/WEB-INF/properties")
public class AdminController {

	@Autowired
	private UserService userService;

    @RequestMapping(value = "/user-list-view", method = RequestMethod.GET)
    public String userListView(Model model, HttpSession session) {
    	
    	model.addAttribute("roleBean", new RoleFilterBean());
    	model.addAttribute("signUpBean", new SignUpBean());
    	model.addAttribute("roleList", userService.findRoles());
    	
		return "admin-dashboard-userlist";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
    	
    	return "admin-dashboard";
    }
    
//    @RequestMapping(value = "/filter-user", method = RequestMethod.POST)
//    public String filterUser(@Valid RoleFilterBean roleBean, Model model) {
//    	
//    	String role = roleBean.getRole();
//    	
//    	if(!role.equals("ADMIN") && !role.equals("USER")) {
//    		
//        	return "redirect:user-list-view";
//    	}
//    	
//    	model.addAttribute("userList", userService.findByRole(Role.valueOf(roleBean.getRole())));
//    	model.addAttribute("roleBean", new RoleFilterBean());
//    	model.addAttribute("roleList", userService.findRoles());
//    	model.addAttribute("role", roleBean.getRole());
//    	
//    	return "admin-dashboard-userlist";
//    }
    
//    @RequestMapping(value = "/add-admin-view", method = RequestMethod.GET)
//    public String addAdministratorView(Model model) {
//    	
//    	model.addAttribute("signUpBean", new SignUpBean());
//		
//    	return "admin-dashboard-add-administrator";
//    }
    
    
}
