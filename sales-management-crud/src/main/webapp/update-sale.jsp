<!DOCTYPE html>

<html>
<head>
<title>Update Sale</title>

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
			</ul>
		</nav>
	</div>

	<div id="container">

		<div id="h3-list">
			<ul>
				<li><h3>Update Sale</h3></li>
			</ul>
		</div>

		<div id="form">
			<form action="SaleServlet" method="GET">
				<input type="hidden" name="command" value="UPDATE" />

				<table>
					<tbody>
						<tr>
							<td><label>Sale id:</label></td>
							<td><label style="text-align: left;">${sale.saleId}</label>
								<input type="hidden" name="saleId" value="${sale.saleId}"></td>

						</tr>
						<tr>
							<td><label>Product id:</label></td>
							<td><input type="text" name="productId"
								value="${sale.productId}" /></td>

						</tr>

						<tr>
							<td><label>Lead id:</label></td>
							<td><input type="text" name="leadId" value="${sale.leadId}" /></td>
						</tr>

						<tr>
							<td><label>Sale date:</label></td>
							<td><input type="datetime-local" name="saleDate"
								value="${saleDate}" />
						</tr>

						<tr>
							<td><label>Delivery date:</label></td>
							<td><input type="datetime-local" name="deliveryDate"
								value="${deliveryDate}" />
						</tr>

						<tr>
							<td><label>Delivery address:</label></td>
							<td><input type="text" name="deliveryAddress"
								value="${sale.saleDeliveryAddress}" /></td>
						</tr>

						<tr>
							<td><label>Observation:</label></td>
							<td><input type="text" name="observation"
								value="${sale.saleObs}" /></td>
						</tr>

						<td><label>Status:</label></td>
						<td class="status"><input type="radio" name="status"
							value="D" ${sale.saleStatus == 'D' ? 'checked' : ''}>Delivered
							<input type="radio" name="status" value="N"
							${sale.saleStatus == 'N' ? 'checked' : ''}>Not delivered</td>

						<tr>
							<td><label>Cancel date:</label></td>
							<td><input type="datetime-local" name="cancelDate"
								value="${cancelDate}" />
						</tr>

						<tr>
							<td><label>Cancel reason:</label></td>
							<td><input type="text" name="cancelReason"
								value="${sale.saleCancelReason}" /></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Update Sale" class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>