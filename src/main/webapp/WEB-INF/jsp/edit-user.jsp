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
    <h1>Edit User</h1>
    
	<form:form action="/update-user/${user.id}" method="POST" modelattribute="user">
		<label for="name">Username: </label>
		<input type="text" id="username" name="username" value="${user.username }" required></input><br><br>
		
		<label for="email">Email: </label>
		<input type="email" id="email" name="email" value="${user.email }" required></input><br><br>
		
		<label for="status">Authority: </label><br>
		
		<input type="checkbox" id="VIEW_STORE" name="viewStore" onclick="return false;" checked/>
		<label for="VIEW_STORE">VIEW_STORE</label><br>
		<input type="checkbox" id="ADD_STORE" name="addStore"/>
		<label for="ADD_STORE">ADD_STORE</label><br>
		
		<c:forEach var="role" items="${user.roles}">
		
		<c:if test="${role.name == 'ADD_STORE'}">
		<script>
			var addStoreCheckbox = document.getElementById("ADD_STORE").checked = true;
		</script>
		</c:if>
		
		</c:forEach>
		
		<br><button>Cancel</button>
		<input type="submit" value="Save">
	</form:form>
    
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	
</script>
</html>