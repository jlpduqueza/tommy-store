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
 <jsp:include page="/WEB-INF/jsp/side-navbar.jsp" />
<body data-context-path="${pageContext.request.contextPath}">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
			
			<div class="customMessage" style="display:none;" role="alert">
			</div>
			<!-- Modal -->
			<div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="addProduct" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Add Product</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
	       	 	  <form:form action="add-product" method="post" modelAttribute="product"  id="add_form" name="add-product-form" enctype="multipart/form-data">
			      <div class="modal-body">
<!-- 					<div class="alert alert-danger" role="alert" id="errorMessage"></div> -->
						<div class="form-group product-input">
						
				        </div>
			      </div>
			      <div class="modal-footer">
<!-- 					<input type="hidden" name="product.id" value=""/> -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" id="buttonSubmit">Save</button>
			      </div>
				   </form:form>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="editProduct" tabindex="-1" role="dialog" aria-labelledby="editProduct" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Edit Product</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
	       	 	  <form:form action="edit-product" method="post" modelAttribute="product"  id="edit_form" name="edit-product-form" enctype="multipart/form-data">
			      <div class="modal-body" id="edit-body">
<!-- 					<div class="alert alert-danger" role="alert" id="errorMessage"></div> -->
						<div class="form-group edit-product-input">
						
				        </div>
			      </div>
			      <div class="modal-footer">
<!-- 					<input type="hidden" name="product.id" value=""/> -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" id="buttonSubmit">Save</button>
			      </div>
				   </form:form>
			    </div>
			  </div>
			</div>
          <h2>Product List</h2>
			<ul class="list-inline">
				<li class="list-inline-item add-product-li">
	                <a class="nav-link btn btn-dark add-product-link" style="color: white;" data-toggle="modal" data-target="#addProduct">
	                  Add new product
	                </a>		
				</li>
			</ul>	
			<ul class="list-inline error-message" style="display: none;">
				<li class="list-inline-item">					
					<div class="alert alert-danger" role="alert" id="errorMessage"></div>	
				</li>
			</ul>
          <p class="tableEmptyMessage" style="display:none;">No products record</p>
          <div class="table-responsive">
            <table class="table table-striped table-sm" id="productTable">
              <thead>
                <tr>
                  <th>Image</th>
                  <th>Product Id</th>
                  <th>Name</th>
                  <th>Price</th>
                  <th>Category</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
          </div>
        </main>

    <script   src="https://code.jquery.com/jquery-3.4.1.js"   integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   crossorigin="anonymous"></script>
	<script type="text/javascript" src="<c:url value="/javascript/lib/underscore.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/templates/template.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/product/admin-product-list.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/product/admin-add-product.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/product/admin-edit-product.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/product/admin-delete-product.js"/>"></script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/feather.min.js"/>"></script>

</body></html>
