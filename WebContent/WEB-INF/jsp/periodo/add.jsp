<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:paginabasica title="Nuevo periodo">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Nuevo periodo</h2>
	<form:form method="post" modelAttribute="periodo">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_periodo">ID. Periodo</form:label></td>
				<td><form:input path="id_periodo" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_periodo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
			    <td><form:label path="fechaInicio">Fecha inicio: </form:label></td>
			    <td><form:input path="fechaInicio" class="datepicker"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaInicio" cssClass="error"/></td>
			</tr>
			<tr>
			    <td><form:label path="fechaFinal">Fecha inicio: </form:label></td>
			    <td><form:input path="fechaFinal" class="datepicker"></form:input></td>
			    <td><form:errors style="color:#F44336" path="fechaFinal" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Crear Periodo" />
				<a href="${pageContext.request.contextPath}/periodo/list.html"><input class="btn btn-danger" type="button" value="Cancelar"></a></td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>
<t:datepicker></t:datepicker> 
