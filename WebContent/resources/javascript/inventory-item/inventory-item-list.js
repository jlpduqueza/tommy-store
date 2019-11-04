(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/inventory-item',
        dataType: "json",
        success: function(res) {
        	
        	var inventoryTable = $('#inventoryItemTable');
        	
            if (res.length == 0) {
            	inventoryTable.hide();
                $('.tableEmptyMessage').show();
            } else {
                $.each(res, function(key, value) {
                	inventoryTable.append(inventoryItemRow(value));
                });
            }
        },
        error: function(error) {
            console.log(error);
            alert("There's a problem fetching inventory.");
        }

    });

})();