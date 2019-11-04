(function() {

	"use strict";
	
    $('#creditCardTable').on('click', '.delete-credit-card-link', function(e) {

        e.preventDefault();

        var $id = $(this).attr("id");
        var $row = "#tr" + $id;

        $.get({
            url: contextPath + '/ajax/delete-credit-card?id=' + $id,
            dataType: "json",
            success: function(res) {

                $($row).remove();
                showMessage("success", res.customMessage);
            },
            error: function(error) {

                showMessage("danger", res.customMessage);
                console.log(error);
                alert("There's a problem deleting credit card.");
            }

        });
    });


})();