<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/natacio.css">
<title>Gestionar Credenciales</title>
</head>
<body>
	<h1>Llista de Credenciales</h1>
	<table>
		<tr>
			<th>Id Cedencial</th>
			<th>Nick usuario</th>
			<th>Password</th>
			<th>Rol</th>
		</tr>
		<c:forEach items="${credenciales}" var="credencial">
			<tr>
				<td class="linea">${credencial.id_credencial}</td>
				<td class="linea">${credencial.nick_usuario}</td>
				<td class="linea">${credencial.password}</td>
				<td class="linea">${credencial.rol}</td>
				<td><a href="update/${credencial.id_credencial}.html">Edita</a>
				<td><a href="delete/${credencial.id_credencial}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix credencial</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>