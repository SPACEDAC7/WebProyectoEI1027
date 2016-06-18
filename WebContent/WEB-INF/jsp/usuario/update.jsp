<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:datepicker></t:datepicker>
<t:paginabasica title="Modificar usuario">
	<jsp:body>
<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/usuario/list.html" class="active">GESTIÓN DE USUARIOS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/usuario/list.html"><i class="icon-custom-left"></i></a>
			<h3>Usuarios - <span class="semi-bold">Modificar usuario</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos del usuario</span></h3>
	<form:form method="post" modelAttribute="usuario">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input class="form-control input-md" path="id_usuario" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_credencial">Id. Credencial </form:label></td>
				<td><form:input class="form-control input-md" path="id_credencial"/></td>
				<td><form:errors style="color:#F44336" path="id_credencial" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="url_imagen_perfil">Url Imagen Perfil </form:label></td>
				<td><form:input class="form-control input-md" path="url_imagen_perfil" /></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="nombre">Nombre </form:label></td>
				<td><form:input class="form-control input-md" path="nombre" /></td>
				<td><form:errors style="color:#F44336" path="nombre" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="apellido">Apellido</form:label></td>
				<td><form:input class="form-control input-md" path="apellido" /></td>
				<td><form:errors style="color:#F44336" path="apellido" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="nif">NIF</form:label></td>
				<td><form:input class="form-control input-md" path="nif" /></td>
				<td><form:errors style="color:#F44336" path="nif" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="email">Email</form:label></td>
				<td><form:input class="form-control input-md" path="email" /></td>
				<td><form:errors style="color:#F44336" path="email" cssClass="error"/></td>
			</tr>
			<tr> 
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input class="form-control input-md" path="id_direccion" /></td>
				<td><form:errors style="color:#F44336" path="id_direccion" cssClass="error"/></td>
			</tr>
			<tr>
			    <td><form:label class="col-md-3 col-xs-5 control-label" path="fechaRegistro">Fecha: </form:label></td>
			    <td><form:input path="fechaRegistro" class="form-control input-md datepicker"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaRegistro" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="telefono">Telefono</form:label></td>
				<td><form:input class="form-control input-md" path="telefono" /></td>
				<td><form:errors style="color:#F44336" path="telefono" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="estado_usuario">Estado usuario: </form:label></td>
				<td><form:select class="form-control selectpicker" path="estado_usuario">
						<form:option value="true" selected="selected">Habilitado</form:option>
						<form:option value="false">Deshabilitado</form:option>
          			</form:select>
          		</td>
				<td><form:errors style="color:#F44336" path="estado_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Modificar Usuario" /></td>
 				<td><a href="${pageContext.request.contextPath}/usuario/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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