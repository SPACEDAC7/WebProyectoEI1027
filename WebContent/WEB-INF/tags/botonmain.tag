<%@ tag description="Estructura de botones de la pagina principal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav navbar-nav navbar-right">
		<li>
		<form action="${pageContext.request.contextPath}/login.html"
			method="get">
			<button type="submit"
				class="btn btn-link boton-main entrar navbar-right">
				<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
				Entrar
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