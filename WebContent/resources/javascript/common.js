$message = $('.customMessage');
$message.hide();

var input = $('input');
var contextPath = $(document.body).attr("data-context-path");
function showMessage(type, message){
	$message.attr("class", "alert alert-"+type +" customMessage").show().html(message);
}

var GlobalUtil = {	
	
	clearErrorField: function() { 
    	input.val('');
    	input.next().remove();
	}
}
