package com.tommystore.controller.admin;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.ProductBean;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.Product;
import com.tommystore.service.CategoryService;
import com.tommystore.service.ProductService;


@Controller
@RequestMapping(value = "/admin")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MessageController messageController;
	
    @RequestMapping(value = "/product-list-view", method = RequestMethod.GET)
    public String productView(Model model) {
    	
		return "admin-dashboard-productlist";
    }
    
    @RequestMapping(value = "/product-orders-view", method = RequestMethod.GET)
    public String showOrderPerProduct(Model model, @RequestParam("id") Integer id) {
    	
		return "admin-dashboard-product-orders-view";
    }
    
//    @RequestMapping(value = "/add-product-view", method = RequestMethod.GET)
//    public String addProductView(Model model) {
//    	
//    	model.addAttribute("productBean", new ProductBean());
//    	model.addAttribute("categoryMap",categoryService.getCategoryMap());
//    	
//		return "admin-dashboard-add-product";
//    }
//    
//    @RequestMapping(value = "/edit-product-view", method = RequestMethod.GET)
//    public String editProductView(Model model, @RequestParam("id") Integer id) {
//    	
//    	Product product = productService.find(id);
//    	ProductBean productBean = new ProductBean();
//    	productBean.setCategory(product.getCategory());
//    	productBean.setId(product.getId());
//    	productBean.setName(product.getName());
//
//    	model.addAttribute("product", product);
//    	model.addAttribute("productBean", productBean);
//    	model.addAttribute("categoryMap",categoryService.getCategoryMap());
//    	
//		return "admin-dashboard-edit-product";
//    }
    

    @RequestMapping(value = "/edit-product-view", method = RequestMethod.GET)
    public String editCategoryView(Model model, @RequestParam("id") Integer id) {
	
    	Product product = productService.find(id);
    	model.addAttribute("product", product);
    	model.addAttribute("productBean", new ProductBean());
	
    	return "admin-dashboard-edit-product";
    }
    
    
    
}
