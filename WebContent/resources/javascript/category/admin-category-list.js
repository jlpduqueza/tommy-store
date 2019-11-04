(function() {

	"use strict";

	var errorMessage = $("#errorMessage");
    $.get({

        url: contextPath + '/ajax/category',
        dataType: "json",
        success: function(res) {
        	
        	var cardContainer = $('.card-container');
        	
            $.each(res, function(key, value) {
            	cardContainer.append(productCardTemplate(value));
            });
        },
        error: function(error) {
            console.log(error);
            alert("There's a problem in fetching categories.");
        }

    });

})();