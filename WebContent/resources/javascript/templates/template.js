var categoryTemplate = _.template(
		'<tr id="tr<%-id%>">'
	+	'<td><%-categoryId%></td>'
	+	'<td id="nameField<%-id%>"><%-name%></td>'
	+	'<td>'
	+			'<a class="btn btn-dark modal-edit-category mt-auto " style="color: white;" data-toggle="modal" data-target="#editCategory" data-id="<%-id%>">'
	+				'Edit'
	+			'</a>'
	+		'<a class="btn btn-dark delete" id=<%-id%> href="delete-category?id=<%-id%>" role="button">Delete</a>'
	+	'</td>'
	+ '</tr>'
);

var productCardTemplate = _.template(
		
			'<div class="card mb-3 mx-2" style="width: 10rem;">'
	+		'<div class="card-body d-flex flex-column" data-cardId="<%-id%>">'
	+			'<img src="/tommystore/images/<%-picturePath%>" class="card-img-top" alt="..." >'
	+			'<b class="card-title"><%-name%></b>'
	+			'<p class="card-text">₱<%-price%></p>'
	+			'Category:'
	+			'<p class="card-text" id="category"><%-category%></p>'
	+			'<a class="nav-link btn btn-dark mt-auto" style="color: white;" data-toggle="modal" data-target="#AddToCart" data-id="<%-id%>">'
	+				'Add To Cart'
	+			'</a>'
	+		'</div>'
	+	'</div>'

);


var cartRow = _.template(
		
   	'<tr id="tr<%-id%>">'
    +	'<td class="align-middle"><img src="/tommystore/images/<%-picturePath%>" height=100px width=100px></td>'
    +	'<td class="align-middle"><%-name%></td>'
	+	'<td class="align-middle"><%-stockStatus%></td>'
	+	'<td class="align-middle"><%-price%></td>'
	+	'<td class="align-middle" id="<%-id%>"><%-quantity%></td>'
	+	'<td class="align-middle"><%-subTotalPrice%></td>'
	+	'<td class="align-middle">'								
	+		'<a class="btn btn-dark modal-link" style="color: white;" data-toggle="modal" data-target="#edit-cart" data-id="<%-id%>">'
	+			'Edit Cart'
	+		'</a>'
	+		'<a class="btn btn-dark delete-link" id="<%-id%>" href="delete-cartitem?id=<%-id%>" role="button">Delete</a>'
	+	'</td>'
	+'</tr>'
		
);


var cartTableFoot = _.template(
		
   	'<tr>'
    +	'<td class="align-middle"><%-totalPrice%></td>'
	+'</tr>'
		
);

var modalContent = _.template(
		
   		'<img id="image" src="<%-picturePath%>" class="card-img-top" alt="..." >'
    +	'<h4 id="productName"><%-name%></h4>'
    +	'<p id="category"><%-category%></p>'
	+	'<p id="price">₱<%-price%></p>'
	+	'<p id="quantity"><%-quantity%></p>'
	+	'<div class="alert alert-danger" style="display:none;" role="alert" id="customMessage"></div>'
	+	'<div class="form-group">'
	+		'<input type="number" class="form-control" id="quantityField" name="quantity" placeholder="quantity" required="required"/>'								
	+	'</div>	'
		
);

var editModalContent = _.template(
		
   		'<img id="image" src="" class="card-img-top" alt="..." >'
    +	'<h4 id="productName"><%-name%></h4>'
    +	'<p id="category"><%-category%></p>'
	+	'<p id="price">₱<%-price%></p>'
	+	'<p id="quantity"><%-stockStatus%></p>'
	+	'<div class="alert alert-danger editFailedMessage" style="display:none;" role="alert"></div>'
	+	'<div class="form-group">'
	+		'<input type="number" class="form-control" value="<%-quantity%>" id="quantityField" name="quantity" placeholder="quantity" required="required"/>'								
	+	'</div>	'
	
);


