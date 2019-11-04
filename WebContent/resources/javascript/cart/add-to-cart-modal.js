(function() {

	"use strict";

    $('.card-container').on('click', '.nav-link', function(e) {

        e.preventDefault();

        $("#quantityField").val('0');
        var $id = $(this).attr("data-id");

        $.get({
            url: contextPath + '/ajax/product?id=' + $id,
            dataType: "json",
            success: function(res) {
                $('#modal-content').html(modalContent(res));
                $('.message').hide();
                $("#image").attr("src", contextPath + '/images/' + res.picturePath);
                $("#id").attr('value', res.id);
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem in adding cart item.");
            }
        });
    });


    $('#add-to-cart-form').on('click', '#buttonSubmit', function(e) {
        e.preventDefault();

        var modal = $("#AddToCart");

        $.post({
            url: contextPath + '/ajax/add-to-cart',
            dataType: "json",
            data: $('form[name="addToCart"]').serialize(),
            success: function(res) {

                if (res.validated) {
                    showMessage("success", res.customMessage);
                    modal.modal('toggle');

                } else {
                    showMessage("danger", res.customMessage);
                    modal.modal('toggle');
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem in adding cart item.");
            }

        })
    });

})();