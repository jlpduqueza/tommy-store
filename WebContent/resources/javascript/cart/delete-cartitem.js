(function() {

	"use strict";
	
    $('.cartItem-table').on('click', '.delete-link', function(e) {

        e.preventDefault();

        var $id = $(this).attr("id");
        var $row = "#tr" + $id;

        $.get({
            url: contextPath + '/ajax/delete-cartitem?id=' + $id,
            dataType: "json",
            success: function(res) {

                if (!res.validated) {
                    window.location.href = contextPath + "/user" + res.location;
                } else {
                    showMessage("success", res.customMessage);
                    $($row).remove();
                }

            },
            error: function(error) {
                console.log(error);
                alert("There's a problem deleting cart item.");
            }

        });
    });


})();