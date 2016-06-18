<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Modificar servicio">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>EST�S AQU�</p></li>
			<li><a href="${pageContext.request.contextPath}/servicio/list.html" class="active">GESTI�N DE SERVICIOS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/servicio/list.html"><i class="icon-custom-left"></i></a>
			<h3>Servicios - <span class="semi-bold">Modificar servicio</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos del servicio</span></h3>
	<form:form method="post" modelAttribute="servicio">
		<table class="table table-condensed">
			<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="idServicio">ID. Servicio</form:label></td>
				<td><form:input class="form-control input-md" path="idServicio" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="idServicio" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="nombreServicio">Nombre servicio</form:label></td>
				<td><form:input class="form-control input-md" path="nombreServicio" /></td>
				<td><form:errors style="color:#F44336" path="nombreServicio" /></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Modificar Servicio" /></td>
 				<td><a href="${pageContext.request.contextPath}/servicio/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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