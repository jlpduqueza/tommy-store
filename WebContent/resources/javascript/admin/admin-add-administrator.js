(function() {

	"use strict";

	var errorMessage = $("#errorMessage");
	errorMessage.toggle();

	input.next().remove();
    
    $(".add-admin-form").on('click', '.nav-link', function() {
    	
    	GlobalUtil.clearErrorField();

    });
    
    $('#add-admin-submit').click(function(e) {

        e.preventDefault();
        var modal = $("#addNewAdmin");

        $.post({
            url: contextPath + '/ajax/add-admin',
            dataType: "json",
            data: $('form[name="addNewAdmin"]').serialize(),
            success: function(res) {
                if (res.validated) {
                	errorMessage.fadeOut();
                    modal.modal('toggle');

                    window.showMessage("success", res.customMessage);
                    $('#userTable').append(userRow(res.data));

                } else {
                	input.next().remove();
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem adding new administrator.");
            }

        })
    });

})();