<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6">
<div style="color: #FF0000;">
		${errorText.get("userName")} <br /> <br /> ${errorText.get("password")}
	</div>
	<form class="form-horizontal" action="CreateUserServlet" method="POST">
		<div class="form-group">
			<label for="inputType" class="col-md-2 control-label">Name</label>
			<div class="col-md-10">
				<input name="name" type="text" class="form-control" id="inputName"
					placeholder="Name" value="${user.userName}">
			</div>
		</div>
		<div class="form-group">
			<label for="inputType" class="col-md-2 control-label">Password</label>
			<div class="col-md-10">
				<input name="password" type="password" class="form-control" id="inputPassword"
					placeholder="Password" value="${user.password}">
			</div>
		</div>
		<div class="form-group">
			<label for="inputType" class="col-md-2 control-label">Type</label>
			<div class="col-md-10">
				<select name="userType" class="form-control">
					<option>Select</option>
					<c:forEach items="${userTypeList}" var="option">
						<option value="${option.id}"
							${user.type.id == option.id ? 'selected' : ''}>${option.name}
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputName" class="col-md-2 control-label">Status</label>
			<div class="col-md-10">
				<input name="status" type="text" class="form-control" id="inputName"
					placeholder="Status" value="${user.status}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-2 col-md-10">
				<input name="create" type="submit" class="btn btn-default"
					value="Create" />
			</div>
		</div>
	</form>
</div>
<div class="col-md-6"></div>