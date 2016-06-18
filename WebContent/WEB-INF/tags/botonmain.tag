<%@ tag description="Estructura de botones de la pagina principal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav navbar-nav navbar-right">
	<li class="dropdown"><a data-toggle="dropdown" href="#">
	<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Entrar
			<span class="caret"></span>
	</a>
		<ul class="dropdown-menu" id="login-dp">
			<li>
				<div class="row">
					<div class="col-md-12">
						Vía de entrada
						<div class="social-buttons">
							<a class="btn btn-fb" href="#"><i class="fa fa-facebook"></i>
								Facebook</a> <a class="btn btn-tw" href="#"><i
								class="fa fa-twitter"></i> Twitter</a>
						</div>
						o 
						<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/login.html" class="form" method="post"
							id="login-nav" method="post" name="login-nav" role="form">
							<div class="form-group">
								<label class="sr-only" for="nick_usuario">Nombre de usuario</label>
								<input class="form-control" id="nick_usuario"
									placeholder="Nombre de usuario" required="">
							</div>
							<div class="form-group">
								<label class="sr-only" for="password">Contraseña</label><input
									class="form-control" id="password"
									placeholder="Contraseña" required="" type="password">
								
								<div class="help-block text-right">
									<a href="">¿Has olvidado la contraseña?</a>
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-block" type="submit">Entrar</button>
							</div>
							<div class="checkbox">
								<label><input type="checkbox">Guardar las credenciales</label>
							</div>
						</form>
					</div>
					<div class="bottom text-center">
						Eres nuevo? <a href="${pageContext.request.contextPath}/signup/addUser.html"><b>Registrare</b></a>
					</div>
				</div>
			</li>
		</ul></li>
	<li>
		<form action="${pageContext.request.contextPath}/login.html"
			method="get">
			<button type="submit"
				class="btn btn-link boton-main entrar navbar-right">
				<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
				Login
			</button>
		</form>
	</li>
	<li>
		<form action="${pageContext.request.contextPath}/signup/addUser.html"
			method="get">
			<button type="submit" style="font-size: 16px"
				class="btn btn-primary boton-main signup navbar-right">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				Registrarse
			</button>
		</form>
	</li>
</ul>