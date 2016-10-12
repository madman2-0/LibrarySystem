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
<body>
<h3>Insert Book</h3>
<br>
<br>
<br>
<form action="insertbookdb" method="post" >
<table>
<tr><td>Book Name </td><td> : </td><td><input type="text" name="bookname"/></td></tr>
<tr><td>Book Author </td><td> : </td><td><input type="text" name="bookauthor"/></td></tr>
</table>
<input type="submit" class=button value= "insert"/>
</form>
</body>
</html>