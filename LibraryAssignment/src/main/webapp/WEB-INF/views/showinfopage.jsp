<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h3 {
      position:absolute;
      text-align: center;
      width: 85%;
      }
</style>
</head>
<body>
<form:form action="home" modelAttribute="list" method="get">
<h3>List Of Users for id :${bookid}</h3>
<br>
<br>
<br>
<table>
<tr><th>Username</th><th>Name</th></tr>
</table>
<c:forEach items="${list}" var="vs">
<table>

<tr><th>${vs.username}</th><th>${vs.name}</th></tr>
</table>
</c:forEach>
</form:form>
</body>
</html>