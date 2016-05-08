<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Easy Rent - Crear nova propiedad servicio</title>
</head>
<body>
	<h2>Nova propiedad servicio</h2>
	<form:form method="post" modelAttribute="propiedadServicio">
		<table>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad"/></td>
				<td><form:errors path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_servicio">ID. Servicio</form:label></td>
				<td><form:input path="id_servicio" /></td>
				<td><form:errors path="id_servicio" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix propiedad servicio" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>