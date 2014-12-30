<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6">
	<form class="form-horizontal" action="UpdateProductServlet"
		method="POST" >
		<div class="form-group">
			<label for="inputType" class="col-md-2 control-label">Name</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" id="inputType"
					placeholder="Name" value="${product.name}">
			</div>
		</div>
		<div class="form-group">
			<label for="inputType" class="col-md-2 control-label">Type</label>
			<div class="col-md-10">
				<select name="listProducts" class="form-control">
					<option>Select</option>
					<c:forEach items="${listProducts}" var="option">
						<option value="${option.id}"
							${product.type.id == option.id ? 'selected' : ''}>${option.name}
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputName" class="col-md-2 control-label">Status</label>
			<div class="col-md-10">
				<input name="status" type="text" class="form-control" id="inputName"
					placeholder="Status" value="${product.status}">
			</div>
		</div>

<!-- 		<DIV CLASS="FORM-GROUP"> -->
<!-- 			<LABEL FOR="INPUTIMAGE" CLASS="COL-MD-2 CONTROL-LABEL">IMAGE</LABEL> -->
<!-- 			<DIV CLASS="COL-MD-10"> -->
<!-- 				<INPUT TYPE="FILE" NAME="IMAGEFILE" SIZE="300" /> -->
<!-- 			</DIV> -->
<!-- 		</DIV> -->

		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">

				<%-- 				<% if( ${user} != null ) {%> --%>
				<input type="hidden" name="productId" value="${product.id}"> 
					<input name="paramName"  type="submit" class="btn btn-default" value="Edit"/>
				<%-- 					<% } else {%> --%>
				<!-- 					<button type="submit" class="btn btn-default">Update</button> -->
				<%-- 					<% } %> --%>
			</div>
		</div>
	</form>
</div>
<div class="col-md-6"></div>
