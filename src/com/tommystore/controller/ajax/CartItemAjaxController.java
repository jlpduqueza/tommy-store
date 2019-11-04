package com.tommystore.controller.ajax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommystore.bean.json.CartItemBeanJson;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.Cart;
import com.tommystore.domain.CartItem;
import com.tommystore.domain.JsonResponse;
import com.tommystore.domain.Product;
import com.tommystore.service.InventoryItemService;
import com.tommystore.service.ProductService;

@Controller
@RequestMapping(value = "/ajax", produces = "application/json")
public class CartItemAjaxController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private InventoryItemService inventoryItemService;
	
	@Autowired
	private MessageController messageController;
	
	@RequestMapping("/cart")
	@ResponseBody
	public List<CartItemBeanJson> list(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<CartItemBeanJson> cartItemBeanList = new ArrayList<CartItemBeanJson>();

    	BigDecimal totalPrice = new BigDecimal(0);
    	
    	for(CartItem cartItem : cart.getCartItemMap().values()) {
    		totalPrice.add(cartItem.getProduct().getPrice().multiply(new BigDecimal(cartItem.getQuantity())));
    	}
    	
    	System.out.println(totalPrice);
		for(Map.Entry<Integer, CartItem> map: cart.getCartItemMap().entrySet()) {
			
			CartItemBeanJson cartItemBean = null;
			int quantity = map.getValue().getProduct().getInventoryItem().getQuantity();
			
			if(quantity >= 50) {
				cartItemBean = new CartItemBeanJson(map.getValue(), "In Stock");
			}
			
			if(quantity < 50 && quantity > 0) {
				cartItemBean = new CartItemBeanJson(map.getValue(), "Only " + quantity + " left in stock");
			}
			
			if(quantity < 1) {
				cartItemBean = new CartItemBeanJson(map.getValue(), "No stock");
			}
			
			cartItemBeanList.add(cartItemBean);
			
		}
				
		return cartItemBeanList;
	}
	
    @RequestMapping(value = "/edit-cart", method = RequestMethod.GET)
	@ResponseBody
    public CartItemBeanJson editCartView(Model model, @RequestParam("id") Integer id, HttpSession session) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();

		CartItemBeanJson cartItemBean = null;
		int quantity = cartItemMap.get(id).getProduct().getInventoryItem().getQuantity();
		
		if(quantity >= 50) {
			cartItemBean = new CartItemBeanJson(cartItemMap.get(id), "In Stock");
		}
		
		if(quantity < 50 && quantity > 0) {
			cartItemBean = new CartItemBeanJson(cartItemMap.get(id), "Only " + quantity + " left in stock");
		}
		
		if(quantity < 1) {
			cartItemBean = new CartItemBeanJson(cartItemMap.get(id), "No stock");
		}
    	
		return cartItemBean;
    }
	
    
    @RequestMapping(value = "/edit-cartitem", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<CartItemBeanJson> editCart(CartItem cartItem,  Model model, HttpSession session) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
    	CartItem cartItemToEdit = cartItemMap.get(cartItem.getProduct().getId());
    	
    	JsonResponse<CartItemBeanJson> response = new JsonResponse<>();
    	
    	if(cartItem.getQuantity() < 1 ) {  	
	    	response.setCustomMessage(messageController.getZeroQuantityMessage());
	    	response.setValidated(false);
	    	
    		return response;
    	}
    	
    	if(!inventoryItemService.isQuantitySufficient(cartItem, cartItemToEdit.getProduct())) {
        	response.setCustomMessage(messageController.getInsufficientQuantityMessage());
	    	response.setValidated(false);

    		return response;
    	}
    	
    	cartItem.setProduct(productService.find(cartItem.getProduct().getId()));
    	cartItemMap.replace(cartItem.getProduct().getId(), cartItem);
    	cart.setCartItemMap(cartItemMap);
    	
    	session.setAttribute("cart", cart);

    	response.setCustomMessage(messageController.getSuccessEditingCartItem());
    	response.setValidated(true);
    	response.setData(new CartItemBeanJson(cartItem));
    	
		return response;
    }
    

    @RequestMapping(value = "/delete-cartitem", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<CartItem> deleteCartItem(Model model, HttpSession session, @RequestParam("id") Integer id) {
    	
    	JsonResponse<CartItem> response = new JsonResponse<>();
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
    	
    	cartItemMap.remove(id);
    	
		response.setValidated(true);
		
    	cart.setCartItemMap(cartItemMap);
    	session.setAttribute("cart", cart);
    	
    	if(cartItemMap.isEmpty()) {
    		response.setValidated(false);
    		response.setLocation("/cart");
    	}

    	response.setCustomMessage(messageController.getSuccessDeletingCartItem());
    	
		return response;
    }
    
    @RequestMapping(value = "/clear-cart", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse<?> clearCart(Model model, HttpSession session) {
    	
    	JsonResponse<?> response = new JsonResponse<>();
    	
    	session.setAttribute("cart", null);
    	
    	response.setCustomMessage(messageController.getSuccessClearingCart());
    	response.setLocation("/cart");
    	
		return response;
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<CartItem> addToCart(@Valid CartItem cartItem, BindingResult result, Model model, HttpSession session) {
    	
        JsonResponse<CartItem> response = new JsonResponse<>();
    	
//        if(result.hasErrors()) {
//	    	response.setValidated(false);
//	    	System.out.println("test");
//	    	System.out.println(result.getAllErrors().toString());
//	    	
//    		return response;
//        }
        
    	Integer productId = cartItem.getProduct().getId();
    	Product product = productService.find(cartItem.getProduct().getId());
    	
    	cartItem.setProduct(product);

    	if(cartItem.getQuantity() < 1 ) {  	
	    	response.setCustomMessage(messageController.getZeroQuantityMessage());
	    	response.setValidated(false);
	    	
    		return response;
    	}
    	
    	if(!inventoryItemService.isQuantitySufficient(cartItem, product)) {
    		response.setCustomMessage(messageController.getInsufficientQuantityMessage());
	    	response.setValidated(false);
    		
    		return response;
    	}
    	
    	if(session.getAttribute("cart") == null) {
        	Cart cart = new Cart();
        	
        	Map<Integer, CartItem> cartItemMap = new HashMap<>();
        	
        	cartItemMap.put(productId, cartItem);
        	cart.setCartItemMap(cartItemMap);
        	response.setCustomMessage(messageController.getSuccessAddingCartItem());
	    	response.setValidated(true);
        	
        	session.setAttribute("cart", cart);
        	
    		return response;
    	}

    	Cart cart = (Cart) session.getAttribute("cart");
    	
    	if(!cart.getCartItemMap().containsKey(productId)) {
        	cart.getCartItemMap().put(productId, cartItem);
        	
        	session.setAttribute("cart", cart);
	    	response.setValidated(true);
        	
    		return response;
    	}
    	
    	int quantity = cart.getCartItemMap().get(productId).getQuantity()+cartItem.getQuantity();
    	
    	if(!inventoryItemService.isQuantitySufficient(cart.getCartItemMap().get(productId), product)) {
        	response.setCustomMessage(messageController.getInsufficientQuantityMessage());
	    	response.setValidated(false);
        	
    		return response;
    	}
    	
    	CartItem cartItemFromCart = cart.getCartItemMap().get(productId);
    	cartItemFromCart.setQuantity(quantity);
    	
    	session.setAttribute("cart", cart);
    	response.setCustomMessage(messageController.getSuccessAddingCartItem());
    	response.setValidated(true);
    	
		return response;
    }
    
}
