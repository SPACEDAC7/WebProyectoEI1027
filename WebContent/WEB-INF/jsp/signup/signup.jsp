<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Sign-Up">
	<jsp:body>
    <h2>Sign-Up</h2>
    <form:form method="post" modelAttribute="usuario">
		 <table class="table table-condensed">
		 	<tr>
		 		<td><form:label path="nickUsuario">Nombre de usuario:</form:label></td>
            	<td><form:input class="form-control" path="nickUsuario" /></td>
            	<td><form:errors path="nickUsuario" cssClass="error" /></td>
		 	</tr>
		 	<tr>
		 		<td><form:label path="passwordUsuario">Password:</form:label></td>
            	<td><form:password class="form-control" path="passwordUsuario" /></td>
            	<td><form:errors path="passwordUsuario" cssClass="error" /></td>
		 	</tr>
        	<tr>
        		<td><form:label path="nombre">Nombre:</form:label></td>
            	<td><form:input class="form-control" path="nombre" /></td>
            	<td><form:errors path="nombre" cssClass="error" /></td>
        	</tr>
            <tr>
        		<td><form:label path="apellido">Apellidos:</form:label></td>
            	<td><form:input class="form-control" path="apellido" /></td>
            	<td><form:errors path="apellido" cssClass="error" /></td>
        	</tr>
            <tr>
        		<td><form:label path="nif">NIF:</form:label></td>
            	<td><form:input class="form-control" path="nif" /></td>
            	<td><form:errors path="nif" cssClass="error" /></td>
        	</tr>
            <tr>
        		<td><form:label path="email">E-mail:</form:label></td>
            	<td><form:input class="form-control" path="email" /></td>
            	<td><form:errors path="email" cssClass="error" /></td>
        	</tr>
            <tr>
        		<td><form:label path="telefono">Teléfono:</form:label></td>
            	<td><form:input class="form-control" path="telefono" /></td>
            	<td><form:errors path="telefono" cssClass="error" /></td>
        	</tr>
			<tr>
				<td><form:label path="rol">Rol</form:label></td>
				<td>
					<form:select path="rol">
						<form:option value="---" selected="selected">Elige rol</form:option>
          				<form:option value="inquilino">Inquilino</form:option>
          				<form:option value="propietario">Propietario</form:option>
          			</form:select>
	        	</td>
	        	<td><form:errors path="rol" /></td>
			</tr>
        	<tr>
        		<td>
        			<input type="submit" class="btn btn-primary" value="Nuevo Usuario" />
        		</td>
        	</tr>
        </table>
    </form:form>
    </jsp:body>
</t:paginabasica>