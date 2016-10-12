<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
${showInfoErrorMsg}
<form action="showinfobook" method="post">
<table>
<tr><td>Book Id</td><td> : </td><td><input name="bookid" /></td></tr>         
</table>
<input type="submit" value="show Book details" />
</form><br>
<br>
<hr>
<br>
${updateErrorMsg}
<form action="updateBook" method="post">
<table>
<tr><td>Book Id</td><td> : </td><td><input name="bookid" /></td></tr>  
</table>
<input type="submit" value="update" />
</form>
<br><br>
<hr>
<br>
 ${deleteErrorMsg}
<form action="delete" method="post">
<table>
<tr><td>Book Id</td><td> : </td><td><input name="bookid" /></td></tr>
</table>
<input type="submit" value="delete" />    
</form>

</body>
</html>