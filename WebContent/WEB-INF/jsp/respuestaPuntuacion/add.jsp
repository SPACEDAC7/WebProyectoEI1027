<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva respuesta">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html" class="active">GESTIÓN DE RESPUESTAS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html"><i class="icon-custom-left"></i></a>
			<h3>Respuestas - <span class="semi-bold">Añadir respuesta</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la respuesta</span></h3>
	<form:form method="post" modelAttribute="respuestaPuntuacion">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_respuesta">ID. Respuesta </form:label></td>
				<td><form:input class="form-control input-md" path="id_respuesta" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_respuesta" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_puntuacion">ID. Puntuacion</form:label></td>
				<td><form:input class="form-control input-md" path="id_puntuacion" /></td>
				<td><form:errors style="color:#F44336" path="id_puntuacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="respuesta">Respuesta</form:label></td>
				<td><form:input class="form-control input-md" path="respuesta" /></td>
				<td><form:errors style="color:#F44336" path="respuesta" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Añadir Respuesta" /></td>
 				<td><a href="${pageContext.request.contextPath}/respuestaPuntacion/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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
