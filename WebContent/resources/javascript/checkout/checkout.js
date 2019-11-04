(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/cart',
        dataType: "json",
        success: function(res) {
            $.each(res, function(key, value) {
                $('.cartItem-table').append(cartRow(value));
            });
        },
        error: function(error) {
            console.log(error);
        }

    });

    $.get({
        url: contextPath + '/ajax/creditCard',
        dataType: "json",
        success: function(res) {

        	var creditCardTable = $('.creditcard-option');
        	
            $.each(res, function(key, value) {
            	creditCardTable.append(creditCards(value));
            });
        },
        error: function(error) {
            console.log(error);
        }

    })

    $.get({
        url: contextPath + '/ajax/shippingAddress',
        dataType: "json",
        success: function(res) {
        	
        	var shippingAddressSelection = $('.shippingaddress-option');
        	
            $.each(res, function(key, value) {
            	shippingAddressSelection.append(shippingAddresses(value));
            });
        },
        error: function(error) {
            console.log(error);
        }

    })

})();