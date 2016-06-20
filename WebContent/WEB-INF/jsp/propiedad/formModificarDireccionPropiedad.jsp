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

		
	<form:form action="${pageContext.request.contextPath}/propiedad/finalizarModificarPropiedad.html" method="post" modelAttribute="direccionAModificar">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="calle">Calle</form:label></td>
				<td><form:input class="form-control input-md" path="calle" /></td>
				<td><form:errors style="color:#F44336"  path="calle" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="numero">Número</form:label></td>
				<td><form:input class="form-control input-md" path="numero" /></td>
				<td><form:errors style="color:#F44336"  path="numero" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="codigo_postal">Código Postal</form:label></td>
				<td><form:input class="form-control input-md" path="codigo_postal" /></td>
				<td><form:errors style="color:#F44336"  path="codigo_postal" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="provincia">Provincia</form:label></td>
				<td><form:input class="form-control input-md" path="provincia" /></td>
				<td><form:errors style="color:#F44336"  path="provincia" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="localidad">Localidad</form:label></td>
				<td><form:input class="form-control input-md" path="localidad" /></td>
				<td><form:errors style="color:#F44336"  path="localidad" cssClass="error"/></td>
			</tr>
			<tr>
				<td>
				<c:set var="propiedad" scope="request" value='${session.getAttribute("propiedadAModificar")}' />
				<a onclick="history.back()"><input class="btn btn-danger" type="button" value="Atrás"></a>
 				<input class="btn btn-primary btn-cons" type="submit" value="Finalizar" />
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