var userRow = _.template(

	'<tr>'
	+	'<td><%-firstName%></td>'
	+	'<td><%-lastName%></td>'
	+	'<td><%-email%></td>'
	+	'<td><%-contactNumber%></td>'
	+	'<td><%-role%></td>'
	+ '</tr>'
	
);

var creditCardRow = _.template(
		
	  '<tr id="tr<%-id%>">'
	+	'<td><%-cardNumber%></td>'
	+	'<td><%-securityCode%></td>'
	+	'<td>'
	+		'<a class="btn btn-dark delete-credit-card-link" id="<%-id%>" href="delete-credit-card?id=<%-id%>" role="button">Delete</a>'
	+	'</td>'
	+ '</tr>'
	
);

var shippingAddressRow = _.template(
		
	  '<tr id="tr<%-id%>">'
	+	'<td><%-address1%></td>'
	+	'<td><%-address2%></td>'
	+	'<td><%-zipCode%></td>'
	+	'<td><%-country%></td>'
	+	'<td>'
	+		'<a class="btn btn-dark delete-shipping-address-link" id="<%-id%>" href="delete-shipping-address?id=<%-id%>" role="button">Delete</a>'
	+	'</td>'
	+ '</tr>'
	
);

var userRow = _.template(
		
	  '<tr>'
	+	'<td><%-firstName%></td>'
	+	'<td><%-lastName%></td>'
	+	'<td><%-email%></td>'
	+	'<td><%-contactNumber%></td>'
	+	'<td><%-role%></td>'
	+ '</tr>'
	
); 	

var inventoryItemRow = _.template(
		
	  '<tr>'
	+	'<td><%-productName%></td>'
	+	'<td id="td<%-id%>"><%-quantity%></td>'
	+	'<td>'
	+		'<a class="btn btn-dark modal-add-stock" style="color: white;" data-toggle="modal" data-target="#add-stock" data-id="<%-id%>">'
	+			'Add Stock'
	+		'</a>'
	+		'<a class="btn btn-dark" href="stock-history?id=<%-id%>" role="button">Stock History</a>'
	+	'</td>'
	+ '</tr>'
	
); 	

var adminProductRow = _.template(
		
	  '<tr id="tr<%-id%>">'
	+	'<td class="align-middle"><img src="/tommystore/images/<%-picturePath%>" height=100px width=100px></td>'
	+	'<td class="align-middle"><%-id%></td>'
	+	'<td class="align-middle"><%-name%></td>'
	+	'<td class="align-middle"><%-price%></td>'
	+	'<td class="align-middle"><%-category%></td>'
	+	'<td class="align-middle edit-product-td">'
	+		'<a class="btn btn-dark edit-product-link" style="color: white;" data-id="<%-id%>">'	    
	+			'Edit'    
	+		'</a>'  	
	+		'<a class="btn btn-dark delete-link" id="<%-id%>" href="delete-product?id=<%-id%>" role="button">Delete</a>'
	+		'<a class="btn btn-dark" id="<%-id%>" href="product-orders-view?id=<%-id%>" role="button">Orders</a>'
	+	'</td>'
	+ '</tr>'
	
); 	

var shippingAddresses = _.template(
		'<div class="form-check shippingaddress-option">'
	+		'<input type="radio" class="form-check-input" name="shippingAddress.id" id="shippingAddress.id" value="<%-id%>"/>'
    +		'<label class="form-check-label " for="shippingAddress.id">'
    +			'Shipping Address: <%-fullAddress%>'
	+		'</label>'
	+	'<br>'
	+	'</div>'
		  
);

var creditCards = _.template(

	 '<div class="form-check creditcard-option">'
	+	'<input type="radio" class="form-check-input" name="creditCard.id" id="creditcard<%-id%>" value="<%-id%>"/>'
    +	'<label class="form-check-label " for="creditcard<%-id%>">'
    +		'Credit Card: <%-cardNumber%>'
	+	'</label>'
	+	'<br>'
	+'</div>'
			  
);

var editCategoryInput = _.template(

	 '<input type="text" class="form-control" id="name" name="name" placeholder="Category name" required="required" value="<%-name%>"/>'
	+'<input type="hidden" name="id" value="<%-id%>"/>'
		
);

