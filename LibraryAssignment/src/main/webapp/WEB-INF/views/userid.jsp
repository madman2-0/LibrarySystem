<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br><br><br><br>
${updateErrorMsg}
<form action="UserupdatePage" method="post">
<table>
<tr><td>User Id</td><td> : </td><td><input name="id" /></td></tr>  
</table>
<input type="submit" value="update" />
</form>
<br><br>
<hr>
<br><br>
 ${deleteErrorMsg}
<form action="deleteuser" method="post">
<table>
<tr><td>User Id</td><td> : </td><td><input name="id" /></td></tr>
</table>
<input type="submit" value="delete" />    
</form>

</body>
</html>