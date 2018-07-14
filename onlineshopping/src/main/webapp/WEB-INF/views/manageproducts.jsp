<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">
			
				<div class="alert alert-success alert-dismissible">
			
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					
					${message}
					
				</div>
			</div>

		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management</h4>

				</div>

				<div class="panel-body">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST" 
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" id="name" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Product Brand: </label>
							<div class="col-md-8">
								<sf:input type="text" id="brand" path="brand"
									class="form-control" placeholder="Product Brand" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									class="form-control" placeholder="Enter your description here!" />
								<sf:errors path="description" cssClass="help-block" element="em" /> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Unit
								Price: </label>
							<div class="col-md-8">
								<sf:input type="number" id="unitPrice" path="unitPrice"
									class="form-control" placeholder="Enter Unit Price in &#8377;" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									class="form-control" placeholder="Enter Quantity" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity: </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" id="submit" name="submit" value="Submit"
									class="btn btn-primary" placeholder="Product Name" />

								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>
						</div>

					</sf:form>

				</div>

			</div>

		</div>

	</div>

</div>