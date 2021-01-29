$(document).ready(function() {
	$("#mainForm").validate({
		rules: {
			productDepartment: {
				required: true
			},
			productClass: {
				required: true
			},
			productName: {
				required: true
			}
		},
		messages: {
			productDepartment: {
				required: "Please, insert product's department."
			},
			productClass: {
				required: "Please, insert product's class."
			},
			productName: {
				required: "Please, insert product's name."
			}
		}
	});
});