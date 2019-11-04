(function() {

	"use strict";

    $('#shippingAddressTable').on('click', '.delete-shipping-address-link', function(e) {

        e.preventDefault();

        var $id = $(this).attr("id");
        var $row = "#tr" + $id;

        $.get({
            url: contextPath + '/ajax/delete-shipping-address?id=' + $id,
            dataType: "json",
            success: function(res) {

                $($row).remove();
                showMessage("success", res.customMessage);
            },
            error: function(error) {

                showMessage("danger", res.customMessage);                
                console.log(error);
                alert("There's a problem deleting shipping address.");
            }

        });
    });


})();