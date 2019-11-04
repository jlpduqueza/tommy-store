(function() { 
	"use strict";
	
	var errorMessage = $("#errorMessage1");
	
	alert(contextPath);
	
    $(".shipping-address-modal").on('click', '.nav-link', function() {

        errorMessage.fadeOut();
    	GlobalUtil.clearErrorField();

    });

    errorMessage.fadeOut();

    $('#add-shipping-address-form').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();

        var modal = $("#add-shipping-address");

        input.next().remove();

        $.post({
            url: contextPath + '/ajax/add-address',
            data: $('form[name="add-shipping-address-form"]').serialize(),
            dataType: "json",
            success: function(res) {

                if (res.validated) {
                	errorMessage.toggle();
                    modal.modal('toggle');

                    input.val('');
                    input.next().remove();
                    $('#shippingAddressTable').append(shippingAddressRow(res.data));

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
                alert("There's a problem adding shipping address.");
            }

        })
    });

})();