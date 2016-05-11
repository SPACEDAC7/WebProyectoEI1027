<%@ tag description="Estructura d'una pàgina normal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
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
	href="${pageContext.request.contextPath}/css/easyrent.css"
	rel="stylesheet">
</head>
<body>
	<div id="logo">
	<a href="#"><img src="${pageContext.request.contextPath}/img/logo.png"></a>
	</div>
	<div id="navegacion">
		<t:navegacio/>
	</div>
	<div class="loggeduser"><t:logininfo /></div>
	<div class="container">
		<jsp:doBody />
	</div>
	<footer>
	<hr>
	<p class="text-muted">
	EI1027 - Disseny i Implementació de Sistemes d'Informació
	</p>
	</footer>
</body>
</html>
