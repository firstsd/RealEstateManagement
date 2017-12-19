$(document)
		.ready(
				function() {
					$("#owl-example").owlCarousel();
					$('.listing-detail span').tooltip('hide');
					$('.carousel').carousel({
						interval : 3000
					});
					$('.carousel').carousel('cycle');
					$("#addImgBtn")
							.click(
									function() {
										$("div#addImg")
												.append(
														$('<div class="col-lg-7"><input type="file" class="btn btn-link" placeholder="Photo of the property 1" name="upload_image[]" accept="image/*"></div>'))
									})
					setupPurpose();
					setupType();
				});

var setupPurpose = function() {
	if ($("#purpose").val() == "sell") {
		$("#rentFields").hide();
		$("#sellFields").show();
	} else {
		$("#sellFields").hide();
		$("#rentFields").show();
	}
};

var setupType = function() {
	if ($("#type").val() == "house") {
		$("#yards").show();
		$("#floors").hide();
	} else {
		$("#yards").hide();
		$("#floors").show();
	}
};

$(function() {

	var Page = (function() {

		var $nav = $('#nav-dots > span'), slitslider = $('#slider').slitslider(
				{
					onBeforeChange : function(slide, pos) {

						$nav.removeClass('nav-dot-current');
						$nav.eq(pos).addClass('nav-dot-current');

					}
				}),

		init = function() {

			initEvents();

		}, initEvents = function() {

			$nav.each(function(i) {

				$(this).on('click', function(event) {

					var $dot = $(this);

					if (!slitslider.isActive()) {

						$nav.removeClass('nav-dot-current');
						$dot.addClass('nav-dot-current');

					}

					slitslider.jump(i + 1);
					return false;

				});

			});

		};

		return {
			init : init
		};

	})();

	Page.init();
});
