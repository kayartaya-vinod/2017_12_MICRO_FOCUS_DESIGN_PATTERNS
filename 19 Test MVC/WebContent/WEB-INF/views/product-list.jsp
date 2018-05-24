<%@include file="./header.jsp" %>

		<h1 class="alert alert-danger">Products data:</h1>
		<hr>
		<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Discount</th>
			</tr>
		</thead>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.name}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td>${p.discount }</td>
			</tr>
		</c:forEach>
		</table>
<%@include file="./footer.jsp" %>