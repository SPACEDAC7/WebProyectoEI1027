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
				<td><form:errors style="color:#F44336" path="id_credencial" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="url_imagen_perfil">Url Imagen Perfil </form:label></td>
				<td><form:input path="url_imagen_perfil" /></td>
				<td><form:errors style="color:#F44336" path="url_imagen_perfil" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="nombre">Nombre </form:label></td>
				<td><form:input path="nombre" /></td>
				<td><form:errors style="color:#F44336" path="nombre" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="apellido">Apellido</form:label></td>
				<td><form:input path="apellido" /></td>
				<td><form:errors style="color:#F44336" path="apellido" cssClass="error"/></td>	
			</tr>
			<tr>
				<td><form:label path="nif">NIF</form:label></td>
				<td><form:input path="nif" /></td>
				<td><form:errors style="color:#F44336" path="nif" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors style="color:#F44336" path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="id_direccion">ID. Direccion</form:label></td>
				<td><form:input path="id_direccion" /></td>
				<td><form:errors style="color:#F44336" path="id_direccion" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="telefono">Telefono</form:label></td>
				<td><form:input path="telefono" /></td>
				<td><form:errors style="color:#F44336" path="telefono" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="estado_usuario">Estado usuario: </form:label></td>
				<td>
					<form:select path="estado_usuario">
						<form:option value="false">Deshabilitado</form:option>
						<form:option value="true" selected="selected">Habilitado</form:option>	
          			</form:select>
          		</td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Crear Usuario" />
				<a href="${pageContext.request.contextPath}/usuario/list.html"><input class="btn btn-danger" type="button" value="Cancelar"></a></td>
			</tr>
		</table>
	</form:form>
	</jsp:body>
</t:paginabasica>
