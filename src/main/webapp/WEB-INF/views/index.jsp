<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<html>
<link href="<c:url value="/resources/NewFile.css" />" rel="stylesheet">
<body>

<h2>Cube processing</h2>
<form:form method="POST" action="${pageContext.servletContext.contextPath}/processDimension">
   <table>
    <tr>
        <td><form:label path="dimension.length">Length</form:label></td>
        <td><form:input path="dimension.length" /></td>
        
         <td><form:label path="cube.length">Length</form:label></td>
        <td><form:input path="cube.length" /></td>
    
    
    <td>
    <form:select path="dimension.unit" id="unit">
	    <form:options items="${unitList}"  /> 
	</form:select> 
	<td>
	
	</tr>
	
	 <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>

</body>
</html>