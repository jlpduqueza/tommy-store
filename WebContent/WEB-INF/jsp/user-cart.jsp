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
			
  			<div class="modal fade" id="edit-cart" tabindex="-1" role="dialog" aria-labelledby="edit-cart" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Edit cart</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
			 	  <form:form action="edit-cart" method="post" modelAttribute="cartItem" id="edit-form" name="edit-cart">
			      <div class="modal-body">
			      </div>
			      <div class="modal-footer">
					<input id="id" type="hidden" name="product.id" value=""/>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" id="buttonSubmit">Save</button>
			      </div>
				  </form:form> 
			    </div>
			  </div>
			</div>

          <h2>Cart </h2> 

			<div class="customMessage" style="display:none;" role="alert">
			</div>	    		
			<div class="form-group">
				<form action="checkout-view">
		      	      	<button type="submit" class="btn btn-dark">checkout</button>
				</form>
	        </div>
			<div class="form-group">
				<form action="clear-cart" id="clear-form">
		      	      	<button type="submit" class="btn btn-dark clear-link">Clear</button>
				</form>
	        </div>
          <p class="tableEmptyMessage" style="display:none;">No cart item record</p>
          <div class="table-responsive">
            <table class="table table-striped table-sm cartItem-table">
              <thead>
                <tr>
                  <th>Image</th>
                  <th>Product Name</th>
                  <th>Stock</th>
                  <th>Price</th>
                  <th>Quantity</th>
                  <th>Sub Total</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
              
              </tbody>
            </table>
          </div>
        </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->	
    <script   src="https://code.jquery.com/jquery-3.4.1.js"   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   crossorigin="anonymous"></script>
	<script type="text/javascript" src="<c:url value="/javascript/lib/underscore.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/templates/template.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/cart/clear-cart.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/cart/delete-cartitem.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/cart/edit-cart-modal.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/cart/cart-list.js"/>"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
    <!-- Icons -->
    <script src="<c:url value="/resources/feather.min.js"/>"></script>
    <script>
      feather.replace()
    </script>

</body></html>
