<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Store</title>
<link href="<%= request.getContextPath() %>/themes/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
</head>
<body>

	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%= request.getContextPath() %>/WelcomeServlet">online store</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
			<li><a href="<%= request.getContextPath() %>/SessionServlet">wishList</a> </li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">account
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Login</a></li>
						<li><a href="#">Registration</a></li>
						<li><a href="#">Account</a></li>
						<li><a href="#">Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>
</body>
</html>