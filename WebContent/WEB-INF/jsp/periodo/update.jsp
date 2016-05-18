<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Actualizar periodo">
	<jsp:body>
	<h2>Modificar periodo</h2>
	<form:form method="post" modelAttribute="periodo">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_periodo">ID. Periodo</form:label></td>
				<td><form:input path="id_periodo" /></td>
				<td><form:errors path="id_periodo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input path="id_propiedad" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaInicio">Inicio </form:label></td>
				<td><form:input type="date" path="fechaInicio" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaFinal">Fin</form:label></td>
				<td><form:input type="date" path="fechaFinal" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar periodo" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>