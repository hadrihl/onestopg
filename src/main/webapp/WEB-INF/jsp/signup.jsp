<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>
    <h1>Welcome to OneStopGroceries!</h1>
    
    <div class="container">
    	<h3>Signup</h3>
    	
    	<form:form action="/signup" method="post" modelAttribute="user">
    	
    		<label for="username">Username:</label>
    		<input type="text" id="username" name="username" autofocus required /> </br>
    		
    		<label for="email">Email:</label>
    		<input type="email" id="email" name="email" required /> </br>
    		
    		<label for="password">Password:</label>
    		<input type="password" id="password" name="password" required /> </br>
    		
    		<input type="submit" value="Signup">
    	</form:form>
    </div>
</body>
</html>