<!DOCTYPE html>

<html>
<head>
<title>Update User</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/add-sale-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery/3.5.0/jquery.min.js"> type="text/javascript"></script> -->
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery-validation/1.19.0/jquery.validation.js"> type="text/javascript"></script> -->
<script src="js/user.js" type="text/javascript"></script>

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
				<li><h3>Edit profile</h3></li>
			</ul>
		</div>

		<div id="form">
			<form action="User" method="POST">
				<input type="hidden" name="command" value="UPDATE" />

				<table>
					<tbody>
						<tr>
							<td><label>User id:</label></td>
							<td><label style="text-align: left;">${user.userId}</label>
								<input type="hidden" name="userId" value="${user.userId}"></td>
						</tr>
						<tr>
							<td><label>Username:</label></td>
							<td><input type="text" name="newUsername"
								value="${user.userUsername}" required/></td>
						</tr>

						<tr>
							<td><label>Password:</label></td>
							<td><input type="text" name="newPassword"
								value="${user.userPassword}" required/></td>
						</tr>

						<tr>
							<td><label>First name:</label></td>
							<td><input type="text" name="firstName"
								value="${user.userFirstName}" required/></td>
						</tr>

						<tr>
							<td><label>Last name:</label></td>
							<td><input type="text" name="lastName"
								value="${user.userLastName}" required/></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2"></td>
						</tr>

						<tr>
							<td><label></label></td>

							<td><input type="submit" value="Save changes"
								id="login-button" /></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>