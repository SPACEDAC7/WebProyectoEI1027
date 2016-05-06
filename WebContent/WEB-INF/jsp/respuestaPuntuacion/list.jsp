<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Respuesta</title>
</head>
<body>
	<h1>Llista de Respuesta</h1>
	<table>
		<tr>
			<th>Id. Respuesta</th>
			<th>Id. Puntuacion</th>
			<th>Respuesta</th>
		</tr>
		<c:forEach items="${respuestasPuntuaciones}" var="respuestaPuntuacion">
			<tr>
				<td class="linea">${respuestaPuntuacion.id_respuesta}</td>
				<td class="linea">${respuestaPuntuacion.id_puntuacion}</td>
				<td class="linea">${respuestaPuntuacion.respuesta}</td>
				<td><a href="update/${respuestaPuntuacion.id_respuesta}.html">Edita</a>
				<td><a href="delete/${respuestaPuntuacion.id_respuesta}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Respuesta</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>