<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:paginabasica title="Detalles Propiedad">
	<jsp:body>
 <!-- inicio:header -->
    <div id="header" class="heading" style="background-image: url(../../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>${propiedad.titulo}</p>
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
          <div class="col-md-12">
            <div class="row">
              <div class="col-md-12 single-post">
                <ul id="myTab" class="nav nav-tabs nav-justified">
                  <li class="active"><a href="#detail" data-toggle="tab"><i class="fa fa-university"></i> Detalles de la propiedad</a></li>
                  <li><a href="#location" data-toggle="tab"><i class="fa fa-paper-plane-o"></i> Localización y dueño de la propiedad</a></li>
                  <li><a href="#puntuacion"  data-toggle="tab"> <i class="fa fa-star"></i> Puntuación de la propiedad</a></li>
                </ul>

                <div id="myTabContent" class="tab-content">
                  <div class="tab-pane fade in active" id="detail">
                    <div class="row">
                      <div class="col-md-12">
                        <div id="slider-property" class="carousel slide" data-ride="carousel">
                          <ol class="carousel-indicators">
                            <c:set var="num" value="0"></c:set>
                            <c:forEach items="${imagenes}" var="imagen">
                             <c:choose>
                            	<c:when test='${num == 0 }'>
                            		<li data-target="#slider-property" data-slide-to="${num}" class="active">
                             	</c:when>
                            	<c:otherwise>
                            		<li data-target="#slider-property" data-slide-to="${num}" class="">
                             	</c:otherwise>
                            </c:choose>
                              <img src="${imagen.referencia}" alt="">
                            </li>
                           	<c:set var="num" value="${num + 1}"></c:set>
                            </c:forEach>
                          </ol>
                          <div class="carousel-inner">
                           <c:set var="num" value="0"></c:set>
                           <c:forEach items="${imagenes}" var="im"> 
                            <c:choose>
                            	<c:when test='${num == 0 }'>
                            		<div class="item active">
                            	</c:when>
                            	<c:otherwise>
                            		<div class="item">
                            	</c:otherwise>
                            </c:choose>
                              <img src="${im.referencia}" alt="">
                              <c:set var="num" value="${num + 1}"></c:set>
                            </div>
                            </c:forEach>
                          </div>
                          <a class="left carousel-control" href="#slider-property" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                          </a>
                          <a class="right carousel-control" href="#slider-property" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                          </a>
                        </div>
                        <div>
                        <a class="btn btn-success btn-lg btn-block destacado" href="${pageContext.request.contextPath}/reserva/reservar/${propiedad.id_propiedad}.html"> RESERVAR ESTA PROPIEDAD</a>
                        </div>
                         <h3>Descripción de la propiedad</h3>
                        <p>${propiedad.descripcion}</p>
                        
                        <h3>Detalles de la propiedad</h3>
                        <table class="table table-bordered">
                          <tr>
                            <td><strong>Precio diario</strong></td>
                            <td>${propiedad.precio_propiedad}</td>
                          </tr>
                          <tr>
                            <td><strong>Tipo de porpiedad</strong></td>
                            <td>${propiedad.tipo}</td>
                          </tr>
                          <tr>
                            <td><strong>Localidad</strong></td>
                            <td>${direccion.localidad}</td>
                          </tr>
                          <tr>
                            <td><strong>Numero de Habitaciones</strong></td>
                            <td>${propiedad.num_habitaciones}</td>
                          </tr>
                          <tr>
                            <td><strong>Numero de Camas</strong></td>
                            <td>${propiedad.num_camas}</td>
                          </tr>
                          <tr>
                            <td><strong>Area</strong></td>
                            <td>${propiedad.area}  m<sup>2</sup> </td>
                          </tr>
                        </table>
                        <h3>Servicios</h3>
                        <div class="row">
                          <div class="col-md-4 col-sm-4">
                            <ul style="list-style:none">
                            	<c:forEach items="${servicios}" var="servicio">
	                              <li><i class="fa fa-check"></i> ${servicio.nombreServicio}</li>
	                              </c:forEach>
                            </ul>
                          </div>    
                        </div>
                      </div>
                    </div>

                    
                  </div>
                  <!-- break -->
                  <div class="tab-pane fade" id="location">
                    <div class="row">
                      <div class="col-md-12">
                        <div id="map-property"></div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <h3>Contact Agent</h3>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6 col-sm-6">
                        <div class="team-container team-dark">
                          <div class="team-image">
                            <img src="../../img/team01.jpg" alt="the team - mikha realestate theme">
                          </div>
                          <div class="team-description">
                            <h3>${usuarioPropiedad.nombre} ${usuarioPropiedad.apellido }</h3>
                            <i class="fa fa-mobile"></i> Numero de telefono : ${usuarioPropiedad.telefono }<br>
                            <i class="fa fa-print"></i> Email : ${usuarioPropiedad.email}</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua.</p>
                            <div class="team-social">
                              <span><a href="#" title="Twitter" rel="tooltip" data-placement="top"><i class="fa fa-twitter"></i></a></span>
                              <span><a href="#" title="Facebook" rel="tooltip" data-placement="top"><i class="fa fa-facebook"></i></a></span>
                              <span><a href="#" title="Google Plus" rel="tooltip" data-placement="top"><i class="fa fa-google-plus"></i></a></span>
                              <span><a href="#" title="Email" rel="tooltip" data-placement="top"><i class="fa fa-envelope"></i></a></span> 
                              <span><a href="#" title="LinkedIn" rel="tooltip" data-placement="top"><i class="fa fa-linkedin"></i></a></span> 
                            </div>                       
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6 col-sm-6">
                        <form>
                          <div class="form-group">
                            <label for="name">Nombre</label>
                            <input type="text" class="form-control input-lg" placeholder="Introducir nombre : ">
                          </div>
                          <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control input-lg" placeholder="Introducir email : ">
                          </div>
                          <div class="form-group">
                            <label for="telp">Telefono</label>
                            <input type="text" class="form-control input-lg" placeholder="Introducir numero de telefono: ">
                          </div>
                          <div class="form-group">
                            <label for="message">Mensaje</label>
                            <textarea class="form-control input-lg" rows="7" placeholder="Mensaje : "></textarea>
                          </div>
                          <div class="form-group">
                            <input type="submit" name="submit" value="Send Message" class="btn btn-primary btn-lg">
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                   <div class="tab-pane fade" id="puntuacion">
                    <div class="row">
                      <div class="col-md-12">
                      	<h2>Puntuaciones</h2>
                      	<table class="table table-condensed sortable">
                      		<tr>
	                      		<th>Usuario</th>
	                      		<th>Puntuacion</th>
	                      		<th>Comentario</th>
	                      		<th>Ver Respuestas</th>
	                      		<th>Añadir Puntuacion</th>
                      		</tr>
                      		<c:forEach items="${listaPuntuaciones}" var="mapaPuntuacionUsuario">
                      			<tr>
                      				<td class="linea">${mapaPuntuacionUsuario.value.nombre}</td>
                      				<td class="linea">${mapaPuntuacionUsuario.key.valor_puntuacion}</td>
                      				<td class="linea">${mapaPuntuacionUsuario.key.comentario}</td>
                      				<td><button onClick="location.href='respuestaPuntuacion/listarPuntuacion/${mapaPuntuacionUsuario.key.id_puntuacion}.html'" type="button" class="btn btn-primary btn-sm btn-small"> Respuestas</button></td>
                      				<td><button onClick="location.href='respuestaPuntuacion/add/${mapaPuntuacionUsuario.key.id_puntuacion}.html'" type="button" class="btn btn-primary btn-sm btn-small"> Añadir Puntuación</button></td>
                      			</tr>
                      		</c:forEach>
                      		</table>
                      </div>
                    </div>
                   </div>
                  
                </div>
              </div>
            </div>
          </div>
            
          <!-- fin:article -->
          
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