<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>OneStopGroceries Portal</title>
</head>
<body>
    <h1>Add Store</h1>
    
	<form:form action="/add-store" method="POST" modelattribute="store">
		<label for="name">Name: </label>
		<input type="text" id="name" name="name" required></input><br><br>
		
		<label for="name">Phone Number: </label>
		<input type="text" id="phone" name="phone_number" required></input><br><br>
		
		<input type="submit" value="Submit">
	</form:form>
    
</body>
</html>