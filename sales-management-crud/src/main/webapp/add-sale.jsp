<!DOCTYPE html>

<html>
<head>
<title>New Sale</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script type="text/javascript">
	function checkSubmit() {
		var inputs = [ document.forms["mainForm"]["productId"].value, document.forms["mainForm"]["leadId"].value, 
			document.forms["mainForm"]["saleDate"].value, document.forms["mainForm"]["deliveryDate"].value,
		document.forms["mainForm"]["deliveryAddress"].value ];  // null 'observation' allowed 
		
		function verifyItem(item) {
			if (item.trim() == ""){
				alert("Except 'Observation', all fields must be filled!");
				return false;
			} else {
				if (i == 0 || i == 1){
					if (isNaN(item)) {
						alert("'Product id' and 'Lead id' must be numbers!");
						return false;
					}
				}
			}
		}
		var bool = inputs.forEach(verifyItem(item, i));
		if (bool = true){
			alert("Sales list successfully updated!");
		}
		return bool;
	}
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
			<form name="mainForm" action="SaleServlet" method="GET"
				onsubmit="return checkSubmit()">
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