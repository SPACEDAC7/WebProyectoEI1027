<%@ tag description="Tag del logotipo"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- La sessió està disponible automàticament en l’objecte "session" -->
<c:set var="rol" scope="request" value='${session.getAttribute("rol")}'/>
<c:choose>
<c:when test='${rol == "administrador"}'>
	<a class="navbar-brand" href="${pageContext.request.contextPath}/"> ZONA ADMINISTRADOR </a>
</c:when>
<c:otherwise>
	<a class="navbar-brand icono"
						href="${pageContext.request.contextPath}/"><img
						src="${pageContext.request.contextPath}/img/logo.png"
						alt="logo_de_easy_rent"> EASY RENT</a>
</c:otherwise>
</c:choose>