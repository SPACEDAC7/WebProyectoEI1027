<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Confirmacion">
	<jsp:body>
    <h2>Seguro que quieres eliminar esta dirección</h2>
	<div>
  	<a href="${pageContext.request.contextPath}/direccion/delete/confirmado.html" class="btn btn-primary">Aceptar</a>
  	<a href="${pageContext.request.contextPath}/direccion/list.html" class="btn btn-danger">Cancelar</a>
	</div>
    </jsp:body>
</t:paginabasica>