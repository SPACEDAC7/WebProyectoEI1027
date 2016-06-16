<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="Sign-Up">
	<jsp:body>
    <div style="margin-bottom:20px" class="container">
    <h2>Diganos sus datos</h2>
	<div class="alert alert-success">
  		<a href="${pageContext.request.contextPath}/" class="alert-link">Enorabuena! El usuario se ha creado con éxito
  		Pincha aqui para volver a la página de inicio.</a>
	</div>
	</div>
    </jsp:body>
</t:paginabasica>