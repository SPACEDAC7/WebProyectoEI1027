<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Actualizar credencial">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/propiedad/list.html" class="active">GESTIÓN DE PROPIEDADES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/propiedad/list.html"><i class="icon-custom-left"></i></a>
			<h3>Propiedades - <span class="semi-bold">Modificar propiedad</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la propiedad</span></h3>
	<form:form method="post" modelAttribute="propiedad">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input class="form-control input-md" path="id_propiedad" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input class="form-control input-md" path="id_usuario" /></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
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
				<td><form:input class="form-control input-md" path="capacidad" /></td>
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
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input class="form-control input-md" path="id_direccion" /></td>
				<td><form:errors style="color:#F44336" path="id_direccion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="url_mapa">URL Mapa</form:label></td>
				<td><form:input class="form-control input-md" path="url_mapa" /></td>
				<td><form:errors style="color:#F44336" path="url_mapa" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Modificar Propiedad" /></td>
 				<td><a href="${pageContext.request.contextPath}/propiedad/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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