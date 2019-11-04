package com.tommystore.controller.ajax;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.json.CategoryBeanJson;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.Category;
import com.tommystore.domain.JsonResponse;
import com.tommystore.service.CategoryService;
import com.tommystore.service.ProductService;

@Controller
@RequestMapping(value = "/ajax/category", produces = "application/json")
public class CategoryAjaxController {


	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageController messageController;

	@RequestMapping
	@ResponseBody
	public List<CategoryBeanJson> list() {
		return categoryService.findCategories().stream().map(CategoryBeanJson::new).collect(Collectors.toList());
	}
	
	@RequestMapping(value="editView")
	@ResponseBody
	public CategoryBeanJson editView(@RequestParam("id") Integer id) {
		return new CategoryBeanJson(categoryService.find(id));
	}
	
    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<Category> deleteCategory(Model model, @RequestParam("id") Integer id, 
    		RedirectAttributes attributes) {
    	
    	JsonResponse<Category> response = new JsonResponse<>();

    	response.setValidated(true);
    	
		if(!productService.findProductByCategoryId(id).isEmpty()) {
	    	response.setCustomMessage(messageController.getDeletionErrorMessage());
	    	response.setValidated(false);
	    	
			return response;
		}
		
    	categoryService.delete(id);  
    	response.setCustomMessage(messageController.getSuccessDeletingCategory());
    	
		return response;
    }
	

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<Category> editCategory(@Valid Category categoryToEdit, BindingResult result, Model model, 
    		RedirectAttributes attributes) {
 
    	JsonResponse<Category> response = new JsonResponse<>();
    	response.setValidated(true);
    	
        if(!categoryService.isValidToEditByIdAndName(categoryToEdit.getId(), categoryToEdit.getName())) {
	    	result.rejectValue("name", "error.category", messageController.getNameUsedErrorMessage());
        }    
        
        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors().stream()
                  .collect(
                        Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            response.setErrorMessages(errors);
        	response.setValidated(false);
        	
    		return response;
        }
        
        Category category = categoryService.find(categoryToEdit.getId());
        category.setName(categoryToEdit.getName());
        
        response.setData(categoryService.save(category));
        response.setCustomMessage(messageController.getSuccessEditingCategory());
    	response.setValidated(true);
    	
		return response;
    }
    
    
    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<Category> addCategory(@Valid Category category, BindingResult result, Model model, 
    		HttpSession session) {

    	JsonResponse<Category> response = new JsonResponse<>();
    	
        if(categoryService.isCategoryExistByName(category.getName())) {
	    	result.rejectValue("name", "error.category", messageController.getNameUsedErrorMessage());
        }
        
        if (result.hasErrors()) {

            Map<String, String> errors = result.getFieldErrors().stream()
                  .collect(
                        Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            response.setValidated(false);
            response.setErrorMessages(errors);
            
            return response;
        }	
        
        categoryService.save(category);

        response.setCustomMessage(messageController.getSuccessAddingCategory());
        response.setValidated(true);
        response.setData(category);
        
		return response;
    }
    
}
