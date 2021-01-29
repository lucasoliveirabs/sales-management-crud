<!DOCTYPE html>

<html>
<head>
<title>New Lead</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<script src="js/add-lead.js" type="text/javascript"></script>

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
				<li><h3>New Lead</h3></li>
			</ul>
		</div>

		<div id="form">
			<form id="mainForm" action="LeadServlet" method="POST">
				<input type="hidden" name="command" value="ADD" />

				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><input type="text" name="leadFirstName" required/></td>
						</tr>

						<tr>
							<td><label>Last name:</label></td>
							<td><input type="text" name="leadLastName" required/></td>
						</tr>
						
						<tr>
							<td><label>Main contact channel:</label></td>
							<td>
							<select name="leadMainChannel" required>
							<option value="E-mail">E-mail</option>
							<option value="Whatsapp">Whatsapp</option>
							<option value="Facebook">Facebook</option>
							<option value="Instagram">Instagram</option></select>
							</td>
						</tr>
						
						<tr>
							<td><label>E-mail:</label></td>
							<td><input type="email" name="leadEmail" required/></td>
						</tr>

						<tr>
							<td><label>Whatsapp number:</label></td>
							<td><input type="text" name="leadWhatsapp" required/>
						</tr>

						<tr>
							<td><label>Facebook reference:</label></td>
							<td><input type="text" name="leadFacebook" required/></td>
						</tr>

						<tr>
							<td><label>Instagram reference:</label></td>
							<td><input type="text" name="leadInstagram" /></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>

							<td><input type="submit" value="Add Lead"
								class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>