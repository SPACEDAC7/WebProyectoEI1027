<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de propiedades">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Respuestas de la puntuación</h1>
		<table class="table table-condensed sortable">
			<tr>
				<th >Id. Respuesta</th>
				<th >Id. Puntuacion</th>
				<th >Respuesta</th>
			</tr>
			<c:forEach items="${respuestas}" var="respuesta">
				<tr>
					<td class="linea">${respuesta.id_respuesta}</td>
					<td class="linea">${respuesta.id_puntuacion}</td>
					<td class="linea">${respuesta.respuesta}</td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/respuestaPuntuacion/anadirRespuesta/${puntuacion}.html">A&ntilde;adir Respuesta</a>
		<a class="btn btn-danger" href="${pageContext.request.contextPath}/cabecera/inicio.html"> Volver al inicio</a>
		</div>
	</jsp:body>
</t:paginabasica> 