<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Sign-Up">
	<jsp:body>
    <h2>Diganos sus datos</h2>
	<form:form action="${pageContext.request.contextPath}/signup/addUsuario.html" method="post" modelAttribute="nuevoUsuario">
		<table class="table table-condensed">
	        		<tr>
        				<td><form:label path="nombre">Nombre:</form:label></td>
            			<td><form:input class="form-control" path="nombre" /></td>
            			<td><form:errors style="color:#F44336" path="nombre" cssClass="error" /></td>
        			</tr>
            		<tr>
        				<td><form:label path="apellido">Apellidos:</form:label></td>
            			<td><form:input class="form-control" path="apellido" /></td>
            			<td><form:errors style="color:#F44336" path="apellido" cssClass="error" /></td>
        			</tr>
            		<tr>
        				<td><form:label path="nif">NIF:</form:label></td>
            			<td><form:input class="form-control" path="nif" /></td>
            			<td><form:errors style="color:#F44336" path="nif" cssClass="error" /></td>
        			</tr>
        			<tr>
		        		<td><form:label path="email">E-mail:</form:label></td>
		            	<td><form:input class="form-control" path="email" /></td>
		            	<td><form:errors style="color:#F44336" path="email" cssClass="error" /></td>
		        	</tr>
		            <tr>
		        		<td><form:label path="telefono">Teléfono:</form:label></td>
		            	<td><form:input class="form-control" path="telefono" /></td>
		            	<td><form:errors style="color:#F44336" path="telefono" cssClass="error" /></td>
		        	</tr>
		</table>
        	<tr>
        		<td>
        			<input type="submit" class="btn btn-primary" value="Finalizar" />
        		</td>
        		<td>
        			<a href="${pageContext.request.contextPath}/"> <input type="button" class="btn btn-primary" value="Cancelar" /></a>
        		</td>
        	</tr>
    </form:form>
    </jsp:body>
</t:paginabasica>