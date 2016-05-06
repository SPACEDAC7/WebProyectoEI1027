<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Easy Rent - Modificar una puntuacion</title>
</head>
<body>
	<h2>Modificar puntuacion</h2>
	<form:form method="post" modelAttribute="reserva">
		<table>
			<tr>
				<td><form:label path="id_reserva">ID. Reserva </form:label></td>
				<td><form:input path="id_reserva" /></td>
				<td><form:errors path="id_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input path="id_usuario" /></td>
				<td><form:errors path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="fechaReserva">Fecha Reserva</form:label></td>
				<td><form:input path="fechaReserva" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaCheckIn">Fecha Check In</form:label></td>
				<td><form:input path="fechaCheckIn" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaCheckOut">Fecha Check Out</form:label></td>
				<td><form:input path="fechaCheckOut" /></td>
			</tr>
			<tr>
				<td><form:label path="precio_reserva">Precio Reserva</form:label></td>
				<td><form:input path="precio_reserva" /></td>
			</tr>
			<tr>
				<td><form:label path="estado">Estado</form:label></td>
				<td><form:input path="estado" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar reserva" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>