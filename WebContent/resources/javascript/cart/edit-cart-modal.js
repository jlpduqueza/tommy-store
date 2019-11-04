(function() {

	"use strict";

    $('.cartItem-table').on('click', '.modal-link', function(e) {
        $("#quantityField").val('0');
        var $id = $(this).attr("data-id");

        $.get({
            url: contextPath + '/ajax/edit-cart?id=' + $id,
            dataType: "json",
            success: function(res) {

                $(".modal-body").html(editModalContent(res));
                $("#image").attr("src", contextPath + '/images/' + res.picturePath);

                $("#id").attr('value', res.id);

            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing cart.");
            }
        });
    });

    $('#edit-form').on('click', '#buttonSubmit', function(e) {

        e.preventDefault();
        var modal = $("#edit-cart");

        $.post({
            url: contextPath + '/ajax/edit-cartitem',
            dataType: "json",
            data: $('form[name="edit-cart"]').serialize(),
            success: function(res) {

                if (res.validated) {

                    $("#" + res.data.id).html(res.data.quantity);

                    modal.modal('toggle');

                    showMessage("success", res.customMessage);
                } else {

                    showMessage("danger", res.customMessage);
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem editing cart.");
            }

        })
    });

})();