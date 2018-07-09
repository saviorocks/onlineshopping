<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Sandstom Theme -->
<link href="${css}/bootstrap-slate-theme.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>
<body>

	<div class="wrapper">

	<!-- Navigation -->
	 <%@include file="header.jsp" %>
	
	<!-- Page Content -->
	
	<div class="content">
	<!-- Loding Home Page -->
	<c:if test="${userClickHome == true}">
	<%@include file="home.jsp" %>
	</c:if>
	
	<!-- Loding About Page -->
	
	<c:if test="${userClickAbout == true}">
	<%@include file="about.jsp" %>
	</c:if>
	
	<!-- Loding Contact Page -->
	<c:if test="${userClickContact == true}">
	<%@include file="contact.jsp" %>
	</c:if>
	
	<!-- Loding Login Page -->
	<c:if test="${userClickLogin == true}">
	<%@include file="login.jsp" %>
	</c:if>
	
	<!-- Loding Signup Page -->
	<c:if test="${userClickSign == true}">
	<%@include file="signup.jsp" %>
	</c:if>
	
	</div>
	
	<!-- Footer -->
	<%@include file="footer.jsp" %>


		<!-- JQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Self Coded JavaScript -->
		<script src="${js}/myapp.js"></script>
	
	</div>
	
</body>
</html>