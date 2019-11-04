package com.tommystore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tommystore.domain.InventoryItem;

@Controller
@RequestMapping(value = "/admin")
public class InventoryController {
	
    @RequestMapping(value = "/inventoryitem-list-view", method = RequestMethod.GET)
    public String inventoryItemView(Model model) {
    	
    	model.addAttribute("inventoryItem", new InventoryItem());
    	
		return "admin-dashboard-inventoryitemlist";
    }
    
    @RequestMapping(value = "/stock-history", method = RequestMethod.GET)
    public String stockHistoryView(@RequestParam("id") Integer id, Model model) {
    	
		return "admin-dashboard-stockhistorylist";
    }
//    
//    @RequestMapping(value = "/add-stock-view", method = RequestMethod.GET)
//    public String editInventoryItemView(Model model, @RequestParam("id") Integer id) {
//    	
//    	InventoryItem inventoryItem = inventoryItemService.find(id);
//    	model.addAttribute("inventoryItem", inventoryItem);
//    	
//		return "admin-dashboard-add-stock";
//    }
    
}
