<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de servicios">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Lista de Servicios</h1>
	<table class="table table-condensed">
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
	<a class="btn btn-primary" href="add.html">Añade servicio</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</div>
	</jsp:body>
</t:paginabasica>