<%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="url" scope="request" value='${session.getAttribute("nextURL")}' />
<t:paginabasica title="Nueva factura">
	<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h3 align="center"><font color=red>${mensajeError.mensaje}</font></h3>
		<table>
			<tr>
		 		<td><a href="${nextURL.mensaje}"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
		 		</td>
			</tr>
		</table>
	</div>
	</jsp:body>
</t:paginabasica>