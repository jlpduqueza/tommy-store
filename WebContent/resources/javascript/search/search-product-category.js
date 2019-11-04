(function() {

	"use strict";

	$('.category-container').on('click', '.search-category', function(e) {
        e.preventDefault();

        var categoryName = $(this).attr("data-category-name");

        $.post({
            url: contextPath + '/ajax/search-category?name=' + categoryName,
            dataType: "json",
            success: function(res) {

            	var container = $('.card-container');
            	container.html("");

                $.each(res, function(key, value) {
                	container.append(productCardTemplate(value));
                });
            },
            error: function(error) {
                console.log(error);
                alert("There's a problem searching a product.");
            }

        })
    });

})();