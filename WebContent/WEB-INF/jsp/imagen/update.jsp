<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Modificar imagen">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h2>Modificar imagen</h2>
	<form:form method="post" modelAttribute="imagen">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_imagen">ID. Imagen</form:label></td>
				<td><form:input path="id_imagen" /></td>
				<td><form:errors style="color:#F44336"  path="id_imagen" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_propiedad">ID. Propiedad </form:label></td>
				<td><form:input path="id_propiedad" /></td>
				<td><form:errors style="color:#F44336" path="id_propiedad" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="pie_foto">Pie de foto </form:label></td>
				<td><form:input path="pie_foto" /></td>
			</tr>
			<tr>
				<td><form:label path="referencia">Referencia</form:label></td>
				<td><form:input path="referencia" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Actualizar imagen" />
				</td>
			</tr>
		</table>
	</form:form>
	</div>
	</jsp:body>
</t:paginabasica>