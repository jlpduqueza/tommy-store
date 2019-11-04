(function(e) {
	"use strict";

	var errorMessage = $("#errorMessage2");
	
    $("credit-card-modal").on('click', '.nav-link', function() {

    	GlobalUtil.clearErrorField();

    });

    errorMessage.fadeOut();

    $('#add-credit-card-form').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();

        var modal = $("#add-credit-card");

        input.next().remove();

        $.post({
            url: contextPath + '/ajax/add-credit-card',
            data: $('form[name="add-credit-card-form"]').serialize(),
            dataType: "json",
            success: function(res) {

                if (res.validated) {
                	errorMessage.toggle();
                    modal.modal('toggle');

                    input.val('');
                    input.next().remove();
                    $('#creditCardTable').append(creditCardRow(res.data));

                    showMessage("success", res.customMessage);

                } else {
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });

                    errorMessage.html(res.customMessage);
                    errorMessage.fadeIn();

                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem adding credit card.");
            }

        })
    });

})();