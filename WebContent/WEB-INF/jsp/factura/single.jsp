 <%@page contentType="text/html; charset=iso-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Detalles Factura">
<jsp:body>
 <div id="header" class="heading" style="background-image: url(../../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Detalles de la Factura</p>
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
          	DATOS DE FACTURA<br>
             ${factura.id_factura}<br>
             ${factura.fecha_factura}<br>
             ${factura.precio_factura}<br>
            DATOS DE RESERVA<br>
             ${reserva.fecha_reserva}<br>
            DATOS DE LA PROPIEDAD <br>
             ${propiedad.titulo} <br>
             ${propiedad.precio_propiedad }<br>
          <!-- fin:article -->
          
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