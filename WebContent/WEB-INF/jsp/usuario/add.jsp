<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nuevo usuario">
	<jsp:body>
	<h2>Nou usuario</h2>
	<form:form method="post" modelAttribute="usuario">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="id_usuario">ID. Usuario</form:label></td>
				<td><form:input path="id_usuario" readonly="true" /></td>
				<td><form:errors style="color:#F44336" path="id_usuario" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_credencial">Id. Credencial </form:label></td>
				<td><form:input path="id_credencial" /></td>
			</tr>
			<tr>
				<td><form:label path="url_imagen_perfil">Url Imagen Perfil </form:label></td>
				<td><form:input path="url_imagen_perfil" /></td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre </form:label></td>
				<td><form:input path="nombre" /></td>
			</tr>
			<tr>
				<td><form:label path="apellido">Apellido</form:label></td>
				<td><form:input path="apellido" /></td>
			</tr>
			<tr>
				<td><form:label path="nif">NIF</form:label></td>
				<td><form:input path="nif" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input path="id_direccion" /></td>
			</tr>
			<tr>
				<td><form:label path="fechaRegistro">Fecha Registro</form:label></td>
				<td><form:input type="date" path="fechaRegistro" /></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Telefono</form:label></td>
				<td><form:input path="telefono" /></td>
			</tr>
			<tr>
				<td><form:label path="estado_usuario">Estado usuario</form:label></td>
				<td><form:input path="estado_usuario" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Afegeix usuario" />
				</td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>
