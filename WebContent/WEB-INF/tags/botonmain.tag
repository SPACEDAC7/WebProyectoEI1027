<%@ tag description="Estructura de botones de la pagina principal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<ul class="nav navbar-nav navbar-right">
	<li class="dropdown"><a data-toggle="dropdown" href="#">Login
			<span class="caret"></span>
	</a>
		<ul class="dropdown-menu" id="login-dp">
			<li>
				<div class="row">
					<div class="col-md-12">
						Login via
						<div class="social-buttons">
							<a class="btn btn-fb" href="#"><i class="fa fa-facebook"></i>
								Facebook</a> <a class="btn btn-tw" href="#"><i
								class="fa fa-twitter"></i> Twitter</a>
						</div>
						or
						<form accept-charset="UTF-8" action="login" class="form"
							id="login-nav" method="post" name="login-nav" role="form">
							<div class="form-group">
								<label class="sr-only" for="exampleInputEmail2">Email
									address</label><input class="form-control" id="exampleInputEmail2"
									placeholder="Email address" required="" type="email">
							</div>
							<div class="form-group">
								<label class="sr-only" for="exampleInputPassword2">Password</label><input
									class="form-control" id="exampleInputPassword2"
									placeholder="Password" required="" type="password">
								<div class="help-block text-right">
									<a href="">Forget the password ?</a>
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-block" type="submit">Sign
									in</button>
							</div>
							<div class="checkbox">
								<label><input type="checkbox">keep me logged-in</label>
							</div>
						</form>
					</div>
					<div class="bottom text-center">
						New here ? <a href="#"><b>Join Us</b></a>
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