<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Nueva Propiedad">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/propiedad/list.html" class="active">GESTIÓN DE PROPIEDADES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/propiedad/list.html"><i class="icon-custom-left"></i></a>
			<h3>Propiedades - <span class="semi-bold">Añadir propiedad</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la propiedad</span></h3>
	<form:form action="${pageContext.request.contextPath}/propiedad/anadirDireccionAPropiedad.html" method="post" modelAttribute="nuevaPropiedadPropietario">
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
				<td>
					<form:select class="form-control selectpicker" path="tipo">
						<form:option value="chalet" selected="selected">Chalet</form:option>
						<form:option value="mansion">Mansión</form:option>
						<form:option value="piso">Piso</form:option>
						<form:option value="casa">Casa</form:option>
          			</form:select>
          		</td>
				<td><form:errors style="color:#F44336" path="tipo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="capacidad">Capacidad</form:label></td>
				<td>
					<form:select class="form-control selectpicker" path="capacidad">
						<form:option value="1" selected="selected">1 persona</form:option>
						<c:forEach var="i" begin="2" end="20">
							<form:option value="${i}"><c:out value="${i}"/> personas</form:option>
						</c:forEach>
          			</form:select>
	          	</td>
				<td><form:errors style="color:#F44336" path="capacidad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="num_habitaciones">Num. Habitaciones</form:label></td>
				<td>
					<form:select class="form-control selectpicker" path="num_habitaciones">
						<form:option value="1" selected="selected">1 habitaci&oacute;n</form:option>
						<c:forEach var="i" begin="2" end="10">
							<form:option value="${i}"><c:out value="${i}"/> habitaciones</form:option>
						</c:forEach>
          			</form:select>
	          	</td>
				<td><form:errors style="color:#F44336" path="num_habitaciones" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="num_camas">Num. Camas</form:label></td>
				<td>
					<form:select class="form-control selectpicker" path="num_camas">
						<form:option value="1" selected="selected">1 cama</form:option>
						<c:forEach var="i" begin="2" end="20">
							<form:option value="${i}"><c:out value="${i}"/> camas</form:option>
						</c:forEach>
          			</form:select>
	          	</td>
				<td><form:errors style="color:#F44336" path="num_camas" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="area">Area</form:label></td>
				<td><form:input class="form-control input-md" path="area" /></td><td> m<sup>2</sup><td>
				<td><form:errors style="color:#F44336" path="area" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="precio_propiedad">Precio</form:label></td>
				<td><form:input class="form-control input-md" path="precio_propiedad" /></td><td> €<td>
				<td><form:errors style="color:#F44336" path="precio_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="url_mapa">URL Mapa</form:label></td>
				<td><form:input class="form-control input-md" path="url_mapa" /></td>
				<td><form:errors style="color:#F44336" path="url_mapa" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:checkboxes items="${servicios}" path="servicios" /></td>
				<td><form:errors path="servicios" cssClass="error" /></td> 
			</tr>
			<tr>
				<td>
					<td><input class="btn btn-primary btn-cons" type="submit" value="Siguiente" />
 					<a href="${pageContext.request.contextPath}/propiedad/misPropiedades.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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
