(function() {
	
	"use strict";
	
	var errorMessage = $("#errorMessage");
	
	errorMessage.toggle();
	input.next().remove();
	
    $(".add-new-category").on('click', '.nav-link', function() {
    	
    	GlobalUtil.clearErrorField();

    });
    
    $('#buttonSubmit').click(function(e) {

        e.preventDefault();

        var modal = $("#addCategory");

        $.post({
            url: contextPath + '/ajax/category/add-category',
            dataType: "json",
            data: $('form[name="addCategory"]').serialize(),
            success: function(res) {
                console.log("getting here");
                if (res.validated) {
                	errorMessage.fadeOut();
                    modal.modal('toggle');

                    showMessage("success", res.customMessage);
                    $('#categoryTable').append(categoryTemplate(res.data));

                } else {
                	input.next().remove();
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem adding category.");
            }

        })
    });
    $(document).on('click', '.delete', function(e) {
        e.preventDefault();

        var id = $(this).attr("id");

        $.get({
            url: contextPath + '/ajax/category/delete-category?id=' + id,
            dataType: "json",
            success: function(res) {
            	var $row = "#tr" + id;
                console.log("getting here");

                if (res.validated) {
                	$($row).remove();
                    showMessage("success", res.customMessage);
                } else {
                    showMessage("danger", res.customMessage);
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem deleting category.");
            }

        })
    });

})();