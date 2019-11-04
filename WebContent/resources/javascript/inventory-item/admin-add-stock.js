(function(e) {

	"use strict";

    var errorMessage = $("#errorMessage");

    $('#inventoryItemTable').on('click', '.modal-add-stock', function(e) {
        var $id = $(this).attr("data-id");

        $.get({
            url: contextPath + '/ajax/inventory-item/edit?id=' + $id,
            dataType: "json",
            success: function(res) {

                $(".modal-body").html(addStockModalBody(res));
                $(".modal-footer").html(addStockModalFoot(res));
                $("#id").attr('value', res.id);

                errorMessage.fadeOut();

            },
            error: function(error) {
                console.log(error);
                alert("There's a problem adding stock.");
            }

        });
    });

    $('#add-stock-form').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();

        var modal = $("#add-stock");

        $.post({
            url: contextPath + '/ajax/inventory-item/add-stock',
            dataType: "json",
            data: $('form[name="add-stock-form"]').serialize(),
            success: function(res) {

                if (res.validated) {
                	errorMessage.toggle();
                    modal.modal('toggle');
                    $('#td' + res.data.id).html(res.data.quantity);

                    showMessage("success", res.customMessage);

                } else {
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });

                    showMessage("danger", res.customMessage);

                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem in adding stock");
            }

        })
    });

})();