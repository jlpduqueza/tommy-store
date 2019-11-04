package com.tommystore.controller.ajax;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommystore.bean.ProductBean;
import com.tommystore.bean.SearchBean;
import com.tommystore.bean.json.ProductBeanJson;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.Category;
import com.tommystore.domain.JsonResponse;
import com.tommystore.domain.Product;
import com.tommystore.service.CategoryService;
import com.tommystore.service.OrderItemService;
import com.tommystore.service.ProductService;

@Controller
@RequestMapping(value = "/ajax", produces = "application/json")
public class ProductAjaxController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private MessageController messageController;
	
	@RequestMapping("/productlist")
	@ResponseBody
	public List<ProductBeanJson> list() {
		return productService.findProducts().stream().map(ProductBeanJson::new).collect(Collectors.toList());
	}
	
	@RequestMapping("/product")
	@ResponseBody
	public ProductBeanJson product(@RequestParam("id") Integer id) {
		return new ProductBeanJson(productService.find(id));
	}

	
	@RequestMapping("/product/editView")
	@ResponseBody
	public ProductBeanJson editView(@RequestParam("id") Integer id) {
		return new ProductBeanJson(productService.find(id));
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductBeanJson> searchList(SearchBean searchBean) {

    	List<Product> productList = null;
    	
		if(searchBean.getCriteria().equals("Category")) {
			productList = productService.searchProductByCategory(searchBean.getKeyword());
		}	
		
		else if(searchBean.getCriteria().equals("Name")) {
			productList = productService.searchProductByName(searchBean.getKeyword());
		}
		
		else {
			productList = productService.searchProduct(searchBean.getKeyword());
		}
		
		return productList.stream().map(ProductBeanJson::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/search-category", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductBeanJson> searchList(@RequestParam("name") String keyword) {
		return productService.searchProductByCategory(keyword)
				.stream().map(ProductBeanJson::new).collect(Collectors.toList());
	}
	
    
    @RequestMapping(value = "/delete-product", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<?> deleteProduct(Model model, @RequestParam("id") Integer id) {
    	
    	JsonResponse<?> response = new JsonResponse<>();
    	
    	if(!orderItemService.findOrderItemsByProductId(id).isEmpty()) {
        	response.setCustomMessage(messageController.getDeletionErrorMessage());
        	response.setValidated(false);
        	response.setLocation("/product-list-view");
        	
    		return response;
    	}
    	
    	productService.delete(id);
    	response.setCustomMessage(messageController.getSuccessDeletingProduct());
    	response.setValidated(true);
    	
		return response;
    }
    
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<ProductBeanJson> addProduct(@Valid ProductBean productBean, BindingResult result, Model model, HttpSession session) throws IOException {
    	
    	JsonResponse<ProductBeanJson> response = new JsonResponse<>();
    	
        if(productService.isExistByNameAndCategoryId(productBean.getName(), productBean.getCategory().getId())) {
        	result.rejectValue("name", "error.productBean", messageController.getProductNameUsedMessage());
        }

        if(productService.isExistByPicture(productBean.getPicture())) {
        	result.rejectValue("picture", "error.productBean", messageController.getPictureUsedMessage());
        }

        if(!productService.isPriceValid(productBean.getPrice())) {
        	result.rejectValue("price", "error.productBean", messageController.getInvalidPriceMessage());
        }

        if (result.hasErrors()) {
        	
        	model.addAttribute("categoryMap",categoryService.getCategoryMap());
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

        Category category = categoryService.find(productBean.getCategory().getId());
        String filename = "no-image.jpg";
        
        if(!productBean.getPicture().getOriginalFilename().isEmpty()) {
            filename = productBean.getPicture().getOriginalFilename();  
            String path = "C:/Users/Lee/Pictures/images";  //fix this
            
	        byte[] bytes = productBean.getPicture().getBytes();  
	        BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	             new File(path + File.separator + filename)));  
	        
	        stream.write(bytes);  
	        stream.flush();  
	        stream.close();  
        }

        Product product = new Product();
        product.setPicturePath(filename);
        product.setCategory(category);
        product.setName(productBean.getName());
        product.setPrice(new BigDecimal(productBean.getPrice()));
        
        response.setData(new ProductBeanJson(productService.save(product)));
        response.setCustomMessage(messageController.getSuccessAddingProduct());
		response.setValidated(true);
        
        return response;
    }
    

    @RequestMapping(value = "/edit-product", method = RequestMethod.POST)
    @ResponseBody
	public JsonResponse<ProductBeanJson> editProduct(@Valid ProductBean productBean, BindingResult result, Model model, HttpSession session) throws IOException {
    	
    	JsonResponse<ProductBeanJson> response = new JsonResponse<>();
    	
    	if(productService.isNameValid(productBean.getName(), productBean.getId())) {
        	result.rejectValue("name", "error.productBean", messageController.getProductNameUsedMessage());
        }
        
        if(!productService.isPriceValid(productBean.getPrice())) {
        	result.rejectValue("price", "error.productBean", messageController.getInvalidPriceMessage());
        }
    	
        if (result.hasErrors()) {
        	model.addAttribute("categoryMap",categoryService.getCategoryMap());

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

		Product product = productService.find(productBean.getId());
		
		if(!productBean.getPicture().isEmpty()) {

	        product.setPicturePath(productBean.getPicture().getOriginalFilename());
		}
        
		product.setCategory(categoryService.find(productBean.getCategory().getId()));
		product.setName(productBean.getName());
		product.setPrice(new BigDecimal(productBean.getPrice()));
        
        productService.save(product);
        
        response.setData(new ProductBeanJson(productService.save(product)));
        response.setCustomMessage(messageController.getSuccessEditingProduct());
		response.setValidated(true);
        
    	System.out.println("editting");
		
		return response;
    }
	
}
