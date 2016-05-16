<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de puntuaciones">
	<jsp:body>
	<h1>Llista de Puntuaciones</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id. Puntuacion</th>
			<th>Id. Propiedad</th>
			<th>Id. Usuario</th>
			<th>Valor Puntuacion</th>
			<th>Comentario</th>
		</tr>
		<c:forEach items="${puntuaciones}" var="puntuacion">
			<tr>
				<td class="linea">${puntuacion.id_puntuacion}</td>
				<td class="linea">${puntuacion.id_propiedad}</td>
				<td class="linea">${puntuacion.id_usuario}</td>
				<td class="linea">${puntuacion.valor_puntuacion}</td>
				<td class="linea">${puntuacion.comentario}</td>
				<td><a href="update/${puntuacion.id_puntuacion}.html">Edita</a>
				<td><a href="delete/${puntuacion.id_puntuacion}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix Puntuacion</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>