(function() {

	"use strict";

    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = window.location.search.substring(1),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
            }
        }
    };

    var $id = getUrlParameter('id');

    $.get({

        url: contextPath + '/ajax/order-item?id=' + $id,
        dataType: "json",
        success: function(res) {
        	
        	var orderTable = $('.orderTable');
        	
            if (res.length == 0) {
            	orderTable.hide();
                $('.tableEmptyMessage').show();
            } else {
                $.each(res, function(key, value) {
                	orderTable.append(orderRow(value));
                });
            }
        },
        error: function(error) {
            console.log(error);
            alert("There's a problem in fetching orders.");
        }

    });

})();