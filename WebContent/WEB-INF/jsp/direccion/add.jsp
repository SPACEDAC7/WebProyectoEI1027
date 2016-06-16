<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva dirección">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Nueva Dirección</h2>
	<form:form method="post" modelAttribute="direccion">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input path="id_direccion" readonly="true"/></td>
				<td><form:errors style="color:#F44336"  path="id_direccion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="calle">Calle</form:label></td>
				<td><form:input path="calle" /></td>
				<td><form:errors style="color:#F44336"  path="calle" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="numero">Numero</form:label></td>
				<td><form:input path="numero" /></td>
				<td><form:errors style="color:#F44336"  path="numero" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="codigo_postal">Codigo Postal</form:label></td>
				<td><form:input path="codigo_postal" /></td>
				<td><form:errors style="color:#F44336"  path="codigo_postal" cssClass="error"/></td>
			</tr>
				<tr>
				<td><form:label path="localidad">Localidad</form:label></td>
				<td><form:input path="localidad" /></td>
				<td><form:errors style="color:#F44336"  path="localidad" cssClass="error"/></td>
			</tr>
				<tr>
				<td><form:label path="provincia">Provincia</form:label></td>
				<td><form:input path="provincia" /></td>
				<td><form:errors style="color:#F44336"  path="provincia" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-primary" type="submit" value="Afegeix direccion" />
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>
