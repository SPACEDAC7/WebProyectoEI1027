<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Easy Rent - Modificar una direccion</title>
</head>
<body>
	<h2>Modificar direccion</h2>
	<form:form method="post" modelAttribute="direccion">
		<table>
			<tr>
				<td><form:label path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input path="id_direccion" /></td>
				<td><form:errors path="id_direccion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="calle">Calle</form:label></td>
				<td><form:input path="calle" /></td>
			</tr>
			<tr>
				<td><form:label path="numero">Numero</form:label></td>
				<td><form:input path="numero" /></td>
			</tr>
			<tr>
				<td><form:label path="codigo_postal">Codigo Postal</form:label></td>
				<td><form:input path="codigo_postal" /></td>
			</tr>
				<tr>
				<td><form:label path="localidad">Localidad</form:label></td>
				<td><form:input path="localidad" /></td>
			</tr>
				<tr>
				<td><form:label path="provincia">Provincia</form:label></td>
				<td><form:input path="provincia" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar direccion" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>