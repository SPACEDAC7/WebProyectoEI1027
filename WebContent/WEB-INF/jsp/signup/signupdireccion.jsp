<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Sign-Up">
	<jsp:body>
    <h2>Introduzca su dirección</h2>
	<form:form action="${pageContext.request.contextPath}/signup/addDireccion.html" method="post" modelAttribute="nuevaDireccion">
		<table class="table table-condensed">
	        		<tr>
				 			<td><form:label path="calle">Calle:</form:label></td>
		            		<td><form:input class="form-control" path="calle" /></td>
		            		<td><form:errors path="calle" cssClass="error" /></td>
		        	</tr>
		        	<tr>
				 			<td><form:label path="calle">Número:</form:label></td>
		            		<td><form:input class="form-control" path="numero" value="" /></td>
		            		<td><form:errors path="numero" cssClass="error" /></td>
		        	</tr>
		        	<tr>
				 			<td><form:label path="calle">Código postal:</form:label></td>
		            		<td><form:input class="form-control" path="codigo_postal" /></td>
		            		<td><form:errors path="codigo_postal" cssClass="error" /></td>
		        	</tr>
		        	<tr>
				 			<td><form:label path="calle">Localidad:</form:label></td>
		            		<td><form:input class="form-control" path="localidad" /></td>
		            		<td><form:errors path="localidad" cssClass="error" /></td>
		        	</tr>
		        	<tr>
				 			<td><form:label path="calle">Provincia:</form:label></td>
		            		<td><form:input class="form-control" path="provincia" /></td>
		            		<td><form:errors path="provincia" cssClass="error" /></td>
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
    </jsp:body>
</t:paginabasica>