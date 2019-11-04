(function() {

	"use strict";

    $('#productTable').on('click', '.delete-link', function(e) {

        e.preventDefault();

        var $id = $(this).attr("id");
        var $row = "#tr" + $id;

        $.get({
            url: contextPath + '/ajax/delete-product?id=' + $id,
            dataType: "json",
            success: function(res) {

                if (!res.validated) {
                    $('#errorMessage').html(res.customMessage);
                    showMessage("danger", res.customMessage);
                } else {
                    $($row).remove();
                    showMessage("sucess", res.customMessage);
                }
            },
            error: function(error) {

                console.log(error);
                alert("There's a problem deleting a product.");
            }

        });
    });

})();