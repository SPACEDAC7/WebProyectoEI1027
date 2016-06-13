<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nuevo servicio">
	<jsp:body>
	<h2>Nuevo servicio</h2>
	<form:form method="post" modelAttribute="servicio">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="idServicio">ID. Servicio</form:label></td>
				<td><form:input path="idServicio" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="idServicio" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nombreServicio">Nombre servicio</form:label></td>
				<td><form:input path="nombreServicio" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Añadir servicio" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>
