package com.tommystore.controller.ajax;

import java.util.List;
import java.util.stream.Collectors;

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

import com.tommystore.bean.json.InventoryItemBeanJson;
import com.tommystore.bean.json.StockHistoryBeanJson;
import com.tommystore.controller.MessageController;
import com.tommystore.domain.InventoryItem;
import com.tommystore.domain.JsonResponse;
import com.tommystore.domain.User;
import com.tommystore.service.InventoryItemService;

@Controller
@RequestMapping(value = "/ajax/inventory-item", produces = "application/json")
public class InventoryItemAjaxController {

	@Autowired
	private InventoryItemService inventoryItemService;
	
	@Autowired
	private MessageController messageController;
	
	@RequestMapping
	@ResponseBody
	public List<InventoryItemBeanJson> list() {
		return inventoryItemService.findInventoryItems().stream().map(InventoryItemBeanJson::new).collect(Collectors.toList());
	}

	@RequestMapping(value="edit")
	@ResponseBody
	public InventoryItemBeanJson inventoryItem(@RequestParam("id") Integer id) {
		return new InventoryItemBeanJson(inventoryItemService.find(id));
	}

	@RequestMapping(value="stock-history")
	@ResponseBody
	public List<StockHistoryBeanJson> stockHistory(@RequestParam("id") Integer id) {
		return inventoryItemService.findStockHistories(id).stream().map(StockHistoryBeanJson::new).collect(Collectors.toList());
	}

	@RequestMapping(value="low-stock")
	@ResponseBody
	public List<InventoryItemBeanJson> lowInStockList() {
		return inventoryItemService.findInventoryItemListByStock().stream().map(InventoryItemBeanJson::new).collect(Collectors.toList());
	}

    @RequestMapping(value = "/add-stock", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<InventoryItemBeanJson> inventoryItem(@Valid InventoryItem inventoryItem, BindingResult result, Model model, HttpSession session) {
    	
    	JsonResponse<InventoryItemBeanJson> response = new JsonResponse<>();
    	
        if (result.hasErrors()) {
        	response.setCustomMessage(messageController.getInvalidQuantityMessage());
        	response.setValidated(false);
        	
    		return response;
        }	
        
        InventoryItem toReplenish = inventoryItemService.find(inventoryItem.getId());
        toReplenish.setQuantity(inventoryItem.getQuantity());
        
    	response.setData(new InventoryItemBeanJson(inventoryItemService.replenishStock(toReplenish, (User) session.getAttribute("user"))));
    	response.setCustomMessage(messageController.getSuccessAddingStock());
    	response.setValidated(true);

		return response;
    }
	
}
