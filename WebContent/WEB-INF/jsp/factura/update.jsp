<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ivaFactura" scope="request" value='${session.getAttribute("ivaFactura")}'/>
<t:paginabasica title="Modificar factura">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="#" class="active">GESTIÓN DE FACTURAS</a> </li>
		</ul>
		<div class="page-title"> <i class="icon-custom-left"></i>
			<h3>Facturas - <span class="semi-bold">Modificar factura</span></h3>
		</div>
			<div class="row">
			<div class="grid simple">
				<div class="grid-body no-border">
					<div class="row-fluid">
						<div class="col-md-12">
	<form:form class="form-horizontal col-md-8 col-xs-8" method="post" modelAttribute="factura">
		<legend><h3><span class="semi-bold">Datos de la factura</span></h3></legend>
								<fieldset>
		
		<div class="form-group">
		<form:label class="col-md-3 col-xs-5 control-label" path="id_factura">ID. Factura</form:label>
		<div class="input-group transparent col-md-9 col-xs-9">
			<form:input type="text" path="id_factura" placeholder="Introduce el id de factura" class="form-control input-md"></form:input>
			<span class="input-group-addon "><i class="fa fa-pencil"></i></span>
			<form:errors style="color:#F44336"  path="id_factura" cssClass="error"/>
		</div>
		</div>
		<div class="form-group">
		<form:label class="col-md-3 col-xs-5 control-label" path="fechaString">Fecha</form:label>  
		<div class="input-group transparent col-md-9 col-xs-9">
			<form:input path="fechaString" class="form-control input-md datepicker"></form:input>
			<form:errors style="color:#F44336"  cssClass="error" path="fechaString"/>
		</div>
		</div>
		<div class="form-group">
			<div class="pull-right">
				<button type="submit" class="btn btn-primary btn-cons">Actualizar</button>
				<button type="button" class="btn btn-default btn-cons">Cancelar</button>
			</div>
		</div>
		
		</fieldset>
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