<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ivaFactura" scope="request" value='${session.getAttribute("ivaFactura")}'/>
<t:paginabasica title="Modificar factura">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Modificar factura</h2>
	<form:form method="post" modelAttribute="factura">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_factura">ID. Factura</form:label></td>
				<td><form:input path="id_factura" readonly="true"/></td>
				<td><form:errors style="color:#F44336"  path="id_factura" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_reserva">ID. Reserva</form:label></td>
				<td><form:input path="id_reserva" /></td>
				<td><form:errors style="color:#F44336"  path="id_reserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="precio_factura">Precio Factura</form:label></td>
				<td><form:input path="precio_factura" /></td>
			</tr>
			<tr>
				<td><form:label path="iva">IVA</form:label></td>
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
					<td><form:label path="fechaString">Fecha: </form:label></td>
			    	<td><form:input path="fechaString" class="datepicker"></form:input></td>
			    	<td><form:errors style="color:#F44336"  cssClass="error" path="fechaString"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Actualizar Factura" />
				<a href="${pageContext.request.contextPath}/factura/list.html"><input class="btn btn-danger" type="button" value="Cancelar"></a></td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>
<t:datepicker></t:datepicker>