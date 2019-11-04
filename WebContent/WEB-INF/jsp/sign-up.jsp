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
<body data-context-path="${pageContext.request.contextPath}">


	<div class="login-form">
    <form:form action="signing-up" method="post" modelAttribute="signUpBean">
		<h2>Sign Up</h2>
			<div class="customMessage" style="display:none;" role="alert">
			</div>
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
        <div class="form-group">
        	<form:input path="firstName" type="text" class="form-control" name="First name" placeholder="First name" required="required"/>
        	<form:errors path="firstName" cssStyle="color: #ff0000;"/>
        </div>
        <div class="form-group">
        	<form:input path="lastName" type="text" class="form-control" name="Last name" placeholder="Last name" required="required"/>
        	<form:errors path="lastName" cssStyle="color: #ff0000;"/>
        </div>
        <div class="form-group">
        	<form:input path="contactNumber" type="tel" class="form-control" name="Contact number" placeholder="Contact number" required="required"/>
        	<form:errors path="contactNumber" cssStyle="color: #ff0000;"/>
        </div>
        <div class="form-group">
        	<form:input path="email" type="email" class="form-control" name="email" placeholder="Email Address" required="required"/>
        	<form:errors path="email" cssStyle="color: #ff0000;"/>
        </div>
		<div class="form-group">
            <form:input path="password" type="password" class="form-control" name="password" placeholder="Password" required="required"/>
       		<form:errors path="password" cssStyle="color: #ff0000;"/>
        </div>
		<div class="form-group">
            <form:input path="confirmPassword" type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" required="required"/>
       		<form:errors path="confirmPassword" cssStyle="color: #ff0000;"/>
        </div>        
		<div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Sign Up</button>
        </div>

		</form:form>
        </div>
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
                            