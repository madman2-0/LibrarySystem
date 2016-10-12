<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body>
<h3>Admin Sign in</h3>
<br>
<br>
<p style="color:red;">${idErrorMsg}<p>
<form action="loginadmin" method="post">
<table>
<tr><td>Username </td><td> : </td><td><input type="text" name="adminusername"/></td></tr>
<tr><td>Password </td><td> : </td><td><input type="password" name="adminpassword"/></td></tr>
</table>
<input type="submit" class=button value= "Login"/>
</form>
</body>
</html>