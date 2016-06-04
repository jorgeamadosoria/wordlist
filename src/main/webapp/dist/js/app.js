function init() {

	$(".filter-panel .filter-letter").keypress(function(e) {
		if (e.which < 97 || e.which > 122) {
			return false;
		}
	});

	$(".letter").keypress(function(e) {
		if (e.which < 97 || e.which > 122) {
			return false;
		}
	});

	$("#list").delegate(".word", "click", function(e) {
		$(this).toggleClass("text-muted");
	});

	$(".filter-panel .filter-letter")
			.keyup(
					function(e) {
						var len = $('select[name=length]').val();
						var filterData = "";
						filterData += ($('input[name=filter0]').val().length == 0) ? "."
								: $('input[name=filter0]').val();
						filterData += ($('input[name=filter1]').val().length == 0) ? "."
								: $('input[name=filter1]').val();
						if (len >= 3)
							filterData += ($('input[name=filter2]').val().length == 0) ? "."
									: $('input[name=filter2]').val();
						if (len >= 4)
							filterData += ($('input[name=filter3]').val().length == 0) ? "."
									: $('input[name=filter3]').val();
						if (len >= 5)
							filterData += ($('input[name=filter4]').val().length == 0) ? "."
									: $('input[name=filter4]').val();
						if (len >= 6)
							filterData += ($('input[name=filter5]').val().length == 0) ? "."
									: $('input[name=filter5]').val();
						if (len >= 7)
							filterData += ($('input[name=filter6]').val().length == 0) ? "."
									: $('input[name=filter6]').val();
						if (len >= 8)
							filterData += ($('input[name=filter7]').val().length == 0) ? "."
									: $('input[name=filter7]').val();
						if (len >= 9)
							filterData += ($('input[name=filter8]').val().length == 0) ? "."
									: $('input[name=filter8]').val();
						if (len >= 10)
							filterData += ($('input[name=filter9]').val().length == 0) ? "."
									: $('input[name=filter9]').val();
						if (len >= 11)
							filterData += ($('input[name=filter10]').val().length == 0) ? "."
									: $('input[name=filter10]').val();
						if (len >= 12)
							filterData += ($('input[name=filter11]').val().length == 0) ? "."
									: $('input[name=filter11]').val();

						$("#list .word").hide().each(function(e) {
							if ($(this).text().match(filterData) != null) {
								$(this).show();
							}
						});
					});

	$("button#submit").click(
			function(e) {
				var formData = {
					'length' : $('select[name=length]').val(),
					'letters0' : $('input[name=letters0]').val(),
					'letters1' : $('input[name=letters1]').val(),
					'letters2' : $('input[name=letters2]').val(),
					'letters3' : $('input[name=letters3]').val(),
					'letters4' : $('input[name=letters4]').val(),
					'letters5' : $('input[name=letters5]').val(),
					'letters6' : $('input[name=letters6]').val(),
					'letters7' : $('input[name=letters7]').val(),
					'letters8' : $('input[name=letters8]').val(),
					'letters9' : $('input[name=letters9]').val(),
					'letters10' : $('input[name=letters10]').val(),
					'letters11' : $('input[name=letters11]').val()
				};

				if ($('input[name=letters11]').val().length != 0 && 
				$('input[name=letters1').val().length != 0 &&
				$('input[name=letters2').val().length != 0 &&
				$('input[name=letters3').val().length != 0 &&
				$('input[name=letters4').val().length != 0 &&
				$('input[name=letters5').val().length != 0 &&
				$('input[name=letters6').val().length != 0 &&
				$('input[name=letters7').val().length != 0 &&
				$('input[name=letters8').val().length != 0 &&
				$('input[name=letters9').val().length != 0 &&
				$('input[name=letters10').val().length != 0) {

					$.ajax({
						url : "/list",
						method : "POST",
						data : formData,
						beforeSend : function(e) {
							$("i#bsearch").removeClass("fa-search").addClass(
									"fa-spin fa-spinner");
						},
						success : function(e) {
							$("#list").empty();
							var len = $('select[name=length]').val();
							$("#flogo").show();
							$(".filter-panel .filter-letter").val("").hide()
									.each(function(e) {
										if ($(this).data("pos") < len)
											$(this).show();
									});

							for (var i = 0; i < e.length; i++) {
								var word = $("#wtemplate").clone().removeClass(
										"hidden").text(e[i]);

								$("#list").append(word);
							}
						},
						complete : function(e) {
							$("i#bsearch").removeClass("fa-spinner")
									.removeClass("fa-spin").addClass(
											"fa-search");
						}
					});
				}
			});

}