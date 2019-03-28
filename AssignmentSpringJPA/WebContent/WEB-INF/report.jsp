<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
<center>
<h2>Service Report</h2>
<table border="1" align="center">
	<tr>
	<th> Service ID</th> <th> Vehicle Number </th><th>Vehicle Type</th><th>Mechanic Id</th>
	</tr>
    <jstlcore:forEach items="${serviceRegisterList}" var="service">
		<tr align="center">
		<td align="center"><jstlcore:out value="${service.serviceId}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${service.vehicleNo}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${service.vehicleType}"></jstlcore:out></td>
		<td align="center"><jstlcore:out value="${service.mechanicEntity.mechanicId}"></jstlcore:out></td>
		</tr>
	</jstlcore:forEach>
</table>
	<font color="red">${MESSAGE}</font>
 <br> <a href="home.htm"> Home</a> <br> 
</center>
</body>
</html>