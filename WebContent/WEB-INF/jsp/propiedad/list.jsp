<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de propiedades">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Lista de Propiedades</h1>
		<table class="table table-condensed">
			<tr>
				<th>Id. Propiedad</th>
				<th>Id. Usuario</th>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Tipo</th>
				<th>Capacidad</th>
				<th>Num. Habitaciones</th>
				<th>Num. Camas</th>
				<th>Area</th>
				<th>Precio</th>
				<th>Id. Direccion</th>
				<th>URL Mapa</th>
			</tr>
			<c:forEach items="${propiedades}" var="propiedad">
				<tr>
					<td class="linea">${propiedad.id_propiedad}</td>
					<td class="linea">${propiedad.id_usuario}</td>
					<td class="linea">${propiedad.titulo}</td>
					<td class="linea">${propiedad.descripcion}</td>
					<td class="linea">${propiedad.tipo}</td>
					<td class="linea">${propiedad.capacidad}</td>
					<td class="linea">${propiedad.num_habitaciones}</td>
					<td class="linea">${propiedad.num_camas}</td>
					<td class="linea">${propiedad.area}</td>
					<td class="linea">${propiedad.precio_propiedad}</td>
					<td class="linea">${propiedad.id_direccion}</td>
					<td class="linea">${propiedad.url_mapa}</td>
					<td><a href="update/${propiedad.id_propiedad}.html">Edita</a>
					<td><a href="delete/${propiedad.id_propiedad}.html">Esborra</a>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="add.html">Afegeix Propiedad</a>
		<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
		</div>
	</jsp:body>
</t:paginabasica>