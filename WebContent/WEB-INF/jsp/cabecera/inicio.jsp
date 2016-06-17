<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="EASY RENT">
<jsp:body>
	<div class="header-slide" id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="quick-search">
						<div class="row">
							 <form:form method="post" modelAttribute="buscador" role="form" class="advance-search">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<form:label path="localidad">Ciudad</form:label>
									  <form:select class="form-control" path="localidad">
									  	<form:option value="" selected="selected">Seleccione localidad</form:option>
										<form:option value="castellon">Castellon</form:option>
										<form:option value="valencia">Valencia</form:option>
										<form:option value="Vila-real">Vila-real</form:option>
									  </form:select>
									</div>
									<div class="form-group">
										<form:label path="num_habitaciones">Habitaciones</form:label>
				                      <form:select class="form-control" path="num_habitaciones">
				                        <form:option value ="-1" selected="selected">Nº habitaciones</form:option>
				                        <form:option value="1">1</form:option>
				                        <form:option value="2">2</form:option>
				                        <form:option value="3">3</form:option>
				                        <form:option value="4">4</form:option>
				                        <form:option value="5">5</form:option>
				                        <form:option value="18">18</form:option>
				                      </form:select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										 <form:label path="tipo">Tipo</form:label>
					                      <form:select class="form-control" path="tipo">
					                      	<form:option value="" selected="selected">Tipo de propiedad</form:option>
					                        <form:option value="apartamento">Apartamento</form:option>
					                        <form:option value="casa">Casa</form:option>
					                      </form:select>
									</div>
									<div class="form-group">
										<form:label path="num_camas">Camas</form:label>
					                      <form:select class="form-control" path="num_camas">
					                      	<form:option value ="-1" selected="selected">Nº camas</form:option>
					                        <form:option value="1">1</form:option>
					                        <form:option value="2">2</form:option>
					                        <form:option value="3">3</form:option>
					                        <form:option value="4">4</form:option>
					                      </form:select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										 <form:label path="precio_propiedad_maximo">Precio máximo</form:label>
					                      <form:select class="form-control" path="precio_propiedad_maximo">
					                      	<form:option value ="-1" selected="selected">Precio máximo</form:option>
					                        <form:option value="2000">2.000 €</form:option>
					                        <form:option value="1500">1.500 €</form:option>
					                        <form:option value="1000">1.000 €</form:option>
					                        <form:option value="500">500 €</form:option>
					                      </form:select>
									</div>
									<div class="form-group">
										<form:label path="capacidad">Capacidad</form:label>
				                      <form:select class="form-control" path="capacidad">
				                      <form:option value ="-1" selected="selected">Nº ocupantes</form:option>
				                        <form:option value="1">1</form:option>
				                        <form:option value="2">2</form:option>
				                        <form:option value="3">3</form:option>
				                        <form:option value="4">4</form:option>
				                      </form:select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										 <form:label path="precio_propiedad_minimo">Precio mínimo</form:label>
					                      <form:select class="form-control" path="precio_propiedad_minimo">
					                      	<form:option value ="-1" selected="selected">Precio mínimo</form:option>
					                        <form:option value="10">10 €</form:option>
					                        <form:option value="100">100 €</form:option>
					                        <form:option value="500">500 €</form:option>
					                        <form:option value="1000">1000€</form:option>
					                      </form:select>
									</div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<form:label path="area">Area</form:label>
					                      <form:select class="form-control" path="area">
					                      <form:option value ="-1" selected="selected">Area en m<sup>2</sup></form:option>
					                        <form:option value="50">50</form:option>
					                        <form:option value="70">70</form:option>
					                        <form:option value="100">100</form:option>
					                      </form:select>
									</div>
								</div>
								<div class="col-md-12 col-sm-12">
									<input class="btn btn-primary btn-lg btn-block" name="submit" type="submit" value="Search">
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- fin:header -->
	<!-- inicio:service -->
	<div id="service">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>Las mejores ofertas <small>Únete a nosotros, es sencillo</small></h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="service-container">
						<div class="service-icon">
							<a href="#"><i class="fa fa-home"></i></a>
						</div>
						<div class="service-content">
							<h3>Las mejores proiedades</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
						</div>
					</div>
				</div><!-- break -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="service-container">
						<div class="service-icon">
							<a href="#"><i class="fa fa-thumbs-up"></i></a>
						</div>
						<div class="service-content">
							<h3>Atención personalizada</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
						</div>
					</div>
				</div><!-- break -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="service-container">
						<div class="service-icon">
							<a href="#"><i class="fa fa-umbrella"></i></a>
						</div>
						<div class="service-content">
							<h3>Gran soporte técnico</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
						</div>
					</div>
				</div><!-- break -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="service-container">
						<div class="service-icon">
							<a href="#"><i class="fa fa-lock"></i></a>
						</div>
						<div class="service-content">
							<h3>Seguridad garantizada</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- fin:service -->
</jsp:body>
</t:paginabasica>