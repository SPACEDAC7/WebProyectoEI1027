<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="EASY RENT">
<jsp:body>
	<div class="barra-lat">
		<ul class="list-unstyled">
		<li class="sidbar-header">
			<form action="${pageContext.request.contextPath}/propiedad/list.html" method="get"  role="form">
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
	<div>
	
	</div>
</jsp:body>
</t:paginabasica>