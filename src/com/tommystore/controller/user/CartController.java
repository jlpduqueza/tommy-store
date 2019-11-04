package com.tommystore.controller.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tommystore.bean.OrderBean;
import com.tommystore.constant.PaymentType;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.Cart;
import com.tommystore.domain.CartItem;
import com.tommystore.domain.Order;
import com.tommystore.domain.ShippingAddress;
import com.tommystore.domain.User;
import com.tommystore.service.CreditCardService;
import com.tommystore.service.OrderItemService;
import com.tommystore.service.ShippingAddressService;
import com.tommystore.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShippingAddressService shippingAddressService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private MessageController messageController;
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartView(Model model, HttpSession session, RedirectAttributes attributes) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");

    	if(cart == null || cart.getCartItemMap().isEmpty()) {
    		attributes.addFlashAttribute("errorMessage", messageController.getNoCartMessage());
    		
    		return "redirect:/";
    	}
    	
    	model.addAttribute("cartItemMap", cart.getCartItemMap());
    	model.addAttribute("cartItem", new CartItem());
    	
		return "user-cart";
    }

    @RequestMapping(value = "/checkout-view", method = RequestMethod.GET)
    public String checkOutView(Model model, HttpSession session, RedirectAttributes attributes) {
    	
    	Cart cart = (Cart) session.getAttribute("cart");
    	User user = (User) session.getAttribute("user");
    	
    	if(user == null) {
    		
    		return "redirect:/ajax/login";
        }
    	
    	if(cart.getCartItemMap().isEmpty()) {
    		attributes.addFlashAttribute("errorMessage", messageController.getNoCartMessage());
    		
    		return "redirect:/";
    	}
    	
    	if(!userService.isUserValidForCheckout(user)) {
    		attributes.addFlashAttribute("errorMessage", messageController.getNotQualifiedForCheckout());
    		
    		return "redirect:cart";
    	}
    	
    	model.addAttribute("cartItemMap", cart.getCartItemMap());
    	model.addAttribute("orderBean", new OrderBean());
    	model.addAttribute("shippingAddressList",shippingAddressService.findShippingAddresses(user));
    	model.addAttribute("creditCardList", creditCardService.findCreditCardsByUser(user));
    	
		return "user-checkout";
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkOut(@Valid OrderBean orderBean, BindingResult result, Model model, 
    		HttpSession session, RedirectAttributes attributes) {
    
    	User user = (User) session.getAttribute("user");
    	PaymentType paymentType = PaymentType.CASH; //default value if not overwritten
    	
    	if(result.hasErrors()) {
    		attributes.addFlashAttribute("errorMessage", messageController.getInvalidCheckOut());
    		
    		return "redirect:checkout-view";
    	}
    	
    	if(orderBean.getCreditCard().getId() != 0) {
    		paymentType = PaymentType.CREDIT_CARD;
        }
    	
    	ShippingAddress shippingAddress = shippingAddressService.find(orderBean.getShippingAddress().getId());
    	
    	Order order = new Order();
    	Cart cart = (Cart) session.getAttribute("cart");
    	
    	order.setPaymentType(paymentType);
    	order.setShippingAddress(shippingAddress);
    	order.setUser(user);
    	orderItemService.checkOut(order, cart);
    	
    	session.setAttribute("cart", null);
    	attributes.addFlashAttribute("successMessage", messageController.getSuccessCheckout());
    	
		return "redirect:/";
    }
	
//    @RequestMapping(value = "/add-to-cart-view", method = RequestMethod.GET)
//    public String addToCartView(Model model, @RequestParam("id") Integer id, HttpSession session) {
//    	
//    	CartItem cartItem = new CartItem();
//    	cartItem.setProduct(productService.find(id));
//    	
//    	model.addAttribute("cartItem", cartItem);
//    	
//		return "user-addtocart";
//    }
    
//    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
//    public String addToCart(@Valid CartItem cartItem, Model model, HttpSession session, RedirectAttributes attributes) {
//    	
//    	Integer productId = cartItem.getProduct().getId();
//    	Product product = productService.find(cartItem.getProduct().getId());
//    	
//    	cartItem.setProduct(product);
//
//    	if(cartItem.getQuantity() < 1 ) {  	
//	    	attributes.addFlashAttribute("errorMessage", messageController.getZeroQuantityMessage());
//
//    		return "redirect:add-to-cart-view/"+product.getId();
//    	}
//    	
//    	if(!inventoryItemService.isQuantitySufficient(cartItem, product)) {
//    		attributes.addFlashAttribute("errorMessage", messageController.getInsufficientQuantityMessage());
//    		
//    		return "redirect:add-to-cart-view/"+product.getId();
//    	}
//    	
//    	if(session.getAttribute("cart") == null) {
//        	Cart cart = new Cart();
//        	
//        	Map<Integer, CartItem> cartItemMap = new HashMap<>();
//        	
//        	cartItemMap.put(productId, cartItem);
//        	cart.setCartItemMap(cartItemMap);
//        	attributes.addFlashAttribute("successMessage", messageController.getSuccessAddingCartItem());
//        	
//        	session.setAttribute("cart", cart);
//        	
//    		return "redirect:/";
//    	}
//
//    	Cart cart = (Cart) session.getAttribute("cart");
//    	
//    	if(!cart.getCartItemMap().containsKey(productId)) {
//        	cart.getCartItemMap().put(productId, cartItem);
//        	
//        	session.setAttribute("cart", cart);
//        	
//    		return "redirect:/";
//    	}
//    	
//    	int quantity = cart.getCartItemMap().get(productId).getQuantity()+cartItem.getQuantity();
//    	
//    	if(!inventoryItemService.isQuantitySufficient(cart.getCartItemMap().get(productId), product)) {
//        	attributes.addFlashAttribute("errorMessage", messageController.getInsufficientQuantityMessage());
//        	
//    		return "redirect:add-to-cart-view/"+product.getId();
//    	}
//    	
//    	CartItem cartItemFromCart = cart.getCartItemMap().get(productId);
//    	cartItemFromCart.setQuantity(quantity);
//    	
//    	session.setAttribute("cart", cart);
//    	attributes.addFlashAttribute("successMessage", messageController.getSuccessAddingCartItem());
//    	
//		return "redirect:/";
//    }
    
//    @RequestMapping(value = "/edit-cartitem-view", method = RequestMethod.GET)
//    public String editCartView(Model model, @RequestParam("id") Integer id, HttpSession session) {
//    	
//    	Cart cart = (Cart) session.getAttribute("cart");
//    	Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
//    	
//    	model.addAttribute("cartItem", cartItemMap.get(id));
//    	
//		return "user-editcart";
//    }

    
	
}
