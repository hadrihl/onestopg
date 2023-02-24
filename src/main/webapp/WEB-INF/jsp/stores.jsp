<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>OneStopGroceries Portal</title>
    <style>
    	table, th, td {
    		border: 1px solid black;
    		border-collapse: collapse;
    	}
    </style>
</head>
<body>
    <h1>Welcome to OneStopGroceries!</h1>
    
    <c:if test="${empty stores}">
    <div class="container">
    	<p>No stores found.</p>
    </div>
    </c:if>
    
    <div class="container">
    <c:if test="${not empty stores}">
    	<table>
    		<colgroup>
    			<col span="4" />
    		</colgroup>
    		<tr>
    			<th>#</th>
    			<th>Store Name</th>
    			<th>Address</th>
    			<th>PIC</th>
    			<th>Email</th>
    			<th>Phone Number</th>
    			<th>Status</th>
    			<th>Action</th>
    		</tr>
    		<c:forEach var="store" items="${stores}" varStatus="row">
    			<td>${row.index+1 }</td>
		    	<td>${store.name }</td>
		    	<td>address1</td>
		    	<td>pic1</td>
		    	<td>email1@example.com</td>
		    	<td>${store.phone_number }</td>
		    	<td>Active</td>
		    	<td>
		    		<a href="#">Edit</a>
		    		<a href="#">Delete</a>
		    	</td>
		    <tr>
		    </c:forEach>
    		</tr>
    	</table>
    
    
    </c:if>	
    </div>
    
    <a href="/add-store">Add Store</a>
    
</body>
</html>