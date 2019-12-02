<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>

</head>

<body>
	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name: <form:input path="lastName"/>
	
	<br><br>
	
	Country: 
			<!-- On submit, Spring will call student.setCountry(...) -->
			 <form:select path="country">
	 			
	 			
	 			<form:options items="${theCountryOptions}" />
	 			
	 			
	 			
				<%-- <form:options items="${student.countryOptions}" />   --%>
	 			
	 			
	 			
	 		 </form:select>
	
	<br><br>
	
	Favorite Language:
	
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
	
	<%--
	JAVA <form:radiobutton path="favoriteLanguage" value="JAVA "/>
	Python <form:radiobutton path="favoriteLanguage" value="Python "/>
	C++ <form:radiobutton path="favoriteLanguage" value="C++ "/>
	GO <form:radiobutton path="favoriteLanguage" value="GO "/>
	--%>
	
	<br><br>
	
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac <form:checkbox path="operatingSystems" value="Mac"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	
	
	
	
	<br><br>
	
	<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>