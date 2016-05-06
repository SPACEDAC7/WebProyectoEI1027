<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Easy Rent - Modificar una respuesta</title>
</head>
<body>
	<h2>Modificar respuesta</h2>
	<form:form method="post" modelAttribute="respuestaPuntuacion">
		<table>
			<tr>
				<td><form:label path="id_respuesta">ID. Reserva </form:label></td>
				<td><form:input path="id_respuesta" /></td>
				<td><form:errors path="id_respuesta" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_puntuacion">ID. Usuario</form:label></td>
				<td><form:input path="id_puntuacion" /></td>
				<td><form:errors path="id_puntuacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="respuesta">ID. Propiedad</form:label></td>
				<td><form:input path="respuesta" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar reserva" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>