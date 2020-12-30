<!DOCTYPE html>

<html>
<head>
<title>New Sale</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
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
			<form action="SaleServlet" method="GET">
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


						<td><label>Status:</label></td>
						<td class="status"><input type="radio" name="status"
							value="D">Delivered 
							<input type="radio" name="status" value="N">Not delivered</td>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Add Sale" class="add"
								onclick="window.location.href='SaleServlet';return false;" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

	<footer> </footer>

</body>
</html>