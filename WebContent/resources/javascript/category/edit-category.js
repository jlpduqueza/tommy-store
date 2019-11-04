(function() {

	"use strict";
	
	var errorMessage = $("#errorMessage");
	
	errorMessage.toggle();
	input.next().remove();
    $(".edit-new-category").on('click', '.nav-link', function() {

    	input.val('');
    	input.next().remove();

    });

    $('#categoryTable').on('click', '.modal-edit-category', function(e) {
        var $id = $(this).attr("data-id");

        $.get({
            url: contextPath + '/ajax/category/editView?id=' + $id,
            dataType: "json",
            dataType: "json",
            success: function(res) {

                $(".modal-body").html(editCategoryInput(res));
                $("#id").attr('value', res.id);
                errorMessage.fadeOut();

            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing category.");
            }

        });
    });

    $('#buttonEditSubmit').click(function(e) {

        e.preventDefault();

        $('.editSuccessMessage').hide();
        var modal = $("#editCategory");

        $.post({
            url: contextPath + '/ajax/category/edit-category',
            dataType: "json",
            data: $('form[name="editCategory"]').serialize(),
            success: function(res) {

                if (res.validated) {
                	errorMessage.fadeOut();
                    modal.modal('toggle');
                    console.log("valid");

                    $('#nameField' + res.data.id).html(res.data.name);

                    showMessage("success", res.customMessage);
                } else {
                    $('input').next().remove();
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing category.");
            }

        })
    });

})();