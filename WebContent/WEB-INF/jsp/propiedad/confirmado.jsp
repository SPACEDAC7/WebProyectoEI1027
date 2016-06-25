<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Confirmado">
	<jsp:body>
    <div style="margin-bottom:20px" class="container">
    <h2>Proceso realizado con éxito</h2>
	<div class="alert alert-success">
  		<a href="${pageContext.request.contextPath}/" class="alert-link">Enorabuena! El proceso se ha realizado con éxito
  		Pincha aqui para volver a la página de inicio.</a>
	</div>
	</div>
    </jsp:body>
</t:paginabasica>