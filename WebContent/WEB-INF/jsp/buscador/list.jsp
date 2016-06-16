<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Propiedades">
<jsp:body>
  <body id="top">
  <div id="header" class="heading" style="background-image: url(../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Propiedades</h2>
            </div>
            <ol class="breadcrumb">
              <li><a href="${pageContext.request.contextPath}/cabecera/inicio.html">Inicio</a></li>
              <li class="active">Propiedades</li>
            </ol>
          </div>
        </div>
      </div>
    </div>
   <!-- inicio:content -->
  	<div id="content">
      <div class="container">
        <div class="row">
          <!-- begin:article -->
          <div class="col-md-9 col-md-push-3">
            <!-- begin:product -->
            <div class="row container-realestate">
				<c:forEach items="${propiedades}" var="propiedad">
				  <div class="col-md-12 col-sm-12 col-xs-12">
					<div class="property-container">
					  <div class="property-content-list">
						<div class="property-image-list">
						  <img src="../img/img12.jpg" alt="mikha real estate theme">
						  <div class="property-price">
							<h4>${propiedad.tipo}</h4>
							<span>${propiedad.precio_propiedad}<small>/mes</small></span>
						  </div>
						  <div class="property-status">
							<span>Alquiler</span>
						  </div>
						  <div class="property-features">
							<span><i class="fa fa-home"></i> ${propiedad.area} m<sup>2</span>
							<span><i class="fa fa-hdd-o"></i> ${propiedad.num_camas} Camas</span>
							<span><i class="fa fa-male"></i> ${propiedad.capacidad} Personas</span>
							<span><i class="fa fa-building-o"></i> ${propiedad.num_habitaciones} Habitaciones</span>
						  </div>
						</div>
						<div class="property-text">
						  <h3><a href="#">${propiedad.titulo}</a> <small>${propiedad.id_direccion}</small></h3>
						  <p>${propiedad.descripcion}</p>
						  <p><a href="#" class="btn btn-primary">More Detail &raquo;</a></p>
						</div>
					  </div>
					</div>
				  </div>
				</c:forEach>
              <!-- break -->
            </div>
            <!-- end:product -->

            <!-- begin:pagination -->
            <div class="row">
              <div class="col-md-12">
                <ul class="pagination">
                  <li class="disabled"><a href="#">&laquo;</a></li>
                  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                  <li><a href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
            <!-- end:pagination -->
          </div>
          <!-- end:article -->

          <!-- inicio:sidebar -->
          <div class="col-md-3 col-md-pull-9 sidebar">
            <div class="widget widget-white">
              <div class="widget-header">
                <h3>Búsqueda</h3>
              </div>    
              <form role="form" class="advance-search">
				<div class="form-group">
				  <label for="ciudad">Ciudad</label>
				  <select class="form-control">
					<option>Castellon</option>
					<option>Valencia</option>
				  </select>
				</div>
                    <div class="form-group">
                      <label for="tipo">Tipo</label>
                      <select class="form-control">
                        <option>Apartamento</option>
                        <option>Casa</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="habitaciones">Habitaciones</label>
                      <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="camas">Camas</label>
                      <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                      </select>
                    </div>
					<div class="form-group">
                      <label for="capacidad">Capacidad</label>
                      <select class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="minprice">Precio mínimo</label>
                      <select class="form-control">
                        <option>$4,200</option>
                        <option>$6,700</option>
                        <option>$8,150</option>
                        <option>$11,110</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="maxprice">Precio máximo</label>
                      <select class="form-control">
                        <option>$8,200</option>
                        <option>$11,700</option>
                        <option>$14,150</option>
                        <option>$21,110</option>
                      </select>
                    </div>
					<div class="form-group">
                      <label style="display: block;" for="servicios">Servicios</label>
                      <label class="checkbox-inline"><input type="checkbox" id="opcion1" value="opcion_1"> WiFi</label>
					  <label class="checkbox-inline"><input type="checkbox" id="checkboxEnLinea1" value="opcion2"> Secador</label>
					  <label class="checkbox-inline"><input type="checkbox" id="opcion1" value="opcion_1"> Cable</label>
					  <label class="checkbox-inline"><input type="checkbox" id="opcion1" value="opcion_1"> Jacuzzi</label>
                    </div>
                <input type="submit" name="submit" value="Search" class="btn btn-primary btn-block">
              </form>
            </div>
            <!-- break -->
          </div>
          <!-- fin:sidebar -->
          
        </div>
      </div>
    </div>
    <!-- fin:content -->
	</body>
</jsp:body>
</t:paginabasica>