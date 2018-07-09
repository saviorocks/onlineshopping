<div class="container">
	<div class="row">
		<div class="col-sm-10" style="width:600px; margin-left:250px; margin-top:50px;">
			<div class="jumbotron">
				<div class="form-group" style="margin-top:-50px;">
					<h1><center>Login</center></h1>
				</div>
				
				<form class="form-horizontal" style="margin-left:50px;">
					
					<div class="form-group input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</span>
						<input type="email" class="form-control" name="email"
							placeholder="Email Id" required> 
					</div>
	
					<div class="form-group input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</span>
						<input id="password" type="password" class="form-control" name="password" 
							placeholder="Password" required data-toggle="password" >
					</div>
					
					<div class="form-group">
						<label>
							<input type="checkbox"> Remember Me?
						</label>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary" style="width:430px;">Login</button>
					</div>
					
					<div class="form-group">
						<a href="#">Forgot Password?</a>
					</div>
					
					<div class="form-group">					
						New Customer? <a href="${contextRoot}/signup">Sign Up</a>
					</div>	
				</form>
			</div>
		</div>
	</div>
</div>

