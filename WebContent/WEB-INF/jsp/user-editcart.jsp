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
	        <h2>Edit Cart</h2>
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
	        <form:form action="edit-cartitem" method="post" modelAttribute="cartItem">
			
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="role"><b><c:out value="${cartItem.product.name}"/></b></label>
						<br>
                		<c:choose>
							<c:when test="${cartItem.product.inventoryItem.quantity>=50}">  
			       				  <c:out value = "In Stock"/>
							</c:when>
							<c:when test="${cartItem.product.inventoryItem.quantity<50 && cartItem.product.inventoryItem.quantity>0}">  
			       				  <c:out value = "Only ${cartItem.product.inventoryItem.quantity} left in stock"/>
							</c:when>
							<c:when test="${cartItem.product.inventoryItem.quantity<1}">  
			       				  <c:out value = "No Stock"/>
							</c:when>
						</c:choose>
			        	<form:input path="quantity" type="number" class="form-control" name="name" placeholder="name" required="required"/>
			        	<form:errors path="quantity" cssStyle="color: #ff0000;"/>
			        </div>
				<div class="form-group">
					<form:hidden path="product.id" value="${cartItem.product.id}"/>
					<form:hidden path="product.name" value="${cartItem.product.name}"/>
					<form:hidden path="product.inventoryItem.quantity" value="${cartItem.product.inventoryItem.quantity}"/>
					<form:hidden path="product.price" value="${cartItem.product.price}"/>
		            <form:button type="submit" class="btn btn-primary btn-lg">Save</form:button>
		        </div>
				</div>
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
