<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de respuesta de puntuaciones">
	<jsp:body>
	<h1>Llista de Respuesta</h1>
	<table class="table table-condensed">
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
	<a class="btn btn-primary" href="add.html">Afegeix Respuesta</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>