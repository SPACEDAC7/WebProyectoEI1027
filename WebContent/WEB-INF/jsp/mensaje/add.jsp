<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nuevo Mensaje">
	<jsp:body>
	<h2>Nou mensaje</h2>
	<form:form method="post" modelAttribute="mensaje">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_mensaje">ID. Mensaje</form:label></td>
				<td><form:input path="id_mensaje" readonly="true" /></td>
				<td><form:errors path="id_mensaje" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_emisor">Id. Emisor </form:label></td>
				<td><form:input path="id_emisor" /></td>
				<td><form:errors path="id_emisor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_receptor">Id. Receptor </form:label></td>
				<td><form:input path="id_receptor" /></td>
				<td><form:errors path="id_receptor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="asunto">Asunto</form:label></td>
				<td><form:input path="asunto" /></td>
			</tr>
			<tr>
				<td><form:label path="contenido">Contenido </form:label></td>
				<td><form:input path="contenido" /></td>
			</tr>
			<tr>
				<td><form:label path="estado_vision">Estado Vision</form:label></td>
				<td><form:input path="estado_vision" /></td>
				<td><form:errors path="estado_vision" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix mensaje" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>