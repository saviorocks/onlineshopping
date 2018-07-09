<div class="container">
	<div class="row">
		<div class="col-sm-10" style="width:600px; margin-left:250px; margin-top:50px;">
			<div class="jumbotron">
				<div class="form-group" style="margin-top:-50px;">
					<h2><center>Customer Registration</center></h2>
				</div>
				
				<form class="form-horizontal" style="margin-left:50px;">
					
					<div class="form-group">
						<label>First Name:</label>
						<input type="text" class="form-control" name="first name"
							placeholder="Enter First Name" required> 
					</div>
	
					<div class="form-group">
						<label>Last Name:</label>
						<input type="text" class="form-control" name="last name"
							placeholder="Enter Last Name" required> 
					</div>
					
					<div class="form-group">
						<label>Mobile Number:</label>
						<input type="text" class="form-control" name="mbbno"
							placeholder="Enter Mobile Number" required> 
					</div>
					
					<div class="form-group">
						<label>Date Of Birth:</label>
						<input type="date" class="form-control" name="dob"
							placeholder="dd/mm/yy" required> 
					</div>
					
					<div class="form-group">
						<label>Gender:</label>
						<select class="form-control">
							<option value="selectgender" selected>Select Gender</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select>
					</div>
					
					<div class="form-group">
						<label>Email"</label>
						<input type="email" class="form-control" name="email"
							placeholder="Enter Email Id" required> 
					</div>
					
					<div class="form-group">
						<label>Password:</label>
						<input type="password" class="form-control" name="pass"
							placeholder="Enter Password" required> 
					</div>
					
					<div class="form-group">
						<label>Confirm Password:</label>
						<input type="password" class="form-control" name="cpass"
							placeholder="Enter Confirm Password" required> 
					</div>
						
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Submit" style="width:212px;">
						<input type="reset" class="btn btn-danger" value="Reset" style="width:212px;">
					</div>
					
					
					<div class="form-group">					
						Already a Customer? <a href="${contextRoot}/login">Login</a>
					</div>	
				</form>
			</div>
		</div>
	</div>
</div>