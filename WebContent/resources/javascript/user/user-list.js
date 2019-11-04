(function() {

	"use strict";

    $.get({

        url: contextPath + '/ajax/user',
        dataType: "json",
        success: function(res) {
        	
        	var table = $('#userTable');
        	
        	if (res.length == 0) {
        		table.hide();
                $('.tableEmptyMessage').show();
            } else {
            	
                $.each(res, function(key, value) {
                    table.append(userRow(value));
                });
            }
        },
        error: function(error) {
        	alert("Problem fetching user list");
        }

    });

})();