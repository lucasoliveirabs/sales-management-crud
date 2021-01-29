<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>Leads</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
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
		<div class="logout">
			<form name="userLogout" id="userLogout" action="User" method="POST">
				<input type="submit" value="Logout" id="logout-button" /> <input
					type="hidden" name="command" value="LOGOUT" />
			</form>
		</div>
	</div>

	<div class="container">
		<div id="content">

			<div>
				<input type="button" value="New Lead" id="new-sale"
					onclick="window.location.href='add-lead.jsp'" />
			</div>

			<table>
				<tr>
					<th>Lead Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Main contact channel</th>
					<th>Whatsapp</th>
					<th>Facebook</th>
					<th>Instagram</th>					
					<th>E-mail</th>
					<th>Action</th>
				</tr>

				<c:forEach var="l" items="${leadsList}">

					<c:url var="leadUpdate" value="LeadServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="leadId" value="${l.leadId}" />
					</c:url>

					<tr>
						<td>${l.leadId}</td>
						<td>${l.leadFirstName}</td>
						<td>${l.leadLastName}</td>
						<td>${l.leadMainChannel}</td>
						<td>${l.leadWhatsapp}</td>
						<td>${l.leadFacebook}</td>
						<td>${l.leadInstagram}</td>
						<td>${l.leadEmail}</td>
						<td><a href="${leadUpdate}" id="update-button">Update</a> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>