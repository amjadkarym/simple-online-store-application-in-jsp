<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../layout/header.jsp"%>
	<div class="container">
		<h1>WishList</h1>
		<div class="col-lg-12">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-3">
					<div class="thumbnail">
						<!-- 						<img data-src="holder.js/100%x200" alt="100%x200" -->
						<!-- 							src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjkzIiB5PSIxMDAiIHN0eWxlPSJmaWxsOiNBQUFBQUE7Zm9udC13ZWlnaHQ6Ym9sZDtmb250LWZhbWlseTpBcmlhbCwgSGVsdmV0aWNhLCBPcGVuIFNhbnMsIHNhbnMtc2VyaWYsIG1vbm9zcGFjZTtmb250LXNpemU6MTFwdDtkb21pbmFudC1iYXNlbGluZTpjZW50cmFsIj4yNDJ4MjAwPC90ZXh0PjwvZz48L3N2Zz4=" -->
						<!-- 							data-holder-rendered="true" -->
						<!-- 							style="height: 200px; width: 100%; display: block;"> -->
						<div class="caption">
							<h3><c:out value="${product.value.name}" /></h3>
							<hr>
							<p>Product Type: <c:out value="${product.value.type.name}" /> </p>
							<p>
							<hr>
							<a
								href="ViewProductServlet?productId=${product.value.id}&action=View"
								class="btn btn-primary" role="button">View</a> <a
								href="ViewProductServlet?productId=${product.value.id}&action=Update"
								class="btn btn-default" role="button">Update</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>