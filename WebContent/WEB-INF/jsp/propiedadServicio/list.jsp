<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de servicio de las propiedades">
	<jsp:body>
	<h1>Llista de Propiedad Servicio</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id. Propiedad</th>
			<th>Id. Servicio</th>
		</tr>
		<c:forEach items="${propiedadesServicios}" var="propiedadServicio">
			<tr>
				<td class="linea">${propiedadServicio.id_propiedad}</td>
				<td class="linea">${propiedadServicio.id_servicio}</td>
				<td><a href="update/${propiedadServicio.id_propiedad}&${propiedadServicio.id_servicio}.html">Edita</a>
				<td><a href="delete/${propiedadServicio.id_propiedad}&${propiedadServicio.id_servicio}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix Propiedad Servicio</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>