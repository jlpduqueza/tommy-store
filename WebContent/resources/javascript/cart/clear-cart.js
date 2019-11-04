(function() {

	"use strict";

    $('#clear-form').on('click', '.clear-link', function(e) {

        e.preventDefault();

        $.get({
            url: contextPath + '/ajax/clear-cart',
            dataType: "json",
            success: function(res) {
                window.location.href = contextPath + "/user" + res.location;
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem in clearing cart.");
            }

        });
    });


})();