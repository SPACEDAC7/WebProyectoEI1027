<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!-- La sessió està disponible automàticament en l’objecte "session" -->
<c:set var="user" scope="request" value='${session.getAttribute("user")}'/>
<p class="loggeduser">
<c:choose>
<c:when test='${usuario == null}'>
<t:botonmain></t:botonmain> </c:when>
<c:otherwise>
<ul class="nav navbar-nav navbar-right info">
<li>Autenticat com ${usuario.nombre}</li>
<li>
	<form action="${pageContext.request.contextPath}/logout.html" method="get">
	<button type="submit" class="btn btn-danger boton-main boton-login">
			<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
			Eixir
		</button></form></li>
</ul>
</c:otherwise>
</c:choose>
</p>