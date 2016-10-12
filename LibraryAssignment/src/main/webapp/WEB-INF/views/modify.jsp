<!DOCTYPE> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<style>
.admin {
     width: 200px;
     border-style:solid;
     border-width: 5px;
     background-color: #ffffcc;
}
.admin th {
    border-bottom: 1px solid black;
    }
.admin tr {
     height: 50px;
     text-align: center;     
}
.admin tr:hover {
          background-color: #ffff99;
        }

h2 {
      position:absolute;
      text-align: center;
      width: 85%;
      }

</style>
</head>
<body>
<h2>
	Hello User!  
</h2>
<br>
<br>
<br>
<table class="admin">

<tr><th><a href = "showinfousers?id=${ma}">Show Books</a></th></tr>
<tr><th><a href= "useridpage">Update</a></th></tr>
<tr><th><a href= "useridpage">Delete</a></th></tr>
</table>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
