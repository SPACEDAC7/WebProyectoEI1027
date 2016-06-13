<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva factura">
	<jsp:body>
	<h2>Nueva Factura</h2>
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
			</tr>
			<tr>
				<td><form:label path="precio_factura">Precio Factura</form:label></td>
				<td><form:input path="precio_factura" /></td>
			</tr>
				<tr>
				<td><form:label path="iva">IVA</form:label></td>
				<td><form:input path="iva" /></td>
			</tr>
			<tr>
				<td><form:label path="dia">Día</form:label></td>
				<td><form:input path="dia" /></td>
				<td><form:label path="mes">Mes</form:label></td>
				<td><form:input path="mes" /></td>
				<td><form:label path="ano">Año</form:label></td>
				<td><form:input path="ano" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix factura" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>