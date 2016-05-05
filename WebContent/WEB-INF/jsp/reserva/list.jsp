<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Reserva</title>
</head>
<body>
	<h1>Llista de Reservas</h1>
	<table>
		<tr>
			<th>Id. Reserva</th>
			<th>Id. Usuario</th>
			<th>Id. Propiedad</th>
			<th>Fecha Reserva</th>
			<th>Fecha Check In</th>
			<th>Fecha Check Out</th>
			<th>Precio Reserva</th>
			<th>Estado</th>
		</tr>
		<c:forEach items="${reservas}" var="reserva">
			<tr>
				<td class="linea">${reserva.id_reserva}</td>
				<td class="linea">${reserva.id_usuario}</td>
				<td class="linea">${reserva.id_propiedad}</td>
				<td class="linea">${reserva.fecha_reserva}</td>
				<td class="linea">${reserva.fecha_checkin}</td>
				<td class="linea">${reserva.fecha_checkout}</td>
				<td class="linea">${reserva.precio_reserva}</td>
				<td class="linea">${reserva.estado}</td>
				<td><a href="update/${reserva.id_reserva}.html">Edita</a>
				<td><a href="delete/${reserva.id_reserva}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Reserva</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>