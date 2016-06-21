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
<div class="container">
    <div class="row">
        <div class="col-md-8">
    		<div class="invoice-title">
    			<h2>Factura</h2>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-md-6">
    				<address>
    				<strong>Factura para:</strong><br>
    					${usuarioReserva.nombre}, ${usuarioReserva.apellido}<br>
    					C\ ${direccionUsuario.calle} ${direccionUsuario.numero}<br>
    					${direccionUsuario.codigo_postal} ,${direccionUsuario.localidad}<br>
    					${direccionUsuario.provincia}
    				</address>
    			</div>
    			<div class="col-md-6 text-right">
    				<address>
        			<strong>Datos del propietario:</strong><br>
    					${propietario.nombre}, ${propietario.apellido}<br>
    					C\ ${direccionUsuarioPropiedad.calle} ${direccionUsuarioPropiedad.numero}<br>
    					${direccionUsuarioPropiedad.codigo_postal} ,${direccionUsuarioPropiedad.localidad}<br>
    					${direccionUsuarioPropiedad.provincia}
    				</address>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-md-offset-6 col-md-6 text-right">
    				<address>
    					<strong>Fecha:</strong><br>
    					${factura.fecha_factura}<br><br>
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-8">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Resumen de factura</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Id producto</strong></td>
        							<td><strong>Nombre</strong></td>
        							<td class="text-center"><strong>Precio diario</strong></td>
        							<td class="text-center"><strong>Días de estancia</strong></td>
        							<td class="text-right"><strong>Total</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							<tr>
    								<td>${propiedad.id_propiedad}</td>
    								<td>${propiedad.titulo}</td>
    								<td class="text-center">${propiedad.precio_propiedad}</td>
    								<td class="text-center">${diasReserva} </td>
    								<td class="text-right">${factura.precio_factura}</td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>
          <!-- fin:article -->
          
        </div>
         <div class="row">
          <div class="col-md-12 pull-left">
				<br><a class="btn btn-danger" href="${pageContext.request.contextPath}/factura/misFacturas.html"> Volver a facturas</a>
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