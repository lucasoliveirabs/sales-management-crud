<!DOCTYPE html>

<html>
<head>
<title>New Sale</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#mainForm").validate({
			rules:{
				productId: {
					required: true,
					number: true
				},
				leadId: {
					required: true,
					number: true
				},
				saleDate:{
					required: true
				},
				deliveryDate:{
					required: true
				},
				deliveryAddress:{
					required: true
				}
			},
			messages:{
				productId:{
					required: "In doubt? Check out our products list!",  
					number: "Oh! It has to be a number!"
				},
				leadId:{
					required: "In doubt? Check out our leads list!",
					number: "Oh! It has to be a number!"
				},
				saleDate:{
					required: "When did we sold it?"
				},
				deliveryDate:{
					required: "When are we going to deliver it?"
				},
				deliveryAddress:{
					required: "Where are we we going to deliver it?"
				},
			}
		});
	});
</script>
</head>

<body>

	<div class="header">
		<nav>
			<ul>
				<li><a href="SaleServlet">Sales</a></li>
				<li><a href="#">Products</a></li>
				<li><a href="#">Leads</a></li>
			</ul>
		</nav>
	</div>

	<div id="container">

		<div id="h3-list">
			<ul>
				<li><h3>New Sale</h3></li>
			</ul>
		</div>

		<div id="form">
			<form name="mainForm" id="mainForm" action="SaleServlet" method="GET">
				<input type="hidden" name="command" value="ADD" />

				<table>
					<tbody>
						<tr>
							<td><label>Product id:</label></td>
							<td><input type="text" name="productId" /></td>
						</tr>

						<tr>
							<td><label>Lead id:</label></td>
							<td><input type="text" name="leadId" /></td>
						</tr>

						<tr>
							<td><label>Sale date:</label></td>
							<td><input type="datetime-local" name="saleDate" />
						</tr>

						<tr>
							<td><label>Delivery date:</label></td>
							<td><input type="datetime-local" name="deliveryDate" />
						</tr>

						<tr>
							<td><label>Delivery address:</label></td>
							<td><input type="text" name="deliveryAddress" /></td>
						</tr>

						<tr>
							<td><label>Observation:</label></td>
							<td><input type="text" name="observation" /></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>

							<td><input type="submit" value="Add Sale" id="add" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>