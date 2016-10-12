<!DOCTYPE> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<style>
.user {
     width: 200px;
     border-style:solid;
     border-width: 5px;
     background-color: #ffffcc;
}
.user th {
    border-bottom: 1px solid black;
    }
.user tr {
     height: 50px;
     text-align: center;     
}
.user tr:hover {
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
	Hello world!  
</h2>
<br>
<br>
<br>
<table class="user">
<tr><th><a href = "signinpage">UserSignin</a></th></tr>
<tr><th><a href = "registrationpage">Signup</a></th></tr>
<tr><th><a href="adminloginpage">AdminSignin</a></th></tr>
</table>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
