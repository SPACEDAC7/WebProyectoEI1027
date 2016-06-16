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
		<meta http-equiv="refresh" content="0;URL=${pageContext.request.contextPath}/buscador/list.html">
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
					<a href="${pageContext.request.contextPath}/">Propiedades</a>
					</li>
					<c:choose>
						<c:when test='${title == "Contacta"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/">Contactanos</a>
					</li>
					<c:choose>
						<c:when test='${title == "Nosotros"}'>
							<li class="active">
						</c:when>
						<c:otherwise>
							<li>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/">Sobre Nosotros</a>
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
	<div id="content">
		<div id="container">
			<jsp:doBody />
		</div>
	</div>
	<div class="row">
          <div class="col-md-12 copyright">
            <p>Copyright &copy; 2016 ALMOLO, EI1027</p>
            <p>Powered By: <strong>ALMOLO.</strong></p>
            <a href="#top" class="btn btn-primary scroltop"><i class="fa fa-angle-up"></i></a>
            <ul class="list-inline social-links">
              <li><a href="#" class="icon-twitter" rel="tooltip" title="" data-placement="bottom" data-original-title="Twitter"><i class="fa fa-twitter"></i></a></li>
              <li><a href="#" class="icon-facebook" rel="tooltip" title="" data-placement="bottom" data-original-title="Facebook"><i class="fa fa-facebook"></i></a></li>
              <li><a href="#" class="icon-gplus" rel="tooltip" title="" data-placement="bottom" data-original-title="Gplus"><i class="fa fa-google-plus"></i></a></li>
            </ul>
          </div>
	</div>
	<!-- begin:modal-signin -->
    <div class="modal fade" id="modal-signin" tabindex="-1" role="dialog" aria-labelledby="modal-signin" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Sign in</h4>
          </div>
          <div class="modal-body">
            <form role="form">
              <div class="form-group">
                <label for="emailAddress">Email address</label>
                <input type="email" class="form-control input-lg" placeholder="Enter email">
              </div>
              <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control input-lg" placeholder="Password">
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" name="forget"> Keep me logged in
                </label>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <p>Don't have account ? <a href="#modal-signup"  data-toggle="modal" data-target="#modal-signup">Sign up here.</a></p>
            <input type="submit" class="btn btn-primary btn-block btn-lg" value="Sign in">
          </div>
        </div>
      </div>
    </div>
    <!-- end:modal-signin -->

    <!-- begin:modal-signup -->
    <div class="modal fade" id="modal-signup" tabindex="-1" role="dialog" aria-labelledby="modal-signup" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Sign up</h4>
          </div>
          <div class="modal-body">
            <form role="form">
              <div class="form-group">
                <input type="email" class="form-control input-lg" placeholder="Enter email">
              </div>
              <div class="form-group">
                <input type="password" class="form-control input-lg" placeholder="Password">
              </div>
              <div class="form-group">
                <input type="password" class="form-control input-lg" placeholder="Confirm Password">
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" name="agree"> Agree to our <a href="#">terms of use</a> and <a href="#">privacy policy</a>
                </label>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <p>Already have account ? <a href="#modal-signin" data-toggle="modal" data-target="#modal-signin">Sign in here.</a></p>
            <input type="submit" class="btn btn-primary btn-block btn-lg" value="Sign up">
          </div>
        </div>
      </div>
    </div>
	
	<!-- <script src="${pageContext.request.contextPath}/js/jquery.js"></script> -->
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
    <!-- end:modal-signup -->
</body>
</html>
