<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
						  <a href="${pageContext.request.contextPath}/propiedad/single/${propiedad.id_propiedad}.html">
						  		<img src="../img/img12.jpg" alt="mikha real estate theme"></a>
						  <div class="property-price">
							<h4>${propiedad.tipo}</h4>
							<span>${propiedad.precio_propiedad}<small> €/mes</small></span>
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
						  <h3><a href="${pageContext.request.contextPath}/propiedad/single/${propiedad.id_propiedad}.html">${propiedad.titulo}</a> <small>${propiedad.id_direccion}</small></h3>
						  <p>${propiedad.descripcion}</p>
						  <p><a href="${pageContext.request.contextPath}/propiedad/single/${propiedad.id_propiedad}.html" class="btn btn-primary">Más detalles &raquo;</a></p>
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
              <form:form method="post" modelAttribute="buscador" role="form" class="advance-search">
				<div class="form-group">
				  <form:label path="localidad">Ciudad</form:label>
				  <form:select class="form-control" path="localidad">
				  	<form:option value="" selected="selected">Seleccione localidad</form:option>
					<form:option value="castellon">Castellon</form:option>
					<form:option value="valencia">Valencia</form:option>
					<form:option value="Vila-real">Vila-real</form:option>
					<form:option value="Barcelona">Barcelona</form:option>
				  </form:select>
				</div>
                    <div class="form-group">
                      <form:label path="tipo">Tipo</form:label>
                      <form:select class="form-control" path="tipo">
                      	<form:option value="" selected="selected">Tipo de propiedad</form:option>
                        <form:option value="apartamento">Apartamento</form:option>
                        <form:option value="casa">Casa</form:option>
                        <form:option value="piso">Piso</form:option>
                        <form:option value="chalet">Chalet</form:option>
                        <form:option value="mansion">Mansión</form:option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <form:label path="num_habitaciones">Habitaciones</form:label>
                      <form:select class="form-control" path="num_habitaciones">
                        <form:option value ="-1" selected="selected">Nº habitaciones</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="5">5</form:option>
                        <form:option value="18">18</form:option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <form:label path="num_camas">Camas</form:label>
                      <form:select class="form-control" path="num_camas">
                      	<form:option value ="-1" selected="selected">Nº camas</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                      </form:select>
                    </div>
					<div class="form-group">
                      <form:label path="capacidad">Capacidad</form:label>
                      <form:select class="form-control" path="capacidad">
                      <form:option value ="-1" selected="selected">Nº ocupantes</form:option>
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="4">4</form:option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <form:label path="area">Area</form:label>
                      <form:select class="form-control" path="area">
                      <form:option value ="-1" selected="selected">Area en m<sup>2</sup></form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="70">70</form:option>
                        <form:option value="100">100</form:option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <form:label path="precio_propiedad_minimo">Precio mínimo</form:label>
                      <form:select class="form-control" path="precio_propiedad_minimo">
                      	<form:option value ="-1" selected="selected">Precio mínimo</form:option>
                        <form:option value="10">10 €</form:option>
                        <form:option value="100">100 €</form:option>
                        <form:option value="500">500 €</form:option>
                        <form:option value="1000">1000€</form:option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <form:label path="precio_propiedad_maximo">Precio máximo</form:label>
                      <form:select class="form-control" path="precio_propiedad_maximo">
                      	<form:option value ="-1" selected="selected">Precio máximo</form:option>
                        <form:option value="2000">2.000 €</form:option>
                        <form:option value="1500">1.500 €</form:option>
                        <form:option value="1000">1.000 €</form:option>
                        <form:option value="500">500 €</form:option>
                      </form:select>
                    </div><!-- 
					<div class="form-group">
                      <label style="display: block;" for="servicios">Servicios</label>
                      <label class="checkbox-inline"><input type="checkbox" id="wifi" value="opcion_1"> WiFi</label>
					  <label class="checkbox-inline"><input type="checkbox" id="secador" value="opcion2"> Secador</label>
					  <label class="checkbox-inline"><input type="checkbox" id="cable" value="opcion_1"> Cable</label>
					  <label class="checkbox-inline"><input type="checkbox" id="jacuzzi" value="opcion_1"> Jacuzzi</label>
                    </div>-->
                <input type="submit" name="submit" value="Search" class="btn btn-primary btn-block">
              </form:form>
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