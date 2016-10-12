<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h3 {
      position:absolute;
      text-align: center;
      width: 85%;
      }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User details</title>
</head>
<body>
<h3>Update User Details</h3>

<br><br><br>
<form:form action="updateuser" method="post" modelAttribute="user">
<table>

<tr><td>User Name</td><td>: </td><td><form:input path="username"/></td></tr>
<tr><td>Password</td><td>: </td><td><form:input path="password"/></td></tr>
<tr><td>Name</td><td>: </td><td><form:input path="name"/></td></tr>
<tr><td>Date of Birth</td><td>: </td><td><form:input path="dob"/></td></tr>

</table>
<input type="submit" value="update book">
</form:form>
</body>
</html>