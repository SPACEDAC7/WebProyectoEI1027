<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Actualizar credencial">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><hr></li>
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/propiedad/misPropiedades.html" class="active">GESTIÓN DE PROPIEDADES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/propiedad/misPropiedades.html"><i class="icon-custom-left"></i></a>
			<h3><span class="semi-bold">Modificar propiedad</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la propiedad</span></h3>
		
		
		<a href="${pageContext.request.contextPath}/propiedad/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
		<a href="${pageContext.request.contextPath}/imagen/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
		
	<form:form method="post" modelAttribute="propiedadAModificar">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="titulo">Titulo </form:label></td>
				<td><form:input class="form-control input-md" path="titulo" /></td>
				<td><form:errors style="color:#F44336" path="titulo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="descripcion">Descripcion</form:label></td>
				<td><form:input class="form-control input-md" path="descripcion" /></td>
				<td><form:errors style="color:#F44336" path="descripcion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="tipo">Tipo</form:label></td>
				<td><form:input class="form-control input-md" path="tipo" /></td>
				<td><form:errors style="color:#F44336" path="tipo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="capacidad">Capacidad</form:label></td>
				<td>
						<form:select class="form-control selectpicker" path="capacidad">
						 	<form:option value="1">1 persona</form:option>
							<form:option value="2">2 personas</form:option>
							<form:option value="3">3 personas</form:option>
							<form:option value="4" selected="selected">4 personas</form:option>
							<form:option value="5">5 personas</form:option>
							<form:option value="6">6 personas</form:option>
							<form:option value="7">7 personas</form:option>
							<form:option value="8">8 personas</form:option>
							<form:option value="9">9 personas</form:option>
							<form:option value="10">10 personas</form:option>
							<form:option value="11">11 personas</form:option>
							<form:option value="12">12 personas</form:option>
							<form:option value="13">13 personas</form:option>
							<form:option value="14">14 personas</form:option>
							<form:option value="15">15 personas</form:option>
							<form:option value="16">16 personas</form:option>
							<form:option value="17">17 personas</form:option>
							<form:option value="18">18 personas</form:option>
							<form:option value="19">19 personas</form:option>
							<form:option value="20">20 personas</form:option>
          				</form:select>
	          		</td>
				<td><form:errors style="color:#F44336" path="capacidad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="num_habitaciones">Num. Habitaciones</form:label></td>
				<td><form:input class="form-control input-md" path="num_habitaciones" /></td>
				<td><form:errors style="color:#F44336" path="num_habitaciones" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="num_camas">Num. Camas</form:label></td>
				<td><form:input class="form-control input-md" path="num_camas" /></td>
				<td><form:errors style="color:#F44336" path="num_camas" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="area">Area</form:label></td>
				<td><form:input class="form-control input-md" path="area" /></td>
				<td><form:errors style="color:#F44336" path="area" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="precio_propiedad">Precio</form:label></td>
				<td><form:input class="form-control input-md" path="precio_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="precio_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="url_mapa">URL Mapa</form:label></td>
				<td><form:input class="form-control input-md" path="url_mapa" /></td>
				<td><form:errors style="color:#F44336" path="url_mapa" cssClass="error"/></td>
			</tr>
			<tr>
 				<td><button class="btn btn-primary" onClick="location.href='updatePropietario/${propiedadAModificar.id_propiedad}.html'" type="submit">Actualizar</button>
 				<a href="${pageContext.request.contextPath}/propiedad/misPropiedades.html"><input class="btn btn-danger" type="button" value="Cancelar"></a>
 				</td>
 			</tr>
		</table>
	</form:form>
	</div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</jsp:body>
</t:paginabasica>