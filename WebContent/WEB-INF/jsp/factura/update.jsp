<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ivaFactura" scope="request" value='${session.getAttribute("ivaFactura")}'/>
<t:paginabasica title="Modificar factura">
	<jsp:body>
<div style="margin-bottom:20px;background:white;margin-left:250px" class="container">
		<ul class="breadcrumb">
			<li><p>ESTÁS AQUÍ</p></li>
			<li><a href="${pageContext.request.contextPath}/factura/list.html" class="active">GESTIÓN DE FACTURAS</a> </li>
		</ul>
		<div class="page-title"><a href="${pageContext.request.contextPath}/factura/list.html"><i class="icon-custom-left"></i></a>
			<h3>Facturas - <span class="semi-bold">Modificar factura</span></h3>
		</div>
		 <div class="row">
		<div class="grid simple">
		<div class="grid-body no-border">
		<div class="row-fluid">
		<div class="col-md-12">
		<h3><span class="semi-bold">Datos de la factura</span></h3>
 	<form:form class="form-horizontal col-md-8 col-xs-8" method="post" modelAttribute="factura">
 		<table class="table table-condensed">
 			<tr>
 				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_factura">ID. Factura</form:label></td>
 				<td><form:input class="form-control input-md" path="id_factura" readonly="true"></form:input></td>
 				<td><form:errors style="color:#F44336"  path="id_factura" cssClass="error"/></td>
 			</tr>
 			<tr>
 				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_reserva">ID. Reserva</form:label></td>
 				<td><form:input class="form-control input-md" path="id_reserva" /></td>
 				<td><form:errors style="color:#F44336"  path="id_reserva" cssClass="error"/></td>
 			</tr>
 			<tr>
 				<td><form:label class="col-md-3 col-xs-5 control-label" path="precio_factura">Precio Factura</form:label></td>
 				<td><form:input class="form-control input-md" path="precio_factura" /></td>
 				<td><form:errors style="color:#F44336"  path="precio_factura" cssClass="error"/></td>
 			</tr>
 			<tr>
 				<td><form:label class="col-md-3 col-xs-5 control-label" path="iva">IVA</form:label></td>
 				<td><form:select path="iva">
 				<c:choose>
 					<c:when test='${ivaFactura == "21"}'>
 						<form:option value="21" selected="selected">21%</form:option>
 						<form:option value="10">10%</form:option>
 					</c:when>
 					<c:otherwise>
 						<form:option value="21">21%</form:option>
 						<form:option value="10" selected="selected">10%</form:option>
 					</c:otherwise>
 				</c:choose>	
        			</form:select>
         		</td>
 			</tr>
 			<tr>
 					<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaString">Fecha: </form:label></td>
 			    	<td><form:input class="form-control input-md datepicker" path="fechaString"></form:input></td>
 			    	<td><form:errors style="color:#F44336"  cssClass="error" path="fechaString"/></td>
 			</tr>
 			
 			<tr>
 				<td><input class="btn btn-primary btn-cons" type="submit" value="Actualizar Factura" /></td>
 				<td><a href="${pageContext.request.contextPath}/factura/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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