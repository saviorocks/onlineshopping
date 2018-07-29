<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>


<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Template -->
<link href="${css}/bootstrap-slate-theme.css" rel="stylesheet">

<%-- <!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
 --%>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap.css" />

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${contextRoot}/home">Home</a>
			</div>

		</nav>


		<!-- Page Content -->

		<div class="content">

			<div class="container">
			
			
			<c:if test="${not empty message}">
			
				<div class="row">

					<div class="col-md-offset-3 col-md-6">
				
						<div class="alert alert-danger">${message}</div>	
					
					</div>
					
				</div>
			
			</c:if>
			
			<%-- this will be displayed only when the user has logged out --%>
			<c:if test="${not empty logout}">
			
				<div class="row">

					<div class="col-md-offset-3 col-md-6">
				
						<div class="alert alert-success">${logout}</div>	
					
					</div>
					
				</div>
			
			</c:if>

				<div class="row">

					<div class="col-md-offset-3 col-md-6">				

						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>

							<div class="panel-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">
									<div class="form-group">
										<label for="username" class="col-md-4 control-label">Email:
										</label>
										<div class="col-md-8">
											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-md-4 control-label">Password:
										</label>
										<div class="col-md-8">
											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>
									
									
									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</div>
									</div>
									
									
									
									
									
									
									
									
								</form>

							</div>
							<div class="panel-footer">
								<div class="text-right">
									New User - <a href="${contextRoot}/register">Register Here</a>
								</div>
							</div>

						</div>

					</div>

				</div>

			</div>


		</div>

		<!-- Footer comes here -->
		<%@include file="footer.jsp"%>

		<!-- JQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>


		<script type="text/javascript"
			src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>
		<script type="text/javascript"
			src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap.js"></script>

		<!-- jquery validator -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Self Coded JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>