<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<title>Sales</title>
</head>

<body>

	<div class="wrapper">
		<div id="header">
			<h2>Sales</h2>
		</div>

	</div>

	<div class="container">
		<div id="content">
			<table>
				<tr>
					<th>Sale id</th>
					<th>Product id</th>
					<th>Lead id</th>
					<th>Sale date</th>
					<th>Delivery date</th>
					<th>Delivery address</th>
					<th>Observation</th>
					<th>Status</th>
					<th>Cancel date</th>
					<th>Cancel reason</th>
				</tr>

				<c:forEach var="s" items="${salesList}">
					<tr>
						<td>${s.saleId}</td>
						<td>${s.productId}</td>
						<td>${s.leadId}</td>
						<td><fmt:formatDate value="${s.saleDate}"
								pattern="yyyy-MM-dd HH:mm" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${s.saleDeliveryDate}" /></td>
						<td>${s.saleDeliveryAddress}</td>
						<td>${s.saleObs}</td>
						<td>${s.saleStatus}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${s.saleCancelDate}" /></td>
						<td>${s.saleCancelReason}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>

	<footer> </footer>


</body>
</html>
