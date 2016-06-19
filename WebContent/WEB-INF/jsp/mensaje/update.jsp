<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Modificar Mensaje">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/mensaje/list.html" class="active">GESTIÓN DE MENSAJES</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/mensaje/list.html"><i class="icon-custom-left"></i></a>
			<h3>Mensajes - <span class="semi-bold">Modificar mensaje</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos del mensaje</span></h3>
	<form:form method="post" modelAttribute="mensaje">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_mensaje">ID. Mensaje</form:label></td>
				<td><form:input path="id_mensaje" readonly="true" /></td>
				<td><form:errors style="color:#F44336"  path="id_mensaje" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_emisor">Id. Emisor </form:label></td>
				<td><form:input class="form-control input-md" path="id_emisor" /></td>
				<td><form:errors style="color:#F44336" path="id_emisor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_receptor">Id. Receptor </form:label></td>
				<td><form:input class="form-control input-md"  path="id_receptor" /></td>
				<td><form:errors style="color:#F44336" path="id_receptor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="asunto">Asunto</form:label></td>
				<td><form:input class="form-control input-md" path="asunto" /></td>
				<td><form:errors style="color:#F44336" path="asunto" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="contenido">Contenido </form:label></td>
				<td><form:input class="form-control input-md" path="contenido" /></td>
				<td><form:errors style="color:#F44336" path="contenido" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="estado_vision">Estado Vision</form:label></td>
				<td><form:input class="form-control input-md" path="estado_vision" /></td>
				<td><form:errors style="color:#F44336" path="estado_vision" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Modificar Mensaje" /></td>
 				<td><a href="${pageContext.request.contextPath}/mensaje/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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