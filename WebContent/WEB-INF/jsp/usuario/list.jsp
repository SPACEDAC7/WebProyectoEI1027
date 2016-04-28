<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Usuarios</title>
</head>
<body>
	<h1>Llista de Usuarios</h1>
	<table>
		<tr>
			<th>Id Usuario</th>
			<th>Id Credencial</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>NIF</th>
			<th>Email</th>
			<th>Direccion</th>
			<th>Fecha Registro</th>
			<th>Telefono</th>
			<th>Estado usuario</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td class="linea">${usuario.id_usuario}</td>
				<td class="linea">${usuario.id_credencial}</td>
				<td class="linea">${usuario.nombre}</td>
				<td class="linea">${usuario.apellido}</td>
				<td class="linea">${usuario.nif}</td>
				<td class="linea">${usuario.email}</td>
				<td class="linea">${usuario.id_direccion}</td>
				<td class="linea">${usuario.fecha_registro}</td>
				<td class="linea">${usuario.telefono}</td>
				<td class="linea">${usuario.estado_usuario}</td>
				<td><a href="update/${usuario.id_usuario}.html">Edita</a>
				<td><a href="delete/${usuario.id_usuario}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix usuario</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>