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
		
		<div class="container" style="background-color:; max-width:1080px">
	        <h2>Add Address</h2>
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
	        <form:form action="add-address" method="post" modelAttribute="shippingAddressBean">
			
			<div class="row">
			
				<div class="col-md-4">
					<div class="form-group">
						<label for="role">Country</label>
	        	      	<form:select path="country" items="${countryList}"/>
    				    <form:errors path="country" cssStyle="color: #ff0000;"/>
			        </div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="role">Address #1</label>
			        	<form:input path="address1" type="text" class="form-control" name="address2" placeholder="Address #1" required="required"/>
			        	<form:errors path="address1" cssStyle="color: #ff0000;"/>
			        </div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="role">Address #2</label>
			        	<form:input path="address2" type="text" class="form-control" name="address2" placeholder="Address #2" required="required"/>
			        	<form:errors path="address2" cssStyle="color: #ff0000;"/>
			        </div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="role">Zip Code</label>
			        	<form:input path="zipCode" type="text" class="form-control" name="zipCode" placeholder="Zip Code" required="required"/>
			        	<form:errors path="zipCode" cssStyle="color: #ff0000;"/>
			        </div>
				</div>
			</div>
				<div class="form-group">
		            <button type="submit" class="btn btn-primary btn-lg">Save</button>
		        </div>
	  		</form:form>
        </div>
        </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/jquery-3.2.1.slim.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<c:url value="/resources/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/bootstrap.min.js"/>"></script>

    <!-- Icons -->
    <script src="<c:url value="/resources/feather.min.js"/>"></script>
    <script>
      feather.replace()
    </script>

</body></html>
