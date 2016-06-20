<%@ tag description="Estructura d'una pàgina normal"
	pageEncoding="UTF-8"%>
<%@ attribute name="title" required="false"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" scope="request" value='${session.getAttribute("user")}' />
<c:set var="rol" scope="request" value='${session.getAttribute("rol")}' />
<c:choose>
<c:when test='${rol == "administrador"}'>
	<!DOCTYPE html>
	<html>
	<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta charset="utf-8" />
	<c:choose>
		<c:when test='${title == "INDEX"}'>
			<meta http-equiv="refresh" content="0;URL=${pageContext.request.contextPath}/gestiones/listGestiones.html">
		</c:when>
	</c:choose>
	<title>Zona de administración - EasyRent</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	    
	<!-- INICIO CORE CSS FRAMEWORK -->
	<link href="${pageContext.request.contextPath}/plugins/boostrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/plugins/boostrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/admin/animate.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/plugins/jquery-scrollbar/jquery.scrollbar.css" rel="stylesheet" type="text/css"/>
	<!-- FIN CORE CSS FRAMEWORK -->
	<!-- INICIO CSS TEMPLATE -->
	<link href="${pageContext.request.contextPath}/css/admin/style.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/admin/responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/admin/custom-icon-set.css" rel="stylesheet" type="text/css"/>
	<!-- FIN CSS TEMPLATE -->
	
	</head>
	<!-- FIN HEAD -->
	
	<!-- INICIO BODY -->
	<body class="">
	<!-- INICIO HEADER -->
	<div class="header navbar navbar-inverse "> 
	  <!-- INICIO TOP NAVIGATION BAR -->
	  <div class="navbar-inner">
		<div class="header-seperation"> 
			<ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">	
			 <li class="dropdown"> <a id="main-menu-toggle" href="#main-menu"  class="" > <div class="iconset top-menu-toggle-white"></div> </a> </li>		 
			</ul>
	      <!-- INICIO LOGO -->	
	      <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/img/icon/logoEasy.png" class="logo" alt="" width="110" height="25"/></a>
	      <!-- FIN LOGO --> 
	      <ul class="nav pull-right notifcation-center">	
	        <li class="dropdown" id="header_task_bar"> <a href="${pageContext.request.contextPath}/" class="dropdown-toggle active" data-toggle=""> <div class="iconset top-home"></div> </a> </li>
	        <li class="dropdown" id="header_inbox_bar" > <a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html" class="dropdown-toggle" > <div class="iconset top-messages"></div></a></li>
			<li class="dropdown" id="portrait-chat-toggler" style="display:none"> <a href="#sidr" class="chat-menu-toggle"> <div class="iconset top-chat-white "></div> </a> </li>        
	      </ul>
	      </div>
	      <!-- FIN RESPONSIVE MENU TOGGLER --> 
	      <div class="header-quick-nav" > 
		 <!-- INICIO CHAT TOGGLER -->
	      <div class="pull-right"> 
			<div class="chat-toggler">	
				<div class="user-details"> 
					<div class="username">
						<span class="bold">${usuario.nombre} &nbsp;</span>									
					</div>
				</div> 
				<div class="profile-pic"> 
					<img src="${usuario.url_imagen_perfil}"  alt="" data-src="${usuario.url_imagen_perfil}" data-src-retina="${usuario.url_imagen_perfil}" width="35" height="35" /> 
				</div>
			</div>
			 <ul class="nav quick-section ">
				<li class="quicklinks"> 
					<a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">						
						<div class="iconset top-settings-dark "></div> 	
					</a>
					<ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
	                  <li><a href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html">Mi perfil</a></li>
	                  <li><a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"> Bandeja de Entrada</a></li>
	                  <li><a href="${pageContext.request.contextPath}/mensaje/bandejaSalida.html"> Bandeja de Salida</a></li>
	                  <li class="divider"></li>                
	                  <li><a href="${pageContext.request.contextPath}/logout.html"><i class="fa fa-power-off"></i>&nbsp;&nbsp;Cerrar Sesión</a></li>
	               </ul>
				</li> 				
			</ul>
	      </div>
		   <!-- FIN CHAT TOGGLER -->
	      </div> 
	      <!-- FIN TOP NAVIGATION MENU --> 
	   
	  </div>
	  <!-- FIN TOP NAVIGATION BAR --> 
	</div>
	<!-- FIN HEADER -->
	<!-- INICIO CONTAINER -->
	<div class="page-container row-fluid">
	  <!-- INICIO SIDEBAR -->
	  <div class="page-sidebar" id="main-menu"> 
	  <!-- INICIO MINI-PROFILE -->
	   <div class="page-sidebar-wrapper scrollbar-dynamic" id="main-menu-wrapper"> 
	   <div class="user-info-wrapper">	
		<div class="profile-wrapper">
			<img src="${usuario.url_imagen_perfil}"  alt="" data-src="${usuario.url_imagen_perfil}" data-src-retina="${usuario.url_imagen_perfil}" width="69" height="69" />
		</div>
	    <div class="user-info">
	      <div class="greeting">Bienvenido</div>
	      <div class="username"><span style="text-transform: capitalize;" class="semi-bold">${usuario.nombre}</span></div>
	    </div>
	   </div>
	  <!-- FIN MINI-PROFILE -->
	   
	   <!-- INICIO SIDEBAR MENU -->	
		<p class="menu-title">MENU PRINCIPAL</p>
	   <ul>
		
		<li class="start active "> <a href="${pageContext.request.contextPath}/"> <i class="icon-custom-home"></i> <span class="title">Inicio</span></a> </li>
	      <li class=""><a href="javascript:;"> <i
				class="fa fa-folder-open"></i> <span class="title">Utilidades</span> <span class="arrow "></span></a>
			<ul class="sub-menu">
				<li><a href="${pageContext.request.contextPath}/usuario/perfil/${usuario.id_usuario}.html">Mi perfil</a></li>
				<li><a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"> Bandeja de Entrada</a></li>
	            <li><a href="${pageContext.request.contextPath}/mensaje/bandejaSalida.html"> Bandeja de Salida</a></li>
				<li><a href="${pageContext.request.contextPath}/logout.html"> Salir</a></li>
			</ul></li>
	      <li class=""> <a href="javascript:;"> <i class="icon-custom-ui"></i> <span class="title">Usuario</span> <span class="arrow "></span> </a>
	        <ul class="sub-menu">
			  <li > <a href="${pageContext.request.contextPath}/usuario/list.html"> LISTA DE USUARIOS </a> </li>
			  <li > <a href="${pageContext.request.contextPath}/credencial/list.html"> LISTA DE CREDENCIALES </a> </li>
			  <li > <a href="${pageContext.request.contextPath}/direccion/list.html"> LISTA DE DIRECCIONES </a> </li>
	        </ul>
	      </li>
		  <li class=""> <a href="javascript:;"> <i class="icon-custom-form"></i> <span class="title">Propiedades</span> <span class="arrow "></span> </a>
	        <ul class="sub-menu">
	          <li > <a href="${pageContext.request.contextPath}/propiedades/list.html">LISTA DE PROPIEDADES </a> </li>
	          <li > <a href="${pageContext.request.contextPath}/puntuacion/list.html">LISTA DE PUNTUACIONES</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/respuestaPuntuacion/list.html">LISTA DE RESPUESTAS DE PUNTUACIONES</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/servicio/list.html">LISTA DE SERVICIOS</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/porpiedadServicio/list.html">LISTA DE PROPIEDAD SERVICIO</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/imagen/list.html">LISTA DE IMAGENES</a> </li>
	        </ul>
	      </li>
	      <li class=""> <a href="javascript:;"> <i class="icon-custom-portlets"></i> <span class="title">Reservas</span> <span class="arrow "></span> </a>
	        <ul class="sub-menu">
	          <li > <a href="${pageContext.request.contextPath}/reserva/list.html">LISTA DE RESERVAS</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/periodo/list.html">LISTA DE PERIODOS</a> </li>
	          <li > <a href="${pageContext.request.contextPath}/factura/list.html">LISTA DE FACTURAS</a> </li>
	        </ul>
	      </li>
	      <li class=""> <a href="javascript:;"> <i class="icon-custom-thumb"></i> <span class="title">Comunicaciones</span> <span class="arrow "></span> </a>
	        <ul class="sub-menu">
	          <li > <a href="${pageContext.request.contextPath}/mensajes/list.html"> LISTA DE MENSAJES </a> </li>
	        </ul>
	      </li>
	      
	    </ul>
		
		<div class="clearfix"></div>
	    <!-- FIN SIDEBAR MENU --> 
	  </div>
	  </div>
	  <a href="#" class="scrollup">Scroll</a>
	   <div class="footer-widget">
		<div class="pull-right">	
		<a href="${pageContext.request.contextPath}/logout.html">Cerrar sesión <i class="fa fa-power-off"></i></a></div>
	  </div>
	  <!-- FIN SIDEBAR --> 
		<jsp:doBody />
	<!-- FIN CONTAINER -->
	<!-- INICIO CORE JS FRAMEWORK--> 
	<script src="${pageContext.request.contextPath}/plugins/jquery-1.8.3.min.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/plugins/boostrapv3/js/bootstrap.min.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/plugins/breakpoints.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/plugins/jquery-unveil/jquery.unveil.min.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/plugins/jquery-scrollbar/jquery.scrollbar.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/sorttable.js" type="text/javascript"></script>
	<!-- FIN CORE JS FRAMEWORK --> 
	<!-- INICIO PAGE LEVEL JS --> 
	<script src="${pageContext.request.contextPath}/plugins/pace/pace.min.js" type="text/javascript"></script>  
	<script src="${pageContext.request.contextPath}/plugins/jquery-numberAnimate/jquery.animateNumbers.js" type="text/javascript"></script>
	<!-- FIN PAGE LEVEL PLUGINS --> 	
	
	<!-- INICIO CORE TEMPLATE JS --> 
	<script src="${pageContext.request.contextPath}/js/core.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/chat.js" type="text/javascript"></script> 
	<!-- FIN CORE TEMPLATE JS --> 
	</body>
	</html>
</c:when>
<c:otherwise>
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
	<!-- Datapicker -->
	<link href="${pageContext.request.contextPath}/css/datepicker.css" rel="stylesheet">
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
						
						<!-- <c:set var="rol" scope="request"
							value='${session.getAttribute("rol")}' /> y con un c:choos podemos poner que se puede ver y que no en la barra de navegacion-->
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
	        <!-- break -->
	        <div class="row">
	          <div class="col-md-12 copyderecha">
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
	    <script src="${pageContext.request.contextPath}/js/sorttable.js" type="text/javascript"></script>
	</body>
	</html>
</c:otherwise>
</c:choose>
