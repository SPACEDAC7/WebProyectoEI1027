<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de Mensajes">
	<jsp:body>
	<h1>Llista de Mensajes</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id Mensaje</th>
			<th>Id Receptor</th>
			<th>Id Emisor</th>
			<th>Asunto</th>
			<th>Contenido</th>
			<th>Estado Vision</th>
			<th>Fecha Mensaje</th>
		</tr>
		<c:forEach items="${mensajes}" var="mensaje">
			<tr>
				<td class="linea">${mensaje.id_mensaje}</td>
				<td class="linea">${mensaje.id_receptor}</td>
				<td class="linea">${mensaje.id_emisor}</td>
				<td class="linea">${mensaje.asunto}</td>
				<td class="linea">${mensaje.contenido}</td>
				<td class="linea">${mensaje.estado_vision}</td>
				<td class="linea">${mensaje.fecha_mensaje}</td>
				<td><a href="update/${mensaje.id_mensaje}.html">Edita</a>
				<td><a href="delete/${mensaje.id_mensaje}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Redacta</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>