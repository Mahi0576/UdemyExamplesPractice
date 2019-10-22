<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name <form:input type="text" path="firstName" /> <br/><br/>
		
		Last Name <form:input type="text" path="lastName" /> <br/><br/>
		
		Country <form:select path="country"> 
 					<form:options items="${countryOptions}" />
				</form:select>
		<br/><br/>
		
		Favorite Language:
		 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
		
		<br/><br/>
		
		Operating Systems:
		Linux: <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS: <form:checkbox path="operatingSystems" value="Mac OS" />
		Windows: <form:checkbox path="operatingSystems" value="Windows" />
		<br/><br/>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>