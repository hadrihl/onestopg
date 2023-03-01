<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Manage Users</title>
    <style>
    	table, th, td {
    		border: 1px solid black;
    		border-collapse: collapse;
    	}
    </style>
</head>
<body>
    <h1>User Management</h1>
    
    <%@ include file="components/navi.jsp" %> 
    
    <c:if test="${empty users}">
    <div class="container">
    	<p>No user(s) found.</p>
    </div>
    </c:if>
    
    <div class="container">
    <c:if test="${not empty users}">
    	<table>
    		<colgroup>
    			<col span="6" />
    		</colgroup>
    		<tr>
    			<th>#</th>
    			<th>Username</th>
    			<th>Email</th>
    			<th>Authority</th>
    			<th>Action</th>
    		</tr> 		
    		
    		<c:forEach var="user" items="${users}" varStatus="row">
    		<tr>
    			<td>${row.index+1 }</td>
		    	<td>${user.username }</td>
		    	<td>${user.email }</td>
		    	
		    	<td>
		    	<c:forEach var="role" items="${user.roles}">
		    		${role.name }
		    		
		    	</c:forEach>
		    	</td>
		   
			   	<td>
					<a href="/users/${user.id}">Edit</a> &nbsp;
					<a href="/delete-user/${user.id}">Delete</a>
			    </td>
			</tr>
		    </c:forEach>
		    
    		
    	</table>
    
    
    </c:if>	
    </div>
   
   	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<sec:authorize access="hasAuthority('ADD_STORE')">
   	<div class="container" style="margin-top: 10px;">
   		<a href="/add-user"><button>Add User</button></a>
   	</div>
   	</sec:authorize>
    
    <div class="container">
    	<form:form action="/search-user" method="post" modelattribute="keyword">
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