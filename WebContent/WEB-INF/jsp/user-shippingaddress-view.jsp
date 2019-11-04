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
			
			<div class="alert alert-danger alert-dismissible fade show" style="display:none;" role="alert">
			  <p id="errorMessage"></p>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
          <h2>Shipping Address List</h2>       		
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
			<p class="tableEmptyMessage" style="display:none;">No shipping address record</p>
          <div class="table-responsive">
            <table class="table table-striped table-sm">
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
		         <c:forEach var="shippingAddress" items="${shippingAddressList}">
			         <tr>
				         <td><c:out value = "${shippingAddress.country}"/></td>
				         <td><c:out value = "${shippingAddress.address1}"/></td>
				         <td><c:out value = "${shippingAddress.address2}"/></td>
				         <td><c:out value = "${shippingAddress.zipCode}"/></td>
				         <td>
				         	<a class="btn btn-dark" href="edit-shippingaddress-view?id=${shippingAddress.id}" role="button">Edit</a>
   				         	<a class="btn btn-dark" href="delete-shipping-address?id=${shippingAddress.id}" role="button">Delete</a>
				         </td>
			         </tr>
		         </c:forEach>
              </tbody>
            </table>
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
