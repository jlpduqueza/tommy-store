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
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
 <jsp:include page="/WEB-INF/jsp/side-navbar.jsp" />
<body data-context-path="${pageContext.request.contextPath}">

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>

			<div class="customMessage" style="display:none;" role="alert">
			</div>
			<!-- Modal -->
			<div class="modal fade" id="addNewAdmin" tabindex="-1" role="dialog" aria-labelledby="addNewAdmin" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">Add new administrator</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>     
	       	 <form:form action="add-admin" method="post" modelAttribute="signUpBean" id="add-admin-form" name="addNewAdmin">
			      <div class="modal-body">
		<!-- 			<div class="alert alert-danger" role="alert" id="errorMessage"></div> -->
						<div class="form-group">
							<label for="role">First name</label>
				        	<input  type="text" class="form-control" id="firstName" name="firstName" placeholder="First name" required="required"/>
				        </div>
						<div class="form-group">
							<label for="role">Last name</label>
				        	<input  type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required="required"/>
				        </div>
						<div class="form-group">
			        		<label for="role">Contact Number</label>
				        	<input  type="tel" class="form-control" id="contactNumber" name="contactNumber" placeholder="Contact Number" required="required"/>
				        </div>	
						<div class="form-group">
							<label for="role">Email</label>
				        	<input  type="email" class="form-control" id="email" name="email" placeholder="Email" required="required"/>
				        </div>
						<div class="form-group">
			  		        <label for="role">Password</label>
				        	<input  type="password" class="form-control" id="password" name="password" placeholder="Password" required="required"/>
				        </div>
						<div class="form-group">
				        	<label for="role">Confirm Password</label>
				        	<input  type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" required="required"/>
				        </div>
			      </div>
			      <div class="modal-footer">
<!-- 					<input type="hidden" name="product.id" value=""/> -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			        <button type="submit" class="btn btn-primary" id="add-admin-submit">Add</button>
			      </div>
				   </form:form>
			    </div>
			  </div>
			</div>

          <h2>User List</h2>
       		<c:choose>
				<c:when test="${errorMessage!=null}">  
					<div class="alert alert-danger" role="alert">
				  		<c:out value = "${errorMessage}"/>	
					</div>
				</c:when>
				<c:when test="${successMessage!=null}">  
					<div class="alert alert-success" role="alert">
				  		<c:out value = "${successMessage}"/>	
					</div>
				</c:when>
			</c:choose>
   	        <form:form action="filter-user" method="post" id="filter-user-form" name="filter-user-form" modelAttribute="roleBean">
			<ul class="list-inline">
				<li class="list-inline-item add-admin-form">
	                <a class="nav-link btn btn-dark" style="color: white;" data-toggle="modal" data-target="#addNewAdmin" data-id="<c:out value = "${product.id}"/>">
	                  Add new administrator
	                </a>
				</li>
				<li class="list-inline-item float-right">
					<div class="form-group filter-submit">
	        	      	<form:select path="role" items="${roleList}"/>
	        	      	<button type="submit" class="btn btn-dark">filter</button>
			        </div>
				</li>
			</ul>
	  		</form:form>
          <p class="tableEmptyMessage" style="display:none;">No user records</p>
          <div class="table-responsive">
            <table class="table table-striped table-sm" id="userTable">
              <thead>
                <tr>
                  <th>First name</th>
                  <th>Last name</th>
                  <th>Email</th>
                  <th>Contact number</th>
                  <th>Role</th>
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
	<script type="text/javascript" src="<c:url value="/javascript/user/filter-user.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascript/user/user-list.js"/>"></script>
 	<script type="text/javascript" src="<c:url value="/javascript/admin/admin-add-administrator.js"/>"></script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/feather.min.js"/>"></script>
</body></html>
