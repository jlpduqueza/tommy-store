(function() {

	"use strict";

	var errorMessage = $("#errorMessage");
	var mySelect;

    var modal = $("#editProduct");
	
	errorMessage.toggle();
	input.next().remove();
    $(".edit-new-category").on('click', '.nav-link', function() {

        GlobalUtil.clearErrorField();

    });

    $("#productTable").on('click', '.edit-product-link', function(e) {
    	
        e.preventDefault();
        
        input.val('');
        input.next().remove();
        
        var $id = $(this).attr("data-id");

        $.get({
            url: contextPath + '/ajax/product/editView?id=' + $id,
            dataType: "json",
            success: function(res) {
            	mySelect = res.categoryId;

                $("#edit-body").html(editProductInput(res));
                $("#id").attr('value', res.id);
                errorMessage.fadeOut();
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing a product.");
            }

        });
        
        $.get({
            url: contextPath + '/ajax/category',
            dataType: "json",
            success: function(res) {

                var categorySelect = $('.category-select');
                
                $.each(res, function(key, value) {
                	categorySelect.append('<option value=' + value.id + '>' + value.name + '</option>');
                	categorySelect.attr("id", value.id);
                });
                
                categorySelect.val(mySelect);

                modal.modal('toggle');
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing a product.");
            }


        })
        
    });

    errorMessage.fadeOut();

    $('#editProduct').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();
        
        alert("editting");
        
        $('.editSuccessMessage').hide();

        input.next().remove();

        var form = $('#edit_form')[0];
        var data = new FormData(form);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            dataType: "json",
            data: data,
            contentType: false,
            processData: false,
            cache: false,
            url: contextPath + '/ajax/edit-product',
            success: function(res) {

                if (res.validated) {
                	errorMessage.toggle();
                    modal.modal('toggle');

                    input.val('');
                    input.next().remove();
                    $('#tr'+res.data.id).replaceWith(adminProductRow(res.data));

                    showMessage("success", res.customMessage);
                    alert(res.customMessage);

                } else {
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });

                    alert(res.customMessage);
                    
                    errorMessage.html(res.customMessage);
                    errorMessage.fadeIn();

                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing a product.");
            }

        })
    });

})();