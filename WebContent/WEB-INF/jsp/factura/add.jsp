<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Easy Rent - Crear nueva factura</title>
</head>
<body>
	<h2>Nueva Factura</h2>
	<form:form method="post" modelAttribute="factura">
		<table>
			<tr>
				<td><form:label path="id_factura">ID. Factura</form:label></td>
				<td><form:input path="id_factura" /></td>
				<td><form:errors path="id_factura" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_reserva">ID. Reserva</form:label></td>
				<td><form:input path="id_reserva" /></td>
			</tr>
			<tr>
				<td><form:label path="fecha_factura">Fecha Factura</form:label></td>
				<td><form:input path="fecha_factura" /></td>
			</tr>
			<tr>
				<td><form:label path="precio_factura">Precio Factura</form:label></td>
				<td><form:input path="precio_factura" /></td>
			</tr>
				<tr>
				<td><form:label path="iva">IVA</form:label></td>
				<td><form:input path="iva" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix factura" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
