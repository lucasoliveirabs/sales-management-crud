<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<title>Products</title>
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
				<input type="button" value="New Product" id="new-sale"
					onclick="window.location.href='add-product.jsp'" />
			</div>

			<table>
				<tr>
					<th>Product Id</th>
					<th>Product Department</th>
					<th>Product Class</th>
					<th>Product Name</th>
					<th>Action</th>
				</tr>

				<c:forEach var="p" items="${productList}">

					<c:url var="productUpdate" value="ProductServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="productId" value="${p.productId}" />
					</c:url>

					<tr>
						<td>${p.productId}</td>
						<td>${p.productDepartment}</td>
						<td>${p.productClass}</td>
						<td>${p.productName}</td>
						<td><a href="${productUpdate}" id="update-button">Update</a> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>