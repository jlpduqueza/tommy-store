(function() {

	"use strict";

    $('.search-list-item').on('click', '#search', function(e) {
        e.preventDefault();

        $.post({
            url: contextPath + '/ajax/search',
            dataType: "json",
            data: $('form[name="searchForm"]').serialize(),
            success: function(res) {
            	
            	var cardContainer = $('.card-container');
            	cardContainer.html("");

                $.each(res, function(key, value) {
                	cardContainer.append(productCardTemplate(value));
                });
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem in searching product.");
            }

        })
    });

})();