<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Satisfactorio">
	<jsp:body>
    <h2>El proceso se ha completado satisfactoriamente</h2>
	<div class="alert alert-success">
  		<a href="${pageContext.request.contextPath}/" class="alert-link">Enorabuena! El proceso se ha completado con éxito
  		Pincha aqui para volver a la página de inicio.</a>
	</div>
    </jsp:body>
</t:paginabasica>