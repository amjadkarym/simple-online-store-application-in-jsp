<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<h2>View Product: ${product.name}</h2>
	<h3>Type: ${product.type.name}</h3>
	<hr>
	<h1>Similar Products</h1>
	<div class="col-lg-12">
		<c:forEach items="${productList}" var="product">
			<div class="col-md-3">
				<div class="thumbnail">
					<!-- 						<img data-src="holder.js/100%x200" alt="100%x200" -->
					<!-- 							src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjkzIiB5PSIxMDAiIHN0eWxlPSJmaWxsOiNBQUFBQUE7Zm9udC13ZWlnaHQ6Ym9sZDtmb250LWZhbWlseTpBcmlhbCwgSGVsdmV0aWNhLCBPcGVuIFNhbnMsIHNhbnMtc2VyaWYsIG1vbm9zcGFjZTtmb250LXNpemU6MTFwdDtkb21pbmFudC1iYXNlbGluZTpjZW50cmFsIj4yNDJ4MjAwPC90ZXh0PjwvZz48L3N2Zz4=" -->
					<!-- 							data-holder-rendered="true" -->
					<!-- 							style="height: 200px; width: 100%; display: block;"> -->
					<div class="caption">
						<h3>${product.name}</h3>
						<hr>
						<p>Product Type: ${product.type.name}</p>
						<p>
						<hr>
						<a href="ViewProductServlet?productId=${product.id}&action=View" class="btn btn-primary" role="button">View</a> 
								<a href="SessionServlet?productId=${product.id}&action=Wish" class="btn btn-danger" role="button">WishList</a>
								<a href="ViewProductServlet?productId=${product.id}&action=Update" class="btn btn-default" role="button">Update</a>
							
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
