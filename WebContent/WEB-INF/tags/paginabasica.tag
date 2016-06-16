<%@ tag description="Estructura d'una pàgina normal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<c:choose>
	<c:when test='${title == "INDEX"}'>
		<meta http-equiv="refresh" content="0;URL=${pageContext.request.contextPath}/cabecera/inicio.html">
	</c:when>
</c:choose>

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/botones-w8.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/easyrent.css" rel="stylesheet">
<!-- ISRA INNOVACIONES -->
<link href='http://fonts.googleapis.com/css?family=Raleway:400,600,800' rel='stylesheet' type='text/css'>
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>
<body id="top">
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
				<t:logotipo></t:logotipo>
				<!-- El logotipo se crea para diferenciar si es un administrador o no y poner el diseño diferente -->
			</div>
			<div class="collapse navbar-collapse" id="navbar-top">
				<t:logininfo></t:logininfo>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test='${title == "EASY RENT"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/">Inicio</a>
					</li>
					<c:choose>
						<c:when test='${title == "Propiedades"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/buscador/list.html">Propiedades</a>
					</li>
					<c:choose>
						<c:when test='${title == "Contacta"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/cabecera/contacta.html">Contactanos</a>
					</li>
					<c:choose>
						<c:when test='${title == "Nosotros"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/cabecera/nosotros.html">Sobre Nosotros</a>
					</li>
					<c:set var="rol" scope="request"
						value='${session.getAttribute("rol")}' />
					<c:choose>
						<c:when test='${rol == "administrador"}'>
							<c:choose>
								<c:when test='${title == "Gestiones"}'>
									<li class="active">
								</c:when>
								<c:otherwise>
									<li>
								</c:otherwise>
							</c:choose>
							<a
								href="${pageContext.request.contextPath}/gestiones/listGestiones.html">Gestiones</a>
							</li>
						</c:when>
					</c:choose>
				</ul>
				<!-- En el tag boton main están los que funcionan -->
				
			</div>
		</div>
	</nav>
			<jsp:doBody />
	    <!-- inicio:footer -->
    <div id="footer">
      <div class="container">
		<!-- inicio:footer -->
        <div class="row">
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="widget">
              <h3>Lista enlaces 1</h3>
              <ul class="list-unstyled">
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
              </ul>
            </div>
          </div>
          <!-- break -->
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="widget">
              <h3>Lista enlaces 2</h3>
              <ul class="list-unstyled">
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
              </ul>
            </div>
          </div>
          <!-- break -->
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="widget">
              <h3>Usuario</h3>
              <ul class="list-unstyled">
                <li><a href="#">Mi perfil</a></li>
                <li><a href="#">Mis reservas</a></li>
                <li><a href="#">Salir</a></li>
              </ul>
            </div>
          </div>
          <!-- break -->
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="widget">
              <h2>EasyRent.</h2>
              <address>
                <strong>La mejor opción.</strong><br>
                Av. de Vicent Sos Baynat s/n 12071<br>
                <br>
                Telp. : +62-345678910<br>
                Email : aluji@uji.es
              </address>
            </div>
          </div>
          <!-- break -->
        </div>
        <!-- break -->

        <!-- inicio:copyright -->
        <div class="row">
          <div class="col-md-12 copyright">
            <p>Copyright &copy; 2016 EasyRent S.L. - Todos los derechos reservados</p>
            <p>Powered by <strong>ALMOLO.</strong></p>
            <a href="#top" class="btn btn-primary scroltop"><i class="fa fa-angle-up"></i></a>
            <ul class="list-inline social-links">
              <li><a href="#" class="icon-twitter" rel="tooltip" title=""><i class="fa fa-twitter"></i></a></li>
              <li><a href="#" class="icon-facebook" rel="tooltip" title=""><i class="fa fa-facebook"></i></a></li>
              <li><a href="#" class="icon-gplus" rel="tooltip" title=""><i class="fa fa-google-plus"></i></a></li>
            </ul>
          </div>
        </div>
        <!-- fin:copyright -->

      </div>
    </div>
    <!-- fin:footer -->
   
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
     <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
    <script src="${pageContext.request.contextPath}/js/gmap3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easing.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.jcarousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/imagesloaded.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/masonry.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.backstretch.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.nicescroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
