<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Servicios</title>
</head>
<body>
	<h1>Lista de Servicios</h1>
	<table>
		<tr>
			<th>Id Servicio</th>
			<th>Nombre Servicio</th>
		</tr>
		<c:forEach items="${servicios}" var="servicio">
			<tr>
				<td class="linea">${servicio.idServicio}</td>
				<td class="linea">${servicio.nombreServicio}</td>
				<td><a href="update/${servicio.idServicio}.html">Edita</a>
				<td><a href="delete/${servicio.idServicio}.html">Borra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Añade servicio</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>