var addProductInput = _.template(

	 '<div class="row">'
	+   '<div class="col-md-10">'
	+      '<div class="form-group">'
	+          '<label>Upload product photo</label>'
	+          '<input type="file" name="picture" />'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Name</label>'                                                                               
	+          '<input type="text" class="form-control" name="name" placeholder="name" required="required"/>'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Price</label>'                                                                                 
	+          '<input type="text" class="form-control" name="price" placeholder="price" required="required"/>'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Category</label>'                          
	+		   '<select class="form-control category-select" name="category.id">'
	+		   '</select>'
	+      '</div>'
	+   '</div>'
	+'</div>'
		
);

var editProductInput = _.template(

	 '<div class="row">'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label>Upload product photo</label>'
	+          '<input type="file" name="picture" value="<%-picturePath%>" />'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Name</label>'                                                                               
	+          '<input type="text" class="form-control" name="name" placeholder="name" required="required" value="<%-name%>"/>'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Price</label>'                                                                                 
	+          '<input type="text" class="form-control" name="price" placeholder="price" required="required" value="<%-price%>"/>'
	+      '</div>'
	+   '</div>'
	+   '<div class="col-md-4">'
	+      '<div class="form-group">'
	+          '<label for="role">Category</label>'                                                                                  
	+          '<input type="hidden" name="id" value="<%-id%>"/>'
	+		   '<select class="form-control category-select" name="category.id" value="<%-categoryId%>">'
	+		   '</select>'
	+      '</div>'
	+   '</div>'
	+'</div>'
		
);
var orderRow = _.template(
		
	  '<tr>'
	+	'<td><%-orderNumber%></td>'
	+	'<td><%-dateOrdered%></td>'
	+	'<td><%-quantityOrdered%></td>'
	+ '</tr>'
	
); 	

var addStockModalBody = _.template(
		
	  '<div class="form-group">'
	+	'<b>Product name: </b>'
	+	'<br>'
	+   '<%-productName%>'
	+	'<br>'
	+	'<b>Quantity: </b>'
	+	'<br>'
	+   '<%-quantity%>'
	+	'<div class="alert alert-danger" style="display:none;" role="alert" id="customMessage"></div>'
	+'</div>'
	+ '<div class="form-group">'
	+ 	'<input type="number" class="form-control" name="quantity" placeholder="Quantity" required="required" value = "0"/>'
	+ '</div>'
	
); 	

var addStockModalFoot = _.template(
		
	  '<div class="form-group">'
	+	'<input type="hidden" class="form-control" name="id" id="id" value="<%-id%>"/>'
	+	'<button type="submit" class="btn btn-dark">Add</button>'
	+'</div>'
	
); 	

var stockHistoryRow = _.template(

	  '<tr>'
	+	'<td><%-productName%></td>'
	+	'<td><%-updatedQuantity%></td>'
	+	'<td><%-modifiedBy%></td>'
	+	'<td><%-dateUpdated%></td>'
	+ '</tr>'
	
); 

var dashboardProductRow = _.template(

	  '<tr>'
	+	'<td class="align-middle"><img src="/tommystore/images/<%-picturePath%>" height=100px width=100px></td>'
	+	'<td class="align-middle"><%-productId%></td>'
	+	'<td class="align-middle"><%-name%></td>'
	+	'<td class="align-middle"><%-price%></td>'
	+	'<td class="align-middle"><%-quantity%></td>'
	+	'<td class="align-middle"><%-dateUpdated%></td>'
	+ '</tr>'
	
); 

var dashboardUserRow = _.template(

	  '<tr>'
	+	'<td><%-firstName%></td>'
	+	'<td><%-lastName%></td>'
	+	'<td><%-email%></td>'
	+	'<td><%-contactNumber%></td>'
	+	'<td><%-role%></td>'
	+ '</tr>'
	
); 

var errorFieldMessage = _.template(

		'<span class="text-danger"><%=value%></span>'
		
	); 


