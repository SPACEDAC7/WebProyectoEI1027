<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado de facturas">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Llista de Facturas</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id Facturas</th>
			<th>Id Reservas</th>
			<th>Fecha Factura</th>
			<th>Precio Factura</th>
			<th>IVA</th>
		</tr>
		<c:forEach items="${facturas}" var="factura">
			<tr>
				<td class="linea">${factura.id_factura}</td>
				<td class="linea">${factura.id_reserva}</td>
				<td class="linea">${factura.fecha_factura}</td>
				<td class="linea">${factura.precio_factura}</td>
				<td class="linea">${factura.iva}</td>
				<td><a href="update/${factura.id_factura}.html">Edita</a>
				<td><a href="delete/${factura.id_factura}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix Factura</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</div>
	</jsp:body>
</t:paginabasica>