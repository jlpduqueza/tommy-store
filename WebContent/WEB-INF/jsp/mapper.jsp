<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>

<style type="text/css">
  span.error{
    color: red;
    margin-left: 5px;
  }
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/javascript/loginForm.js"/>">
</script>
</head>
<body>
  <h1>Login</h1>
  <h3 id="errorMessage"></h3>

  <form action="loggingInTest" method="post" name="loginForm">
    <table>
      <tr>
        <td>Email</td>
        <td><input name="email" type="text" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input name="password" type="password" /></td>
      </tr>
      <tr>
        <td></td>
        <td><button type="submit">Submit</button></td>
      </tr>
    </table>
  </form>

<!-- Result Container  -->
<div id="resultContainer" style="display: none;">
 <hr/>
 <h4 style="color: green;">JSON Response From Server</h4>
  <pre style="color: green;">
    <code></code>
   </pre>
</div>
</body>
<script>
	$(document).ready(function() {

		var list = ${list};
		$.each(list, function( index, value ) {
			alert( index + ": " + value );
		});
		
	});
</script>

</html>