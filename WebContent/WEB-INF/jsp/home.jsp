<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>

 <jsp:include page="/WEB-INF/jsp/side-navbar-user.jsp" />
<body data-context-path="${pageContext.request.contextPath}">
   <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
			
			<!-- Modal -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Login as User</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <a class="btn btn-primary" href="login">Login</a>
			      </div>
			    </div>
			  </div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="AddToCart" tabindex="-1" role="dialog" aria-labelledby="AddToCart" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Add To Cart</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
			   <form:form action="add-to-cart-2" method="post" modelAttribute="cartItem" id="add-to-cart-form" name="addToCart">
			      <div class="modal-body modal-content" id="modal-content">
					
			      </div>
			      <div class="modal-footer">
					<input id="id" type="hidden" name="product.id" value=""/>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" id="buttonSubmit">Add</button>
			      </div>
				   </form:form> 
			    </div>
			  </div>
			</div>
	  		<div class="container">
				<h2><c:out value = "Welcome ${user.email}"/></h2>
	  		<ul class="list-inline">
				<li class="list-inline-item">
       			   <h2>Products</h2>
					<div class="customMessage" style="display:none;" role="alert">
					</div>
		       		<c:choose>
						<c:when test="${errorMessage!=null}">  
							<div class="alert alert-danger message" role="alert">
						  		<c:out value = "${errorMessage}"/>	
							</div>
						</c:when>
						<c:when test="${successMessage!=null}">  
							<div class="alert alert-success message" role="alert">
						  		<c:out value = "${successMessage}"/>	
							</div>
						</c:when>
					</c:choose>     		
				</li>
				<li class="list-inline-item float-right search-list-item">
					<form:form action="${pageContext.request.contextPath}/ajax/search" method="POST" modelAttribute="searchBean" name="searchForm">
						<div class="input-group form-group">
							  <form:input path="keyword" type="text" class="form-control" placeholder="keyword" aria-label="Search" aria-describedby="basic-addon2"/>
	        	      		  <form:select path="criteria" items="${searchCriteria}"/>
						    	<button class="btn btn-outline-info" id="search" type="submit">Search</button>
						  	</div>
					</form:form>
				</li>
			</ul>
		         <div class="col-md-12" id="card">
				  <div class="row equal card-container">
			  	</div>
			  </div>
			</div>
          </main>
          
    <script   src="https://code.jquery.com/jquery-3.4.1.js"   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   crossorigin="anonymous"></script>
	<script type="text/javascript" src="<c:url value="/javascript/lib/underscore.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/templates/template.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/common.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/feather.min.js"/>"></script>	
	<script type="text/javascript" src="<c:url value="/javascript/cart/add-to-cart-modal.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/search/search-product.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/product/product-list.js"/>"></script>
</body></html>
