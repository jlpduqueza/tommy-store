var Category = Backbone.Model.extend({
    defaults: {
        ID: "",
        CategoryName: ""
    },
    idAttribute: "categoryId",
    initialize: function () {
        console.log('Category has been initialized');
        this.on("invalid", function (model, error) {
            console.log("Houston, we have a problem: " + error)
        });
    },
    constructor: function (attributes, options) {
        console.log('Category\'s constructor had been called');
        Backbone.Model.apply(this, arguments);
    },
    validate: function (attr) {
        if (!attr.CategoryName) {
            return "Invalid CategoryName supplied."
        }
    },
    urlRoot: 'http://localhost:51377/api/Categories'
});
