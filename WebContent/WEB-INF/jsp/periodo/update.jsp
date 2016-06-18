<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:paginabasica title="Actualizar periodo">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/periodo/list.html" class="active">GESTIÓN DE PERIODOS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/periodo/list.html"><i class="icon-custom-left"></i></a>
			<h3>Periodo - <span class="semi-bold">Modificar periodo</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos del periodo</span></h3>
	<form:form method="post" modelAttribute="periodo">
			<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_periodo">ID. Periodo</form:label></td>
				<td><form:input class="form-control input-md" path="id_periodo" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_periodo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input class="form-control input-md" path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
			    <td><form:label class="col-md-3 col-xs-5 control-label" path="fechaInicio">Fecha inicio: </form:label></td>
			    <td><form:input class="form-control input-md datepicker" path="fechaInicio"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaInicio" cssClass="error"/></td>
			</tr>
			<tr>
			    <td><form:label class="col-md-3 col-xs-5 control-label" path="fechaFinal">Fecha inicio: </form:label></td>
			    <td><form:input class="form-control input-md datepicker" path="fechaFinal"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaFinal" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Añadir Periodo" /></td>
 				<td><a href="${pageContext.request.contextPath}/periodo/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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
<t:datepicker></t:datepicker> 