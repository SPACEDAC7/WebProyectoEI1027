<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nueva credencial">
	<jsp:body>
		<h2>Nova credencial</h2>
		<form:form method="post" modelAttribute="credencial">
			<table class="table table-condensed">
				<tr>
					<td><form:label path="id_credencial">ID. Credencial</form:label></td>
					<td><form:input path="id_credencial" readonly="true" /></td>
					<td><form:errors style="color:#F44336" path="id_credencial" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="nick_usuario">Nick</form:label></td>
					<td><form:input path="nick_usuario" /></td>
					<td><form:errors style="color:#F44336" path="nick_usuario" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
					<td><form:errors style="color:#F44336" path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="rol">Rol</form:label></td>
					<td>
						<form:select path="rol">
							<form:option value="---" selected="selected">Elige rol</form:option>
							<form:option value="administrador">Administrador</form:option>
          					<form:option value="inquilino">Inquilino</form:option>
          					<form:option value="propietario">Propietario</form:option>
          				</form:select>
	          		</td>
	          		<td><form:errors style="color:#F44336" path="rol" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-primary">Añadir credencial</button></td>
				</tr>
			</table>
		</form:form>
	</jsp:body>
</t:paginabasica>
