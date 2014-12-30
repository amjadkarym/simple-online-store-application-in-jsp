<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<caption>Products</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.type.name}" /></td>
						<td><c:out value="${product.status}" /></td>
						<td><a href="UpdateProductServlet?productId=${product.id}&action=Update">Update</a>
							/ <a href="UpdateProductServlet?productId=${product.id}&action=Delete">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ include file="../layout/footer.jsp"%>