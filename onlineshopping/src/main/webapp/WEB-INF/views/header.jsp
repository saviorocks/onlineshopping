<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="home"><a href="${contextRoot}/home">Home</a></li>
        <li class="listproducts"><a href="${contextRoot}/show/all/products">View Products</a></li>
        <security:authorize access="hasAuthority('SUPPLIER')">
        	<li class="manageproducts"><a href="${contextRoot}/manage/products">Manage Products</a></li>
        </security:authorize>
        <li class="about"><a href="${contextRoot}/about">About</a></li>
        <li class="contact"><a href="${contextRoot}/contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<security:authorize access="isAnonymous()">
					<li class="signup"><a href="${contextRoot}/register"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li class="login"><a href="${contextRoot}/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</security:authorize>
		
		
		<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userCart"><a href="javascript:void(0)"
						class="btn btn-default dropdown-toggle" id="dropdownMenu1"
						data-toggle="dropdown"> ${userModel.fullName} <span
							class="caret"></span>
					</a>

						<ul class="dropdown-menu">

							<security:authorize access="hasAuthority('USER')">
								<li>
								<a href="${contextRoot}/cart/show">
									<span class="glyphicon glyphicon-shopping-cart"></span>&#160;
									<span class="badge">${userModel.cart.cartLines}</span> - &#8377;
									 ${userModel.cart.grandTotal} 
								</a>
								</li>

								<li class="divider" role="seprator"></li>
							</security:authorize>

							<li><a href="${contextRoot}/perform-logout">Logout</a></li>



						</ul></li>
				</security:authorize>
		
		
	      </ul>
    </div>
  </div>
</nav> 


<script>

	window.userRole = '${userModel.role}';

</script>




