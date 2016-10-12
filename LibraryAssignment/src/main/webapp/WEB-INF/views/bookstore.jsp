<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="com.glx.model.Books" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <c:forEach  items="${list}" var="bookvalues" >
[<c:out value="${bookvalues}" />]
</c:forEach> --%>
<form:form method="post" commandName="book1" action="submitbooks">
<form:checkboxes element="ul li" path="book" items="${map}"/> 
<input type="submit" class=button value= "Login"/>
</form:form>
</body>
</html>









<%-- <c:forEach items="${list}" var="map">
    <c:forEach items="${map}" var="entry">
        ${entry.key}<br>
        ${entry.value}<br>
    </c:forEach>
</c:forEach>
<div id="divCheckbox" style="display: none;">
<form:checkboxes items="${listofbooks}" path="bookids" /></div> --%>
