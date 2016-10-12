<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information</title>
<style>
h3 {
      position:absolute;
      text-align: center;
      width: 85%;
      }
</style>
</head>
<body>
<h3>Your information</h3>
<br>
<br>
<br>
<table>
<tr><td>ID: </td><td>${user.id}</td></tr>
<tr><td>Name: </td><td>${user.name}</td></tr>
<tr><td>Date of birth: </td><td>${user.dob}</td></tr>
</table>

<a href="addbooks">Addbooks</a>
<a href="modifyaccount?ma=${user.id}">Modify account</a>
</body>
</html>