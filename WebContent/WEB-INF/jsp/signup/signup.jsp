<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Sign-Up">
	<jsp:body>
    <div style="margin-bottom:20px" class="container">
    <h2>Bienvenid@ a EasyRent, va a crear un nuevo usuario</h2>
	<form:form method="post" modelAttribute="nuevaCredencial">
		<table class="table table-condensed">
			<tr>
				<td><form:label path="nick_usuario">Nick</form:label></td>
				<td><form:input class="form-control" path="nick_usuario" /></td>
				<td><form:errors style="color:#F44336" path="nick_usuario" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password class="form-control" path="password" /></td>
				<td><form:errors style="color:#F44336" path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="rol">Rol</form:label></td>
				<td>
					<form:select path="rol" class="form-control">
						<form:option value="---" selected="selected">Elige rol</form:option>
     					<form:option value="inquilino">Inquilino</form:option>
          				<form:option value="propietario">Propietario</form:option>
          			</form:select>
	          	</td>
	          	<td><form:errors style="color:#F44336"  path="rol" /></td>
			</tr>
		</table>
        	<tr>
        		<td>
        			<input type="submit" class="btn btn-primary" value="Siguiente" />
        		</td>
        		<td>
        			<a href="${pageContext.request.contextPath}/"> <input type="button" class="btn btn-primary" value="Cancelar" /></a>
        		</td>
        	</tr>
    </form:form>
    </div>
    </jsp:body>
</t:paginabasica>