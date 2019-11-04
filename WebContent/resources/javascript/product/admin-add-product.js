(function(e) {

	"use strict";
    var errorMessage = $("#errorMessage");

    $(".add-product-li").on('click', '.add-product-link', function() {
    	
    	GlobalUtil.clearErrorField();

        $.get({
            url: contextPath + '/ajax/category',
            dataType: "json",
            success: function(res) {
                $('.product-input').html(addProductInput());

                var categorySelect = $('.category-select');
                
                $.each(res, function(key, value) {
                	categorySelect.append('<option value=' + value.id + '>' + value.name + '</option>');
                	categorySelect.attr("id", value.id);
                });
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem adding a product.");
            }

        })
    });

    errorMessage.fadeOut();

    $('#addProduct').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();
        
        $('.addSuccessMessage').hide();

        var modal = $("#addProduct");

        input.next().remove();

        var form = $('#add_form')[0];
        var data = new FormData(form);
        
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            data: data,
            dataType: "json",
            contentType: false,
            processData: false,
            cache: false,
            url: contextPath + '/ajax/add-product',
            success: function(res) {

                if (res.validated) {
                	errorMessage.toggle();
                    modal.modal('toggle');

                    input.val('');
                    input.next().remove();
                    $('#productTable').append(adminProductRow(res.data));

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
                alert("There's a problem adding a product.");
            }

        })
    });

})();