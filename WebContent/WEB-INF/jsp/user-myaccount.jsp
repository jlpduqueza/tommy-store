<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0053)https://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/dashboard.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/login.css"/>" rel="stylesheet">
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
 <jsp:include page="/WEB-INF/jsp/side-navbar-user.jsp" />
<body data-context-path="${pageContext.request.contextPath}">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
			
			
			<div class="customMessage" style="display:none;" role="alert">
			</div>
			<!-- Modal -->
			<div class="modal fade shipping-address-modal" id="add-shipping-address" tabindex="-1" role="dialog" aria-labelledby="add-shipping-address" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Add Shipping Address</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
			   <form:form action="add-address" method="post" modelAttribute="shippingAddressBean" name="add-shipping-address-form" id="add-shipping-address-form">
			      <div class="modal-body">
					<div class="alert alert-danger" role="alert" id="errorMessage1"></div>
				      	<h4 id="productName"></h4>
				      	<p id="category"></p>
				      	<p id="price"></p>
				      	<p id="quantity"></p>
			
					<div class="form-group">
						<label for="role">Country</label>
	        	      	<form:select path="country" items="${countryList}"/>
    				    <form:errors path="country" cssStyle="color: #ff0000;"/>
			        </div>
					<div class="form-group">
						<label for="role">Address #1</label>
			        	<form:input path="address1" type="text" class="form-control" name="address2" placeholder="Address #1" required="required"/>
			        	<form:errors path="address1" cssStyle="color: #ff0000;"/>
			        </div>
					<div class="form-group">
						<label for="role">Address #2</label>
			        	<form:input path="address2" type="text" class="form-control" name="address2" placeholder="Address #2" required="required"/>
			        	<form:errors path="address2" cssStyle="color: #ff0000;"/>
			        </div>
					<div class="form-group">
						<label for="role">Zip Code</label>
			        	<form:input path="zipCode" type="text" class="form-control" name="zipCode" placeholder="Zip Code" required="required"/>
			        	<form:errors path="zipCode" cssStyle="color: #ff0000;"/>
			        </div>
			      </div>
			      <div class="modal-footer">
	<!-- 				<input id="id" type="hidden" name="product.id" value=""/> -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary .button-submit" >Add</button>
			      </div>
				   </form:form>  
			    </div>
			  </div>
			</div>
			
						<!-- Modal -->
			<div class="modal fade credit-card-modal" id="add-credit-card" tabindex="-1" role="dialog" aria-labelledby="add-credit-card" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Add Credit Card</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>    
     	       <form:form action="add-credit-card" method="post" modelAttribute="creditCardBean" name="add-credit-card-form" id="add-credit-card-form">
			      <div class="modal-body">
					<div class="alert alert-danger" role="alert" id="errorMessage2"></div> 
					<div class="form-group">
						<label for="role">Card Number</label>
			        	<form:input path="cardNumber" type="text" class="form-control" name="cardNumber" placeholder="Card Number" required="required"/>
			        	<form:errors path="cardNumber" cssStyle="color: #ff0000;"/>
			        </div>
					<div class="form-group">
						<label for="role">Security Code</label>
			        	<form:input path="securityCode" type="text" class="form-control" name="securityCode" placeholder="Security Code" required="required"/>
			        	<form:errors path="securityCode" cssStyle="color: #ff0000;"/>
			        </div>
			      </div>
			      <div class="modal-footer">
<!-- 					<input id="id" type="hidden" name="product.id" value=""/> -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" >Add</button>
			      </div>
				   </form:form>  
			    </div>
			  </div>
			</div>

          	<h2>My Account Credit Card List</h2>
			<ul class="list-inline">
				<li class="list-inline-item credit-card-modal">
	                <a class="nav-link btn btn-dark" style="color: white;" data-toggle="modal" data-target="#add-credit-card" data-id="<c:out value = "${product.id}"/>">
	                  Add new Credit Card
	                </a>
				</li>
			</ul>
			<p class="tableEmptyMessage1" style="display:none;">No credit card record</p>
	          <div class="table-responsive">
	            <table class="table table-striped table-sm" id="creditCardTable">
	              <thead>
	                <tr>
	                  <th>Card Number</th>
	                  <th>Security Code</th>
	                  <th>Action</th>
	                </tr>
	              </thead>
	              <tbody>	
	              </tbody>
	            </table>
          </div> 
          
          <h2>Shipping Address List</h2>
			<ul class="list-inline">
				<li class="list-inline-item shipping-address-modal">
	                <a class="nav-link btn btn-dark" style="color: white;" data-toggle="modal" data-target="#add-shipping-address" data-id="<c:out value = "${product.id}"/>">
	                  Add new Shipping Address
	                </a>
				</li>
			</ul>
          <p class="tableEmptyMessage2" style="display:none;">No shipping address record</p>
          <div class="table-responsive">
            <table class="table table-striped table-sm" id="shippingAddressTable">
              <thead>
                <tr>
                  <th>Country</th>
                  <th>Address #1</th>
                  <th>Address #2</th>
                  <th>Zip Code</th>
                  <th>Action </th>
                </tr>
              </thead>
              <tbody>	
              </tbody>
            </table>
          </div> 
        </main>
        
    <script   src="https://code.jquery.com/jquery-3.4.1.js"   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   crossorigin="anonymous"></script>
	<script type="text/javascript" src="<c:url value="/javascript/lib/underscore.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/templates/template.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/add-credit-card.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/delete-credit-card.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/my-account-page.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/add-shipping-address.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/delete-shipping-address.js"/>"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>

    <script src="<c:url value="/resources/feather.min.js"/>"></script>
    <script>
      feather.replace()
    </script>

</body></html>
