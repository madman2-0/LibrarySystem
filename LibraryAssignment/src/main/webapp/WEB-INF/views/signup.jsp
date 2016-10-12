<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<style>
.error{
color: red;
font-size: 13px;
}

h3 {
      position:absolute;
      text-align: center;
      width: 85%;
      }

</style>
</head>
<body>
<h3>Welcome new user. Sign up.</h3>
<form:form action="signup" method="post" commandName = "user" >
<br><br><br>
<table>
<tr><td>Username</td><td> : </td><td><form:input type="text" path="username"/></td><td><form:errors path="username" cssClass= "error" /></td></tr>
<tr><td>Password</td><td> : </td><td><form:input type="text" path="password"/></td><td><form:errors path="password" cssClass= "error" /></td></tr>
<tr><td>Name</td><td> : </td><td><form:input type="text" path="name"/></td><td><form:errors path="name" cssClass= "error" /></td></tr>
<tr><td>Date of birth:</td><td> : </td><td><form:input type="text" path="dob"/></td><td><form:errors path="dob" cssClass= "error" /></td></tr>

</table>
<input type="submit" value="register"/>
</form:form>
</body>
</html>