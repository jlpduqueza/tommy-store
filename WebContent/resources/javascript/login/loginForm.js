(function () {
	"use strict";

    $('.login-form').on('click', 'button[type=submit]', function(e) {

        e.preventDefault();
        
        input.next().remove();

        $.post({
            url: contextPath + '/ajax/loggingInTest',
            data: $('form[name=loginForm]').serialize(),
            dataType: "json",
            success: function(res) {

                if (res.validated) {
                    window.location.href = res.location;

                } else {
                    $.each(res.errorMessages, function(key, value) {
                        $('input[name=' + key + ']').after(errorFieldMessage({value:value}));
                    });
                    showMessage("danger", res.customMessage);
                }
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem logging in, try again.");
            }
        })
    });
}());
