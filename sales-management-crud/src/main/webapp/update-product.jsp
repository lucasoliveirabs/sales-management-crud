<!DOCTYPE html>

<html>
<head>
<title>Update Product</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<script src="js/add-sale.js" type="text/javascript"></script>

</head>

<body>

	<div class="header">
		<nav>
			<ul>
				<li><a href="SaleServlet">Sales</a></li>
				<li><a href="ProductServlet">Products</a></li>
				<li><a href="LeadServlet">Leads</a></li>
				<li><a href="update-user.jsp">Edit profile</a></li>
			</ul>
		</nav>
	</div>

	<div id="container">

		<div id="h3-list">
			<ul>
				<li><h3>Update Product</h3></li>
			</ul>
		</div>

		<div id="form">
			<form action="ProductServlet" method="POST">
				<input type="hidden" name="command" value="UPDATE" />

				<table>
					<tbody>
						<tr>
							<td><label>Product id:</label></td>
							<td><label style="text-align: left;">${product.productId}</label>
								<input type="hidden" name="productId" value="${product.productId}"></td>
						</tr>
						
						<tr>
							<td><label>Product department:</label></td>
							<td><input type="text" name="productDepartment"
								value="${product.productDepartment}" required/></td>
						</tr>
						
						<tr>
							<td><label>Product class:</label></td>
							<td><input type="text" name="productClass"
								value="${product.productClass}" required/></td>
						</tr>

						<tr>
							<td><label>Product name:</label></td>
							<td><input type="text" name="productName" value="${product.productName}" required/></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Update Product"
								class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>