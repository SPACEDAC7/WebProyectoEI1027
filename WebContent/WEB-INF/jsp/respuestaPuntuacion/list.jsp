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
		<c:forEach items="${respuestas_puntuaciones}" var="respuesta_puntuacion">
			<tr>
				<td class="linea">${respuesta.id_respuesta}</td>
				<td class="linea">${respuesta.id_puntuacion}</td>
				<td class="linea">${respuesta.respuesta}</td>
				<td><a href="update/${respuesta.id_respuesta}.html">Edita</a>
				<td><a href="delete/${respuesta.id_respuesta}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Respuesta</a>
</body>
</html>