<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de reservas">
	<jsp:body>
	<h1>Llista de Reservas</h1>
	<table class="table table-condensed">
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
	<a class="btn btn-primary" href="add.html">Afegeix Reserva</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>