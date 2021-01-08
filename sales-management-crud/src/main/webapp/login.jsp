<!DOCTYPE html>

<html>
<head>
<title>Login</title>

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
			<form name="mainForm" action="User" method="POST">
				<input type="hidden" name="command" value="LOGIN" />

				<table id="login">
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
							<td><label>E-mail address:</label></td>
							<td><input type="text" name="username" /></td>
						</tr>

						<tr>
							<td><label>Password:</label></td>
							<td><input type="password" name="password" /></td>
						</tr>

						<tr class="blank-row">
							<td colspan="2" height="10px"></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="Login"
								id="login-button" /></td>
						</tr>

						<tr>
							<td colspan="2"><a href="add-user.jsp">Create an account</a></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>

</body>
</html>