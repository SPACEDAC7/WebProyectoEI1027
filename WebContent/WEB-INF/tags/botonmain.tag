<%@ tag description="Estructura de botones de la pagina principal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<ul class="nav navbar-nav navbar-right">
	<li>
		<form action="${pageContext.request.contextPath}/login.html" method="get">
			<button type="submit" class="btn btn-link boton-main boton-login centrado">
				<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
				Login
			</button>
		</form>
	</li>
	<li>
		<form action="${pageContext.request.contextPath}/signup/addUser.html" method="get">
			<button type="submit" class="btn btn-primary boton-main centrado">
				<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
				Sign Up
			</button>
		</form>
	</li>
</ul>