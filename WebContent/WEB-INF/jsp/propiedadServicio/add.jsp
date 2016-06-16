<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nuevo servicio de una propiedad">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Nova propiedad servicio</h2>
	<form:form method="post" modelAttribute="propiedadServicio">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad"/></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_servicio">ID. Servicio</form:label></td>
				<td><form:input path="id_servicio" /></td>
				<td><form:errors style="color:#F44336" path="id_servicio" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix propiedad servicio" />
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>