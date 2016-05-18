<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado de periodos">
	<jsp:body>
	<h1>Llista de Periodos</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id Periodo</th>
			<th>Id Propiedad</th>
			<th>Inicio</th>
			<th>Fin</th>
		</tr>
		<c:forEach items="${periodos}" var="periodo">
			<tr>
				<td class="linea">${periodo.id_periodo}</td>
				<td class="linea">${periodo.id_propiedad}</td>
				<td class="linea">${periodo.inicio}</td>
				<td class="linea">${periodo.fin}</td>
				<td><a href="update/${periodo.id_periodo}.html">Edita</a>
				<td><a href="delete/${periodo.id_periodo}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix Periodo</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>