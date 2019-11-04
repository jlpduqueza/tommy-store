(function() {

	"use strict";

    $('.filter-submit').on('click', 'button[type=submit]', function(e) {
        e.preventDefault();
        $.post({
            url: contextPath + '/ajax/filter',
            dataType: "json",
            data: $('form[name="filter-user-form"]').serialize(),
            success: function(res) {

            	var userTable = $('#userTable');
            	
                $('#userTable tbody').empty();
                if (res.length == 0) {
                	userTable.hide();
                    $('.tableEmptyMessage').show();
                } else {
                    $.each(res, function(key, value) {
                    	userTable.append(userRow(value));
                    });

                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem filtering user.");
            }

        })
    });

})();