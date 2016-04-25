<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Facturas</title>
</head>
<body>
	<h1>Llista de Facturas</h1>
	<table>
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
				<td><a href="update/${factura.id_direccion}.html">Edita</a>
				<td><a href="delete/${factura.id_direccion}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Factura</a>
</body>
</html>