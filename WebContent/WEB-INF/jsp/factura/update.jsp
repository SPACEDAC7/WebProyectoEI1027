<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:datepicker></t:datepicker>
<t:paginabasica title="Modificar factura">
	<jsp:body>
	<h2>Modificar factura</h2>
	<form:form method="post" modelAttribute="factura">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_factura">ID. Factura</form:label></td>
				<td><form:input path="id_factura" /></td>
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
					<td><form:label path="fechaString">Fecha: </form:label></td>
			    	<td><form:input path="fechaString" id="datepicker"></form:input></td>
			    	<td><form:errors style="color:#F44336"  cssClass="error" path="fechaString"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Crear Factura" />
				<a href="${pageContext.request.contextPath}/factura/list.html"><input class="btn btn-danger" type="button" value="Cancelar"></a></td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>