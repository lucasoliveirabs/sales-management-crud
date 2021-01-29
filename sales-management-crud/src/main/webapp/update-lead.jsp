<!DOCTYPE html>

<html>
<head>
<title>Update Lead</title>

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
				<li><h3>Update Lead</h3></li>
			</ul>
		</div>

		<div id="form">
			<form action="LeadServlet" method="POST">
				<input type="hidden" name="command" value="UPDATE" />

				<table>
					<tbody>
						<tr>
							<td><label>Lead id:</label></td>
							<td><label style="text-align: left;">${lead.leadId}</label>
								<input type="hidden" name="leadId" value="${lead.leadId}"></td>
						</tr>
						
						<tr>
							<td><label>First name:</label></td>
							<td><input type="text" name="leadFirstName"
								value="${lead.leadFirstName}" required/></td>
						</tr>

						<tr>
							<td><label>Last name:</label></td>
							<td><input type="text" name="leadLastName" value="${lead.leadLastName}" required/></td>
						</tr>

						<tr>
							<td><label>Main contact channel:</label></td>
							<td><input type="datetime-local" name="leadMainChannel"
								value="${lead.leadMainChannel}" required/>
						</tr>

						<tr>
							<td><label>Whatsapp:</label></td>
							<td><input type="datetime-local" name="leadWhatsapp"
								value="${lead.leadWhatsapp}" required/>
						</tr>

						<tr>
							<td><label>Facebook:</label></td>
							<td><input type="text" name="leadFacebook"
								value="${lead.leadFacebook}" required/></td>
						</tr>

						<tr>
							<td><label>Instagram:</label></td>
							<td><input type="text" name="leadInstagram"
								value="${lead.leadInstagram}" /></td>
						</tr>
						
						<tr>
							<td><label>E-mail:</label></td>
							<td><input type="datetime-local" name="leadEmail"
								value="${lead.leadEmail}" />
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Update Lead"
								class="submit-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>