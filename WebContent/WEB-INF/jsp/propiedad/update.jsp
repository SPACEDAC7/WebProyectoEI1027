<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Easy Rent - Modificar una propiedad</title>
</head>
<body>
	<h2>Modificar propiedad</h2>
	<form:form method="post" modelAttribute="propiedad">
		<table>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input path="id_usuario" /></td>
				<td><form:errors path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="titulo">Titulo </form:label></td>
				<td><form:input path="titulo" /></td>
				<td><form:errors path="titulo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="descripcion">Descripcion</form:label></td>
				<td><form:input path="descripcion" /></td>
			</tr>
			<tr>
				<td><form:label path="tipo">Tipo</form:label></td>
				<td><form:input path="tipo" /></td>
			</tr>
			<tr>
				<td><form:label path="capacidad">Capacidad</form:label></td>
				<td><form:input path="capacidad" /></td>
			</tr>
			<tr>
				<td><form:label path="num_habitaciones">Num. Habitaciones</form:label></td>
				<td><form:input path="num_habitaciones" /></td>
			</tr>
			<tr>
				<td><form:label path="num_camas">Num. Camas</form:label></td>
				<td><form:input path="num_camas" /></td>
			</tr>
			<tr>
				<td><form:label path="area">Area</form:label></td>
				<td><form:input path="area" /></td>
			</tr>
			<tr>
				<td><form:label path="precio_propiedad">Precio</form:label></td>
				<td><form:input path="precio_propiedad" /></td>
			</tr>
			<tr>
				<td><form:label path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input path="id_direccion" /></td>
			</tr>
			<tr>
				<td><form:label path="url_mapa">URL Mapa</form:label></td>
				<td><form:input path="url_mapa" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar propiedad" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>