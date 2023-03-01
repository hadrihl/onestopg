<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    
    <%@ include file="components/navi.jsp" %> 
    
    <c:if test="${empty stores}">
    <div class="container">
    	<p>No stores found.</p>
    </div>
    </c:if>
    
    <div class="container">
    <c:if test="${not empty stores}">
    	<table>
    		<colgroup>
    			<col span="6" />
    		</colgroup>
    		<tr>
    			<th>#</th>
    			<th>Store Name</th>
    			<th>Address</th>
    			<th>Email</th>
    			<th>Phone Number</th>
    			<th>Status</th>
    			<th>Action</th>
    		</tr>
    		<c:forEach var="store" items="${stores}" varStatus="row">
    			<td>${row.index+1 }</td>
		    	<td>${store.name }</td>
		    	<td>${store.address }</td>
		    	<td>${store.email }</td>
		    	<td>${store.phone_number }</td>
		    	
		    	<c:if test="${store.status == false}">
		    	<td>Inactive</td>
		    	</c:if>
		    	<c:if test="${store.status == true}">
		    	<td>Active</td>
		    	</c:if>
		    	    	
		    	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
		    	<sec:authorize access="hasAuthority('ADD_STORE')">
		    	<td>
		    		<a href="/edit-store/${store.id }">Edit</a> &nbsp;
		    		<a href="/delete-store/${store.id }">Delete</a>
		    	</td>
		    	</sec:authorize>
		    <tr>
		    </c:forEach>
    		</tr>
    	</table>
    
    
    </c:if>	
    </div>
   
   	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<sec:authorize access="hasAuthority('ADD_STORE')">
   	<div class="container" style="margin-top: 10px;">
   		<a href="/add-store"><button>Add Store</button></a>
   	</div>
   	</sec:authorize>
    
    <div class="container">
    	<form:form action="/search" method="post" modelattribute="keyword">
    	<h5>Search: </h5>
    	<input type="text" id="keyword" name="keyword" />
    	<input type="submit" value="Search"/> 
    	</form:form>
    
	    <div class="container" style="margin-top: 10px;">
	    	<a href="/stores"><button>Reset</button></a>
	    </div>
    
    </div>
</body>
</html>