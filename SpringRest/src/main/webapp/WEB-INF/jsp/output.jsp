<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>REST using Spring MVC and MongoDB.</h2>

		<form action="document/save" method="post">
			<input type="hidden" name="id">
			<label for="name">Document Name</label>
			<input type="text" id="name" name="name"/>
			<input type="submit" value="Submit"/>
		</form>

	<table border="1">
		<c:forEach var="document" items="${personList}">
			<tr>
				<td>${document.name}</td><td><input type="button" value="delete" onclick="window.location='document/delete?id=${document.id}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>