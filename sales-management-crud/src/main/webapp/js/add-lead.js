$(document).ready(function() {
	$("#mainForm").validate({
		rules: {
			leadFirstName: {
				required: true
			},
			leadLastName: {
				required: true
			},
			leadMainChannel: {
				required: true
			},
			leadWhatsapp: {
				required: true,
				number: true
			},
			leadEmail: {
				required: true,
				email: true
			},
			leadFacebook: {
				required: true
			},
			leadInstagram: {
				required: true
			}
		},
		messages: {
			leadFirstName: {
				required: "Please, insert lead's first name."
			},
			leadLastName: {
				required: "Please, insert lead's last name."
			},
			leadMainChannel: {
				required: "Where does he/she prefer to keep in touch?"
			},
			leadWhatsapp: {
				required: "Please, insert a valid phone number.",
				number: "It has to be a number."
			},
			leadEmail: {
				required: "Please, insert a valid e-mail.",
				email: "It has to be an e-mail."
			},
			leadFacebook: {
				required: "Please, insert lead's facebook reference."
			},
			leadInstagram: {
				required: "Please, insert lead's instagram reference."
			}
		}
	});
});