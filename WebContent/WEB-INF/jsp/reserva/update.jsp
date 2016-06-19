<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Modificar reserva">
	<jsp:body>
	<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/reserva/list.html" class="active">GESTIÓN DE RESERVAS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/reserva/list.html"><i class="icon-custom-left"></i></a>
			<h3>Reservas - <span class="semi-bold">Modificar Reserva</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la reserva</span></h3>
	<form:form method="post" modelAttribute="reserva">
		<table class="table table-condensed">
			<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_reserva">ID. Reserva </form:label></td>
				<td><form:input class="form-control input-md" path="id_reserva" readonly="true" /></td>
				<td><form:errors style="color:#F44336" path="id_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input class="form-control input-md" path="id_usuario" /></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input class="form-control input-md" path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaReserva">Fecha Reserva</form:label></td>
				<td><form:input class="form-control input-md datepicker" path="fechaReserva"/></td>
				<td><form:errors style="color:#F44336" path="fechaReserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaCheckIn">Fecha Check In</form:label></td>
				<td><form:input class="form-control input-md datepicker" path="fechaCheckIn"/></td>
				<td><form:errors style="color:#F44336" path="fechaCheckIn" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaCheckOut">Fecha Check Out</form:label></td>
				<td><form:input class="form-control input-md datepicker" path="fechaCheckOut" /></td>
				<td><form:errors style="color:#F44336" path="fechaCheckOut" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="precio_reserva">Precio Reserva</form:label></td>
				<td><form:input class="form-control input-md" path="precio_reserva" /></td>
				<td><form:errors style="color:#F44336" path="precio_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="estado">Estado</form:label></td>
				<td><form:input class="form-control input-md" path="estado" /></td>
				<td><form:errors style="color:#F44336" path="estado" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Modificar Reserva" /></td>
 				<td><a href="${pageContext.request.contextPath}/reserva/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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