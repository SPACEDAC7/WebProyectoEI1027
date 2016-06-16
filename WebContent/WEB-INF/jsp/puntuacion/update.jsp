<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Modificar Puntuación">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Modificar puntuacion</h2>
	<form:form method="post" modelAttribute="puntuacion">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_puntuacion">ID. Puntuacion </form:label></td>
				<td><form:input path="id_puntuacion" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="id_puntuacion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad</form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input path="id_usuario" /></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="valor_puntuacion">Valor Puntuacion</form:label></td>
				<td><form:input path="valor_puntuacion" /></td>
			</tr>
			<tr>
				<td><form:label path="comentario">Comentario</form:label></td>
				<td><form:input path="comentario" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modificar puntuacion" />
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>