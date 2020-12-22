<%@ page import="java.util.*, com.xcompany.model.*"%>
<!DOCTYPE html>

<html>
<head>
<title>Sales</title>
</head>

<%
List<Sale> sales = (List<Sale>) request.getAttribute("salesList");
%>

<body>
<%=sales %>
</body>
</html>
