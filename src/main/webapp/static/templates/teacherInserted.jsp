<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<h1>Teacher inserted successfully</h1>
	<div>
		<p>${requestScope.insertedTeacher.id}</p>
		<p>${requestScope.insertedTeacher.lastname}</p>
		<p>${requestScope.insertedTeacher.firstname}</p>
	</div>	
	 	
	<div>
		<a href="${pageContext.request.contextPath}/static/templates/teachersmenu.jsp">Return</a>
	</div> 	
</body>
</html>