(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/cart',
        dataType: "json",
        success: function(res) {
        	
        	var cartItemTable = $('.cartItem-table');
        	var tableFoot = $('.table-foot');
        	
            $.each(res, function(key, value) {
            	cartItemTable.append(cartRow(value));
            	tableFoot.append(cartTableFoot(value));
            });
        },
        error: function(error) {
            console.log(error);
            alert("There's a problem in fetching cart items.");
        }

    });

})();