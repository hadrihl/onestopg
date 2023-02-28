<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>OneStopGroceries Portal</title>
</head>
<body>
    <h1>Edit Store</h1>
    
	<form:form action="/update-store/${store.id}" method="POST" modelattribute="store">
		<label for="name">Store Name: </label>
		<input type="text" id="name" name="name" value="${store.name }" required></input><br><br>
		
		<label for="phone">Phone Number: </label>
		<input type="text" id="phone" name="phone_number" value="${store.phone_number }" required></input><br><br>
		
		<label for="address">Address: </label>
		<input type="text" id="address" name="address" value="${store.address }" required></input><br><br>
		
		<label for="email">Email: </label>
		<input type="email" id="email" name="email" value="${store.email }" required></input><br><br>
		
		<label for="status">Status: </label>
		<input type="text" id="status" name="status" value="${store.status }" required></input><br><br>
		
		<button>Cancel</button>
		<input type="submit" value="Save">
	</form:form>
    
</body>
</html>