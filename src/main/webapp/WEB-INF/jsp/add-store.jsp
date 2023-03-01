<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>OneStopGroceries Portal</title>
</head>
<body>
	<%@ include file="components/navi.jsp" %> 
	
    <h1>Add Store</h1>
    
	<form:form action="/add-store" method="POST" modelattribute="store">
		<label for="name">Store Name: </label>
		<input type="text" id="name" name="name" required></input><br><br>
		
		<label for="name">Phone Number: </label>
		<input type="text" id="phone" name="phone_number" required></input><br><br>
		
		<label for="address">Address: </label>
		<input type="text" id="address" name="address" value="${store.address }" required></input><br><br>
		
		<label for="email">Email: </label>
		<input type="email" id="email" name="email" value="${store.email }" required></input><br><br>
		
		<button type="button" onclick="location.href='/stores'">Cancel</button>
		<input type="submit" value="Submit">
	</form:form>
    
</body>
</html>