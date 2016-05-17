<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="EASY RENT">
<jsp:body>
	<div class="barra-lat">
		<ul class="list-unstyled">
		<li class="sidbar-header">
			<form action="${pageContext.request.contextPath}/buscador/list.html" method="get"  role="form">
				<button type="submit" class="btn btn-primary btn-lg btn-block">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					BUSCAR
				</button>
				<div>
					<label for="precio_form" class="centrado control-label">Precio</label>
				</div>
				<div class="form-group">
	      			<input type="text" class="precio-menu form-control" id="precio_form" placeholder="Minimo">
		            <input type="text" class="precio-menu seguido form-control" id="precio_form" placeholder="Maximo">
			  	</div>
			  	<div class="form-group">
			  		<label for="tipo_form" class="centrado control-label">Tipo</label>
			  		<input type="text" class="form-control" id="tipo_form" placeholder="Tipo">
			  	</div>
				<div class="form-group">
			  		<label for="capacidad_form" class="centrado control-label">Capacidad</label>
			  		<input type="text" class="form-control" id="capacidad_form" placeholder="Capacidad">
			  	</div>
			  	<div class="form-group">
			  		<label for="habitaciones_form" class="centrado control-label">Habitaciones</label>
			  		<input type="text" class="form-control" id="habitaciones_form" placeholder="Nº Habitaciones">
			  	</div>
			  	<div class="form-group">
			  		<label for="camas_form" class="centrado control-label">Camas</label>
			  		<input type="text" class="form-control" id="camas_form" placeholder="Nº Cama">
			  	</div>
			  	<div class="form-group">
			  		<label for="area_form" class="centrado control-label">Area</label>
			  		<input type="text" class="form-control" id="area_form" placeholder="Area">
			  	</div>
			  	<div class="form-group">
			  		<label for="lugar_form" class="centrado control-label">Lugar</label>
			  		<input type="text" class="form-control" id="lugar_form" placeholder="Lugar">
			  	</div>
			  	<div class="form-group">
			  		<label for="servicio_form" class="centrado control-label">Servicios</label>
			  		<input type="text" class="form-control" id="servicio-form" placeholder="Servicio">
			  	</div>
			</form>
		</li>
		</ul>
	</div>
	<div id="resultadoBuscador">
		<table class="table-condensed">
			<tr>
				<th>Titulo</th>
				<th>Descripcion</th>
				<th>Tipo</th>
				<th>Capacidad</th>
				<th>Num. Habitaciones</th>
				<th>Num. Camas</th>
				<th>Area</th>
				<th>Precio</th>
			</tr>
			<c:forEach items="${propiedades}" var="propiedad">
				<tr>
					<td class="linea">${propiedad.titulo}</td>
					<td class="linea">${propiedad.descripcion}</td>
					<td class="linea">${propiedad.tipo}</td>
					<td class="linea">${propiedad.capacidad}</td>
					<td class="linea">${propiedad.num_habitaciones}</td>
					<td class="linea">${propiedad.num_camas}</td>
					<td class="linea">${propiedad.area}</td>
					<td class="linea">${propiedad.precio_propiedad}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</jsp:body>
</t:paginabasica>