<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva credencial">
	<jsp:body>
		<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/credencial/list.html" class="active">GESTIÓN DE CREDENCIALES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/credencial/list.html"><i class="icon-custom-left"></i></a>
			<h3>Credenciales - <span class="semi-bold">Añadir credencial</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la credencial</span></h3>
		<form:form method="post" modelAttribute="credencial">
			<table class="table table-condensed">
				<tr>
					<td><form:label class="col-md-3 col-xs-5 control-label" path="id_credencial">ID. Credencial</form:label></td>
					<td><form:input class="form-control input-md" path="id_credencial" readonly="true" /></td>
					<td><form:errors style="color:#F44336" path="id_credencial" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label class="col-md-3 col-xs-5 control-label" path="nick_usuario">Nick </form:label></td>
					<td><form:input class="form-control input-md" path="nick_usuario" /></td>
					<td><form:errors style="color:#F44336" path="nick_usuario" /></td>
				</tr>
				<tr>
					<td><form:label class="col-md-3 col-xs-5 control-label" path="password">Password </form:label></td>
					<td><form:input class="form-control input-md" path="password" /></td>
					<td><form:errors style="color:#F44336" path="password" /></td>
				</tr>
				<tr>
					<td><form:label class="col-md-3 col-xs-5 control-label" path="rol">Rol</form:label></td>
					<td>
						<form:select class="form-control selectpicker" path="rol">
							<form:option value="---" selected="selected">Elige rol</form:option>
							<form:option value="administrador">Administrador</form:option>
          					<form:option value="inquilino">Inquilino</form:option>
          					<form:option value="propietario">Propietario</form:option>
          				</form:select>
	          		</td>
	          		<td><form:errors style="color:#F44336" path="rol" /></td>
				</tr>
				<tr>
 				<td><input class="btn btn-primary btn-cons" type="submit" value="Añadir Credencial" /></td>
 				<td><a href="${pageContext.request.contextPath}/credencial/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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
