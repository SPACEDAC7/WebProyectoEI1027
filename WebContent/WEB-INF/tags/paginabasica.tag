<%@ tag description="Estructura d'una pàgina normal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/easyrent.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/simple-sidebar.css" 
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- Las letras se ven al lado del icono porque he comentado las lineas 4189-4193 de bootstrap.css y las 4160-4162 de bootstrap.min.css-->
				<a class="navbar-brand icono"
					href="${pageContext.request.contextPath}/"><img
					src="${pageContext.request.contextPath}/img/logo.png"
					alt="logo_de_easy_rent"> EASY RENT</a>
			</div>
			<div class="navbar-collapse collapse">

				<ul class="nav navbar-nav">
				<c:choose>
				<c:when test='${title == "EASY RENT"}'>
					<li class="active">
				</c:when>
				<c:otherwise>
					<li>
				</c:otherwise>
				</c:choose>
						<a href="${pageContext.request.contextPath}/">Página Principal</a></li>
					<li><a href="${pageContext.request.contextPath}/gestiones/listGestiones.jsp">Gestiones</a></li>
				</ul>
				<t:logininfo></t:logininfo>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container menu-principal">
		<jsp:doBody />
	</div>
	<footer>
		<hr>
		<p class="text-muted">EI1027 - Disseny i Implementació de Sistemes d'Informació</p>
		<p class="text-muted">Powered By: ALMOLO</p>
	</footer>
</body>
</html>
