<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Confirmación modificación">
	<jsp:body>
    <h2>¿Seguro que quieres modificar la direccion?</h2>
	<div>
  	<a href="${pageContext.request.contextPath}/direccion/update/confirmado.html" class="btn btn-primary">Aceptar</a>
  	<a href="${pageContext.request.contextPath}/direccion/list.html" class="btn btn-danger">Cancelar</a>
	</div>
    </jsp:body>
</t:paginabasica>