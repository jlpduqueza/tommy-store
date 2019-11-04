<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!-- saved from url=(0053)https://getbootstrap.com/docs/4.0/examples/dashboard/ -->
<html lang="en"><head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Dashboard Template for Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/dashboard.css"/>" rel="stylesheet">
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style>

</head>

<body data-context-path="${pageContext.request.contextPath}">
  
  	<c:choose>
       <c:when test="${user==null}">  
		    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="https://getbootstrap.com/docs/4.0/examples/dashboard/#">Tommy's Store</a>
		     
		      <ul class="navbar-nav px-3">
		        <li class="nav-item text-nowrap">
		          <a class="nav-link" href="/tommystore/ajax/login">Login</a>
		        </li>
		      </ul>
		    </nav>
	     </c:when>
	     <c:when test="${user!=null}">  
		    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="https://getbootstrap.com/docs/4.0/examples/dashboard/#">Tommy's Store</a>
		
		     	<div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" style="color: rgb(255, 255, 255)" data-toggle="dropdown">${user.firstName}</a>
                    <div class="dropdown-menu">
                        <a href="/tommystore/logout" class="dropdown-item">Logout</a>
                    </div>
                </div>

		    </nav>
	     </c:when>
		</c:choose>


   <!--  <script src="/resources/jquery-3.2.1.slim.min.js" ></script> -->
</body></html>
