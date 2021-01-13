<!DOCTYPE html>

<html>
<head>
<title>New Sale</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery/3.5.0/jquery.min.js"> type="text/javascript"></script> -->
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery-validation/1.19.0/jquery.validation.js"> type="text/javascript"></script> -->
<script src="js/add-sale.js" type="text/javascript"></script>

</head>

<body>

	<div class="header">
		<nav>
			<ul>
				<li><a href="SaleServlet">Sales</a></li>
				<li><a href="#">Products</a></li>
				<li><a href="#">Leads</a></li>
				<li><a href="update-user.jsp">Edit profile</a></li>
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
			<form name="mainForm" id="mainForm" action="SaleServlet" method="POST">
				<input type="hidden" name="command" value="ADD" />

				<table>
					<tbody>
						<tr>
							<td><label>Product id:</label></td>
							<td><input type="text" name="productId" required/></td>
						</tr>

						<tr>
							<td><label>Lead id:</label></td>
							<td><input type="text" name="leadId" required/></td>
						</tr>

						<tr>
							<td><label>Sale date:</label></td>
							<td><input type="datetime-local" name="saleDate" required/>
						</tr>

						<tr>
							<td><label>Delivery date:</label></td>
							<td><input type="datetime-local" name="deliveryDate" required/>
						</tr>

						<tr>
							<td><label>Delivery address:</label></td>
							<td><input type="text" name="deliveryAddress" required/></td>
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

							<td><input type="submit" value="Add Sale"
								class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>