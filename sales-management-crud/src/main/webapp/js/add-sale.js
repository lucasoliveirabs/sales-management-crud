$(document).ready(function() {
	$("#mainForm").validate({
		rules: {
			productId: {
				required: true,
				number: true
			},
			leadId: {
				required: true,
				number: true
			},
			saleDate: {
				required: true
			},
			deliveryDate: {
				required: true
			},
			deliveryAddress: {
				required: true
			}
		},
		messages: {
			productId: {
				required: "In doubt? Check out our products list!",
				number: "Oh! It has to be a number!"
			},
			leadId: {
				required: "In doubt? Check out our leads list!",
				number: "Oh! It has to be a number!"
			},
			saleDate: {
				required: "When did we sold it?"
			},
			deliveryDate: {
				required: "When are we going to deliver it?"
			},
			deliveryAddress: {
				required: "Where are we we going to deliver it?"
			},
		}
	});
});