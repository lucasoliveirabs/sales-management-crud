<!DOCTYPE html>

<html>
<head>
<title>Create User</title>

<link rel="stylesheet" type="text/css" href="css/login-style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery/3.5.0/jquery.min.js"> type="text/javascript"></script> -->
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.js"
	type="text/javascript"></script>
<!-- <script src="/webjars/jquery-validation/1.19.0/jquery.validation.js"> type="text/javascript"></script> -->
<script src="js/user.js" type="text/javascript"></script>
</head>

<body>

	<div id="container">

		<div id="form">
			<form name="mainForm" id="mainForm" action="User" method="POST">
				<input type="hidden" name="command" value="ADD" />

				<table id="add">
					<tbody>
						<tr>
							<td colspan="2"
								style="background-color: #928E8D; color: #FFFFFF; font-weight: bold;"><label>X
									company</label></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2" height="10px"></td>
						</tr>

						<tr>
							<td><label>Username:</label></td>
							<td><input type="email" name="newUsername" required/></td>
						</tr>

						<tr>
							<td><label>Password:</label></td>
							<td><input type="password" name="newPassword" required/></td>
						</tr>

						<tr>
							<td><label>Confirm password:</label></td>
							<td><input type="password" name="confirmedNewPassword" required/></td>
						</tr>

						<tr>
							<td><label>First name:</label></td>
							<td><input type="text" name="firstName" required/></td>
						</tr>

						<tr>
							<td><label>Last name:</label></td>
							<td><input type="text" name="lastName" required/></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2" height="10px"></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="Create account"/></td>
						</tr>

					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>