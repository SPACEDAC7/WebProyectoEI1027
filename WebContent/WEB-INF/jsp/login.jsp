<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="login">
	<jsp:body>
    <div style="margin-bottom:20px" class="container">
    <h2>Acceso</h2>
    <form:form method="post" modelAttribute="credencial"
			action="${pageContext.request.contextPath}/login.html">
        <div class="form-group">
            <form:label path="nick_usuario">Nom d'usuari:</form:label>
            <form:input class="form-control" path="nick_usuario" />
            <form:errors style="color:#F44336" path="nick_usuario" cssClass="error" />
        </div>
        <div class="form-group">
            <form:label path="password">Contrasenya:</form:label>
            <form:password class="form-control" path="password" />
            <form:errors style="color:#F44336" path="password" cssClass="error" />
        </div>        
		<div class="help-block">
		<a href="">¿Has olvidado la contraseña?</a>
		</div>        
        <input style="font-size:18px" type="submit" class="btn btn-primary" value="Accedir" />
		   
    </form:form>
    <div style="font-size:18px" class="bottom text-center">
						Eres nuevo? <a href="${pageContext.request.contextPath}/signup/addUser.html"><b>Registrare</b></a>
					</div>
    </div>
    </jsp:body>
</t:paginabasica>