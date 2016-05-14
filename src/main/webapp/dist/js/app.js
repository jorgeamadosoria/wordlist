function init() {
	$("button#submit").click(function(e) {
		 var formData = {
		            'length'              : $('select[name=email]').val(),
		            'letters'             : [$('input[name=letters0]').val(),
		                                     $('input[name=letters1]').val(),
		                                     $('input[name=letters2]').val(),
		                                     $('input[name=letters3]').val(),
		                                     $('input[name=letters4]').val(),
		                                     $('input[name=letters5]').val(),
		                                     $('input[name=letters6]').val(),
		                                     $('input[name=letters7]').val(),
		                                     $('input[name=letters8]').val(),
		                                     $('input[name=letters9]').val(),
		                                     $('input[name=letters10]').val(),
		                                     $('input[name=letters11]').val()]
		        };
		 
		$.ajax({
			url : "list",
			method : "GET",
			data:formData,
			success : function(e) {
				for(var w in e)
				$("#list").append(w);
			}
		});
	});

}