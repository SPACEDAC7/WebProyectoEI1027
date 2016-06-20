<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:paginabasica title="login">
	<jsp:body>
    <!-- <div style="margin-bottom:20px" class="container">
    <h2>Acceso</h2>
    <form:form method="post" modelAttribute="credencial" action="${pageContext.request.contextPath}/login.html">
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
    </div>-->

    <div class="modal-dialog">
      <div class="modal-content">
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          <form:form method="post" modelAttribute="credencial" action="${pageContext.request.contextPath}/login.html">
                              <div class="form-group">
                                  <form:label path="nick_usuario">Usuario</form:label>
                                  <form:input class="form-control" path="nick_usuario" title="Introduzca su usuario"  placeholder="Escribe tu nick de usuario" />
                                  <form:errors style="color:#F44336" path="nick_usuario" cssClass="error" />
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <form:label path="password" class="control-label">Contraseña:</form:label>
                                  <form:password class="form-control" path="password" required="" title="Introduzca su contraseña" />
                                  <form:errors style="color:#F44336" path="password" cssClass="error" />
                                  <span class="help-block"></span>
                              </div>
                              <div class="checkbox">
                                  <label>
                                      <input type="checkbox" name="remember" id="remember"> Recuerdame
                                  </label>
                              </div>
                              <input style="font-size:18px" type="submit" class="btn btn-success btn-block" value="Entra" />
                              <a href="/forgot/" class="btn btn-default btn-block">¿Problemas con el login?</a>
                          </form:form>
                      </div>
                  </div>
                  <div class="col-xs-6">
                      <p class="lead">¡Regístrese ahora, <span class="text-success">es gratis!</span></p>
                      <ul class="list-unstyled" style="line-height: 2">
                          <li><span class="fa fa-check text-success"></span> Controle sus propiedades</li>
                          <li><span class="fa fa-check text-success"></span> Obtenga más ingresos mensuales</li>
                          <li><span class="fa fa-check text-success"></span> Consiga el mejor precio</li>
                          <li><span class="fa fa-check text-success"></span> Seguridad garantizada</li>
                          <li><span class="fa fa-check text-success"></span> Servicio de tickets <small>(mensajería)</small></li>
                          <li><a href="/read-more/"><u>Leer más</u></a></li>
                      </ul>
                      <form action="${pageContext.request.contextPath}/signup/addUser.html" method="get">
                     	 <button type="submit" style="font-size: 16px" class="btn btn-info btn-block" > ¡Regístrese!</button>
                      </form>
                  </div>
              </div>
          </div>
      </div>
  </div>
    </jsp:body>
</t:paginabasica>