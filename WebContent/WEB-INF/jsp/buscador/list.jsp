<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Propiedades">
<jsp:body>
  <div id="header" class="heading" style="background-image: url(../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Propiedades</h2>
            </div>
            <ol class="breadcrumb">
              <li><a href="#">Inicio</a></li>
              <li><a href="#">Propiedades</a></li>
            </ol>
          </div>
        </div>
      </div>
    </div>
  <body id="top">
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
							<span>${propiedad.precio_propiedad}<small>/semana</small></span>
						  </div>
						  <div class="property-status">
							<span>Alquiler</span>
						  </div>
						  <div class="property-features">
							<span><i class="fa fa-home"></i> ${propiedad.area} m2</span>
							<span><i class="fa fa-hdd-o"></i> ${propiedad.num_camas} Camas</span>
							<span><i class="fa fa-male"></i> ${propiedad.capacidad} Personas</span>
							<span><i class="fa fa-building-o"></i> ${propiedad.num_habitaciones} Habitaciones</span>
							<span><i class="fa fa-car"></i> 2 Garages</span>
						  </div>
						</div>
						<div class="property-text">
						  <h3><a href="#">${propiedad.titulo}</a> <small>${propiedad.area}</small></h3>
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

          <!-- begin:sidebar -->
          <div class="col-md-3 col-md-pull-9 sidebar">
            <div class="widget widget-white">
              <div class="widget-header">
                <h3>BUSCAR</h3>
              </div>    
              <form "${pageContext.request.contextPath}/buscador/list.html" method="get" role="form" class="advance-search">
                <div class="form-group">
                  <label for="location">País</label>
                  <select class="form-control">
                    <option>Miami</option>
                    <option>Doral</option>
                    <option>Little Havana</option>
                    <option>Perrine</option>
                  </select>
                </div>
				<div class="form-group">
                  <label for="location">Area</label>
                  <select class="form-control">
                    <option>Miami</option>
                    <option>Doral</option>
                    <option>Little Havana</option>
                    <option>Perrine</option>
                  </select>
                </div>
				<div class="form-group">
                  <label for="beds">Habitaciones</label>
                  <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
				<div class="form-group">
                  <label for="baths">Camas</label>
                  <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
				<div class="form-group">
                  <label for="baths">Capacidad</label>
                  <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="type">Tipo</label>
                  <select class="form-control">
                    <option>Office</option>
                    <option>Shop</option>
                    <option>Villa</option>
                    <option>Apartment</option>
                    <option>Single Family Home</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="min-price">Precio mínimo</label>
                  <input type="text" class="form-control" placeholder="Max Area">
                </div>
                <div class="form-group">
                  <label for="min-price">Precio máximo</label>
                  <input type="text" class="form-control" placeholder="Max Area">
                </div>
                <input type="submit" name="submit" value="Search" class="btn btn-primary btn-block">
              </form>
            </div>
            <!-- break -->
          </div>
          <!-- end:sidebar -->
          
        </div>
      </div>
    </div>
	</body>
</jsp:body>
</t:paginabasica>