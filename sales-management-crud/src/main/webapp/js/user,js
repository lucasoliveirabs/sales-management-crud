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
				rangelength: [6, 12],
			},
			confirmedNewPassword: {
				required: true,
				equalTo: "#newPassword",
			},
			firstName: {
				required: true,
				lettersonly: true,
			},
			lastName: {
				required: true,
				lettersonly: true,
			}
		},
		messages: {
			username: {
				required: "Insert your username, please.",
			},
			password: {
				required: "Insert your password, please.",
			},
			newUsername: {
				required: "Empty field.",
				email: "Please, insert a valid e-mail.",
			},
			newPassword: {
				required: "Empty field.",
				rangelength: "Wow! Please, between 6 and 12 characters.",
			},
			confirmedNewPassword: {
				required: "Oops! They are not the same!",
				equalTo: "Oops! They are not the same!",
			},
			firstName: {
				required: "Your first name, please.",
				lettersonly: "Your first name, please.",
			},
			lastName: {
				required: "Your last name, please.",
				lettersonly: "Your last name, please.",
			}
		}
	});
});