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
							<form role="form">
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<label for="ciudad">Ciudad</label><select class="form-control">
											<option>
												Castellon
											</option>
											<option>
												Valencia
											</option>
										</select>
									</div>
									<div class="form-group">
										<label for="habitaciones">Habitaciones</label><select class="form-control">
											<option>
												1
											</option>
											<option>
												2
											</option>
											<option>
												3
											</option>
											<option>
												4
											</option>
											<option>
												5
											</option>
										</select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<label for="tipo">Tipo</label><select class="form-control">
											<option>
												Apartamento
											</option>
											<option>
												Casa
											</option>
										</select>
									</div>
									<div class="form-group">
										<label for="camas">Camas</label><select class="form-control">
											<option>
												1
											</option>
											<option>
												2
											</option>
											<option>
												3
											</option>
											<option>
												4
											</option>
										</select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<label for="maxprice">Precio máximo</label><select class="form-control">
											<option>
												$8,200
											</option>
											<option>
												$11,700
											</option>
											<option>
												$14,150
											</option>
											<option>
												$21,110
											</option>
										</select>
									</div>
									<div class="form-group">
										<label for="capacidad">Capacidad</label><select class="form-control">
											<option>
												1
											</option>
											<option>
												2
											</option>
											<option>
												3
											</option>
											<option>
												4
											</option>
										</select>
									</div>
								</div><!-- break -->
								<div class="col-md-6 col-sm-6 col-xs-6">
									<div class="form-group">
										<label for="minprice">Precio mínimo</label><select class="form-control">
											<option>
												$4,200
											</option>
											<option>
												$6,700
											</option>
											<option>
												$8,150
											</option>
											<option>
												$11,110
											</option>
										</select>
									</div>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="form-group">
										<label for="servicios" style="display: block;">Servicios</label><label class="checkbox-inline"><input id="opcion1" type="checkbox" value="opcion_1">WiFi</label><label class="checkbox-inline"><input id="checkboxEnLinea1" type="checkbox" value="opcion2">Secador</label><label class="checkbox-inline"><input id="opcion1" type="checkbox" value="opcion_1">Cable</label><label class="checkbox-inline"><input id="opcion1" type="checkbox" value="opcion_1">Jacuzzi</label>
									</div>
								</div>
								<div class="col-md-12 col-sm-12">
									<input class="btn btn-primary btn-lg btn-block" name="submit" type="submit" value="Search">
								</div>
							</form>
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