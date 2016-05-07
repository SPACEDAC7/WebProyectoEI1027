<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Easy Rent - Modificar un servicio</title>
</head>
<body>
	<h2>Modificar servicio</h2>
	<form:form method="post" modelAttribute="servicio">
		<table>
			<tr>
				<td><form:label path="idServicio">ID. Servicio</form:label></td>
				<td><form:input path="idServicio" /></td>
				<td><form:errors path="idServicio" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nombreServicio">Nombre Servicio</form:label></td>
				<td><form:input path="nombreServicio" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar servicio" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>