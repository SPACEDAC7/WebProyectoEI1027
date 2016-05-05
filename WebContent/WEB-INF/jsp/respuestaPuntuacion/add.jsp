<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Easy Rent - Crear nueva respuesta</title>
</head>
<body>
	<h2>Nova respuesta</h2>
	<form:form method="post" modelAttribute="respuestaPuntuacion">
		<table>
			<tr>
				<td><form:label path="id_respuesta">ID. Respuesta </form:label></td>
				<td><form:input path="id_respuesta" /></td>
				<td><form:errors path="id_respuesta" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_puntuacion">ID. Puntuacion</form:label></td>
				<td><form:input path="id_puntuacion" /></td>
				<td><form:errors path="id_puntuacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="respuesta">Respuesta</form:label></td>
				<td><form:input path="respuesta" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix respuesta" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
