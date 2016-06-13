<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva respuesta">
	<jsp:body>
	<h2>Nova respuesta</h2>
	<form:form method="post" modelAttribute="respuestaPuntuacion">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_respuesta">ID. Respuesta </form:label></td>
				<td><form:input path="id_respuesta" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_respuesta" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_puntuacion">ID. Puntuacion</form:label></td>
				<td><form:input path="id_puntuacion" /></td>
				<td><form:errors style="color:#F44336" path="id_puntuacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="respuesta">Respuesta</form:label></td>
				<td><form:input path="respuesta" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix respuesta" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>
