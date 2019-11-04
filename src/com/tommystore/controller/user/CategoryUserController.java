package com.tommystore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tommystore.domain.CartItem;
import com.tommystore.service.CategoryService;

@Controller
@RequestMapping(value = "/user")
public class CategoryUserController {
	
	@Autowired
	private CategoryService categoryService;
	
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String userCategoryView(Model model) {

    	model.addAttribute("cartItem", new CartItem());
    	model.addAttribute("categoryList", categoryService.findCategories());
    	
		return "user-category";
    }
    
//    @RequestMapping(value = "/search-category", method = RequestMethod.GET)
//    public String productView(Model model, @RequestParam("categoryName") String category, RedirectAttributes attributes) {
//
//    	model.addAttribute("searchCriteria", productService.findSearchCriterias());
//    	model.addAttribute("productList", productService.searchProduct(category));
//    	model.addAttribute("searchBean", new SearchBean());
//    	
//		return "home";
//    }
	
}
