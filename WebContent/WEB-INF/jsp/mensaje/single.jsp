<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Detalles Factura">
<jsp:body>
 <div id="header" class="heading" style="background-image: url(../../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Detalles del mensaje</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- fin:header -->

    <!-- inicio:content -->
    <div id="content">
      <div class="container">
        <div class="row">
          <!-- inicio:article -->
<div class="message-wrap col-md-12">
	<div class="msg-wrap">
		<div class="media msg ">
			<div class="media-body">
				<small class="pull-right time"><i class="fa fa-calendar"> </i> ${mensaje.fecha_mensaje}</small>
				<h4 class="media-heading">Nombre: ${usuarioMen.nombre} (${usuarioMen.email})</h4>
				<h5 class="media-heading">Asunto: ${mensaje.asunto}</h5>
				<span class="col-md-12"><p>${mensaje.contenido}</p></span>
			</div>
		</div>
	</div>
</div>
          <!-- fin:article -->
        </div>
         <div class="row">
          <div class="col-md-12 pull-left">
				<br><a class="btn btn-danger" href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"> Volver a la Bandeja de entrada</a>
          </div>
        </div>
      </div>
    </div>
    <!-- fin:content -->
    
    	</jsp:body>
</t:paginabasica>
  <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
     <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
    <script src="js/gmap3.min.js"></script>
    <script src="js/jquery.easing.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/masonry.pkgd.min.js"></script>
    <script src="js/jquery.backstretch.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/script.js"></script>