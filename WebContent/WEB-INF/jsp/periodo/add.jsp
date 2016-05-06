<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Easy Rent - Crear nou periodo</title>
</head>
<body>
	<h2>Nou periodo</h2>
	<form:form method="post" modelAttribute="periodo">
		<table>
			<tr>
				<td><form:label path="id_periodo">ID. Periodo</form:label></td>
				<td><form:input path="id_periodo" /></td>
				<td><form:errors path="id_periodo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input path="id_propiedad" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaInicio">Dia inicio </form:label></td>
				<td><form:input path="fechaInicio" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaFinal">D�a final </form:label></td>
				<td><form:input path="fechaFinal" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix periodo" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
