$ = jQuery;
$(document).ready(function() {
	hideFilters();
	
	$(document).on("click", ".filter", function() {
		if ($(this).hasClass('active')) {
			$(this).removeClass('active');
			$('.ui-column-filter').hide();
		} else {
			$(this).addClass('active');
			$('.ui-column-filter').show();
		}
	});
});

function hideDialogOnSuccess(args, dialogWidgetVar) {
	if (args && !args.validationFailed) {
		dialogWidgetVar.hide();
	}
	
	hideFilters();
}

function hideFilters() {
	$('.ui-column-filter').hide();
	
	if ($('.filter').hasClass('active')) {
		$('.filter').removeClass('active');
	}
}

