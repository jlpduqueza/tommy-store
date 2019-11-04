(function(e) {

	"use strict";
	
    $.get({
        url: contextPath + '/ajax/creditCard',
        dataType: "json",
        success: function(res) {

        	var creditCardTable =  $('#creditCardTable');
        	
            if (res.length == 0) {
                table.hide();
                $('.tableEmptyMessage1').show();
            } else {
                $.each(res, function(key, value) {
                	creditCardTable.append(creditCardRow(value));
                });
            }
        },
        error: function(error) {
            console.log(error);
            alert("Problem fetching credit cards");
        }

    })

    $.get({
        url: contextPath + '/ajax/shippingAddress',
        success: function(res) {
        	var shippingAddressTable = $('#shippingAddressTable');
        	
            if (res.length == 0) {
            	
            	shippingAddressTable.hide();
                $('.tableEmptyMessage2').show();
            } else {
                $.each(res, function(key, value) {
                	shippingAddressTable.append(shippingAddressRow(value));
                });

            }
        },
        error: function(error) {
            console.log(error);
            alert("Problem fetching shipping addresses");
        }

    })

})();