package com.tommystore.controller.admin;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tommystore.domain.Category;

@Controller
@RequestMapping(value = "/admin")
@PropertySource("/WEB-INF/properties")
public class CategoryAdminController {
	
    @RequestMapping(value = "/category-list-view", method = RequestMethod.GET)
    public String categoryView(Model model) {
    	
    	model.addAttribute("category", new Category());
    	
		return "admin-dashboard-categorylist";
    }
//    
//    @RequestMapping(value = "/add-category-view", method = RequestMethod.GET)
//    public String addCategoryView(Model model) {
//    	
//    	model.addAttribute("category", new Category());
//    	
//		return "admin-dashboard-add-category";
//    }
//    
//    @RequestMapping(value = "/edit-category-view", method = RequestMethod.GET)
//    public String editCategoryView(Model model, @RequestParam("id") Integer id) {
//    	
//    	Category category = categoryService.find(id);
//    	model.addAttribute("category", category);
//    	
//		return "admin-dashboard-edit-category";
//    }
    
}
