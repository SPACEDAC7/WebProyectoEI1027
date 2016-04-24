<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Direcciones</title>
</head>
<body>
	<h1>Llista de Direcciones</h1>
	<table>
		<tr>
			<th>Id Direccion</th>
			<th>Calle</th>
			<th>Numero</th>
			<th>C.P.</th>
			<th>Localidad</th>
			<th>Provincia</th>
		</tr>
		<c:forEach items="${direcciones}" var="direccion">
			<tr>
				<td class="linea">${direccion.id_direccion}</td>
				<td class="linea">${direccion.calle}</td>
				<td class="linea">${direccion.numero}</td>
				<td class="linea">${direccion.codigo_postal}</td>
				<td class="linea">${direccion.localidad}</td>
				<td class="linea">${direccion.provincia}</td>
				<td><a href="update/${direccion.id_direccion}.html">Edita</a>
				<td><a href="delete/${direccion.id_direccion}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Direccion</a>
</body>
</html>