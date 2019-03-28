<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Service</title>

<script>
function validate(){
	vehicleNo=document.getElementById("vehicleNo").value;
	if(vehicleNo==""  || vehicleNo==null){
		alert("Vehicle Number is mandatory")
		return false;
	}
	VehicleType=document.getElementById("vehicleType").value;
	if(vehicleType.equals=="" || vehicleType==null){
		alert("Vehicle Type is mandatory")
		return false;
	}
	return true;
}
</script>

</head>
<body>
<center>
<h2>Register For Service</h2>
<form:form name="serviceform"  action="registerForService.htm" modelAttribute="serviceRegister" method="GET" >
	

	<table    border="0">
		<tr>
			<td>Vehicle Number</td>
			<td><form:input path="vehicleNo" id="vehicleNo"/></td>
		</tr>
		
		<tr>
			<td>Vehicle Type</td>
			<td><form:radiobutton path="vehicleType" value="Two Wheeler" id="vehicleType"/>Two Wheeler
				<form:radiobutton path="vehicleType" value="Four Wheeler" id="vehicleType"/>Four Wheeler
			</td>
			
		</tr>
		
		<tr>
			<td>MechanicId</td>
			<td>
			<form:select path="mechanicId">
			<form:options items="${mechanicId}" />
			</form:select></td>
		</tr>	
		
				 
		 <tr>
			<td colspan="2" align="center">
			<input type="submit" value="Register" onClick="return validate()"></td>
		 </tr>	
		 
		 <tr>
				<td colspan="2" align="center"><font color="red">${MESSAGE}</font></td>
			</tr>
		
		
		 
		</table>
		
		 <br> <a href="home.htm"> Home</a> <br> 

</form:form>
</center>

</body>
</html>