<%@page import="java.util.List"%>
<%@page import="co.vinod.web.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product list</title>
</head>
<body>
	<div class="container">
		<h1 class="alert alert-info">Here is the list of products</h1>
		<hr>

		<ul class="list-group">
			<%
				List<Product> products = (List<Product>) request.getAttribute("products");
				for (Product p : products) {
			%>
			<li class="list-group-item"><%=p.getName()%>, Rs.<%=p.getPrice()%></li>
			<%
				}
			%>
		</ul>
	</div>
</body>
</html>