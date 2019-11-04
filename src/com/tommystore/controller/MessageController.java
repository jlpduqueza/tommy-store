package com.tommystore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

@Controller
@PropertySource("/WEB-INF/properties")
public class MessageController {
	
	@Value("${invalid.categoryNameUsed}")
	private  String nameUsedErrorMessage;
	
	@Value("${invalid.categoryDeletion}")
	private  String deletionErrorMessage;
	
	@Value("${success.addingCategory}")
	private  String successAddingCategory;

	@Value("${success.editingCategory}")
	private  String successEditingCategory;

	@Value("${success.deletingCategory}")
	private  String successDeletingCategory;
	
	@Value("${invalid.user}")
	private  String invalidUserMessage;
	
	@Value("${invalid.savingUser}")
	private  String invalidSavingUser;
	
	@Value("${invalid.emailUsed}")
	private  String emailUsedMessage;
	
	@Value("${invalid.pictureUsed}")
	private  String pictureUsedMessage;
	
	@Value("${success.addingAdmin}")
	private  String successAddingAdmin;
	
	@Value("${invalid.passwordNotMatch}")
	private  String passwordNotMatch;
	
	@Value("${invalid.productNameUsed}")
	private  String productNameUsedMessage;
	
	@Value("${invalid.invalidPrice}")
	private  String invalidPriceMessage;
	
	@Value("${success.addingProduct}")
	private  String successAddingProduct;
	
	@Value("${success.editingProduct}")
	private  String successEditingProduct;
	
	@Value("${success.deletingProduct}")
	private  String successDeletingProduct;
	
	@Value("${invalid.user}")
	private  String invalidUser;
	
	@Value("${success.signUp}")
	private  String successSignUp;
	
	@Value("${invalid.invalidQuantity}")
	private  String invalidQuantityMessage;
	
	@Value("${success.addingStock}")
	private  String successAddingStock;
	
	@Value("${insufficient.quantity}")
	private  String insufficientQuantityMessage;
	
	@Value("${invalid.zeroQuantity}")
	private  String zeroQuantityMessage;
	
	@Value("${invalid.noCart}")
	private  String noCartMessage;
				
	@Value("${invalid.notQualifiedForCheckout}")
	private  String notQualifiedForCheckout;
	
	@Value("${invalid.forCheckout}")
	private  String invalidCheckOut;
	
	@Value("${success.addingCartItem}")
	private  String successAddingCartItem;
	
	@Value("${success.editingCartItem}")
	private  String successEditingCartItem;
	
	@Value("${success.clearingCart}")
	private  String successClearingCart;
	
	@Value("${success.deletingCartItem}")
	private  String successDeletingCartItem;
	
	@Value("${success.checkOut}")
	private  String successCheckout;
	
	@Value("${success.addingAddress}")
	private String successAddingAddress;
	
	@Value("${success.addingCreditCard}")
	private String successAddingCreditCard;
	
	@Value("${success.deletingCreditCard}")
	private String successDeletingCreditCard;
	
	@Value("${success.deletingAddress}")
	private String successDeletingAddress;

	public String getPictureUsedMessage() {
		return pictureUsedMessage;
	}

	public String getSuccessAddingAddress() {
		return successAddingAddress;
	}
	
	public String getSuccessAddingCreditCard() {
		return successAddingCreditCard;
	}

	public String getSuccessDeletingCreditCard() {
		return successDeletingCreditCard;
	}

	public String getSuccessDeletingAddress() {
		return successDeletingAddress;
	}

	public  String getInsufficientQuantityMessage() {
		return insufficientQuantityMessage;
	}

	public  String getZeroQuantityMessage() {
		return zeroQuantityMessage;
	}
	
	public  String getNoCartMessage() {
		return noCartMessage;
	}
	
	public  String getNotQualifiedForCheckout() {
		return notQualifiedForCheckout;
	}
	
	public  String getInvalidCheckOut() {
		return invalidCheckOut;
	}
	
	public  String getSuccessAddingCartItem() {
		return successAddingCartItem;
	}


	
	public  String getSuccessEditingCartItem() {
		return successEditingCartItem;
	}
	
	public  String getSuccessClearingCart() {
		return successClearingCart;
	}
	
	public  String getSuccessDeletingCartItem() {
		return successDeletingCartItem;
	}
	
	public  String getSuccessCheckout() {
		return successCheckout;
	}

	public  String getInvalidQuantityMessage() {
		return invalidQuantityMessage;
	}
	
	public  String getSuccessAddingStock() {
		return successAddingStock;
	}

	public  String getInvalidUser() {
		return invalidUser;
	}

	public  String getSuccessSignUp() {
		return successSignUp;
	}

	public  String getInvalidUserMessage() {
		return invalidUserMessage;
	}
	
	public  String getInvalidSavingUser() {
		return invalidSavingUser;
	}
	
	public  String getEmailUsedMessage() {
		return emailUsedMessage;
	}
	
	public  String getSuccessAddingAdmin() {
		return successAddingAdmin;
	}
	
	public  String getPasswordNotMatch() {
		return passwordNotMatch;
	}

	public  String getNameUsedErrorMessage() {
		return nameUsedErrorMessage;
	}

	public  String getDeletionErrorMessage() {
		return deletionErrorMessage;
	}

	public  String getSuccessAddingCategory() {
		return successAddingCategory;
	}

	public  String getSuccessEditingCategory() {
		return successEditingCategory;
	}
	
	public  String getSuccessDeletingCategory() {
		return successDeletingCategory;
	}
	
	public  String getProductNameUsedMessage() {
		return productNameUsedMessage;
	}
	
	public  String getInvalidPriceMessage() {
		return invalidPriceMessage;
	}
	
	public  String getSuccessAddingProduct() {
		return successAddingProduct;
	}
	
	public  String getSuccessEditingProduct() {
		return successEditingProduct;
	}
	
	public  String getSuccessDeletingProduct() {
		return successDeletingProduct;
	}	
	
}
