(function(e) {

	"use strict";

	var errorMessage = $("#errorMessage");
	
    $.get({
        url: contextPath + '/ajax/category',
        dataType: "json",
        success: function(res) {

        	var categoryTable = $('#categoryTable');
        	
            if (res.length == 0) {
            	categoryTable.hide();
                $('.tableEmptyMessage').show();
            } else {
                $.each(res, function(key, value) {
                	categoryTable.append(categoryTemplate(value));
                });
            }

        },
        error: function(error) {
            console.log(error);
            alert("There's a problem fetching categories.");
        }

    })

})();