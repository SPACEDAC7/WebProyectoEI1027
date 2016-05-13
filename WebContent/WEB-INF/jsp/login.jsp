<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/natacio.css">
<title>Login</title>
</head>

<t:paginabasica>
	<jsp:body>
    <h2>Acceso</h2>
    <form:form method="post" modelAttribute="credencial"
			action="${pageContext.request.contextPath}/login.html">
        <div class="form-group">
            <form:label path="nick_usuario">Nom d'usuari:</form:label>
            <form:input class="form-control" path="nick_usuario" />
            <form:errors path="nick_usuario" cssClass="error" />
        </div>
        <div class="form-group">
            <form:label path="password">Contrasenya:</form:label>
            <form:password class="form-control" path="password" />
            <form:errors path="password" cssClass="error" />
        </div>        
        <input type="submit" class="btn btn-primary" value="Accedir" />
    </form:form>
    </jsp:body>
</t:paginabasica>


</html>