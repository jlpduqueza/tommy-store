(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/productlist',
        dataType: "json",
        success: function(res) {

        	var productTable = $('#productTable');
        	
            if (res.length == 0) {
            	productTable.hide();
                $('.tableEmptyMessage').show();
            } else {
                $.each(res, function(key, value) {
                	productTable.append(adminProductRow(value));
                });
            }

        },
        error: function(error) {
            console.log(error);
            alert("There's a problem in fetching products.");
        }

    });

})();