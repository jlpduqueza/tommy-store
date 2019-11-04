(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/productlist',
        dataType: "json",
        success: function(res) {
        	
        	var container = $('.card-container');
        	
            $.each(res, function(key, value) {
            	container.append(productCardTemplate(value));
            });
        },
        error: function(error) {
            console.log(error);
            alert("There's a problem in fetching products.");
        }

    });

})();