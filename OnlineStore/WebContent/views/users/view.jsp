<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<h2>View User: ${user.userName}</h2>
	<h3>Type: ${user.userType.name}</h3>
</div>
<%@ include file="../layout/footer.jsp"%>
