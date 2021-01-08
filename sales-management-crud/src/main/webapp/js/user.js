$(document).ready(function() {
	$("#mainForm").validate({
		rules: {
			username: {
				required: true,
				email: true,
			},
			password: {
				required: true,
			},
			newUsername: {
				required: true,
				email: true,
			},
			newPassword: {
				required: true,
				min: 6,
				max: 12,
				strongPassword: true
			},
			confirmNewPassword: {
				required: true,
				equalTo: "#newPassword"
			},
			firstName: {
				required: true,
				lettersonly: true
			},
			lastName: {
				required: true,
				lettersonly: true
			}
		},
		messages: {
			username: {
				required: "Insert a valid username.",
			},
			password: {
				required: "Insert a valid password.",
			},
			newUsername: {
				required: "Empty field.",
				email: "Insert a valid e-mail.",
			},
			newPassword: {
				required: "Empty field.",
				min: "It must have 6 characters minimal.",
				max: "It must have 12 characters maximum.",
			},
			firstName: {
				required: "Insert your first name.",
			},
			lastName: {
				required: "Insert your last name.",
			}
		}
	});
});