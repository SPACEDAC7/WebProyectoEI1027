<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
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
                  <li><a href="#location" data-toggle="tab"><i class="fa fa-paper-plane-o"></i> Localización de la propiedad</a></li>
                </ul>

                <div id="myTabContent" class="tab-content">
                  <div class="tab-pane fade in active" id="detail">
                    <div class="row">
                      <div class="col-md-12">
                        <div id="slider-property" class="carousel slide" data-ride="carousel">
                          <ol class="carousel-indicators">
                            <li data-target="#slider-property" data-slide-to="0" class="">
                              <img src="../../img/img02.jpg" alt="">
                            </li>
                            <li data-target="#slider-property" data-slide-to="1" class="active">
                              <img src="../../img/img03.jpg" alt="">
                            </li>
                            <li data-target="#slider-property" data-slide-to="2">
                              <img src="../../img/img04.jpg" alt="">
                            </li>
                          </ol>
                          <div class="carousel-inner">
                            <div class="item">
                              <img src="../../img/img02.jpg" alt="">
                            </div>
                            <div class="item active">
                              <img src="../../img/img03.jpg" alt="">
                            </div>
                            <div class="item">
                              <img src="../../img/img04.jpg" alt="">
                            </div>
                          </div>
                          <a class="left carousel-control" href="#slider-property" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                          </a>
                          <a class="right carousel-control" href="#slider-property" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                          </a>
                        </div>
                         <h3>Descripción de la porpiedad</h3>
                        <p>${propiedad.descripcion}</p>
                        
                        <h3>Detalles de la propiedad</h3>
                        <table class="table table-bordered">
                          <tr>
                            <td><strong>Price</strong></td>
                            <td>${propiedad.precio_propiedad}</td>
                          </tr>
                          <tr>
                            <td><strong>Type</strong></td>
                            <td>${propiedad.tipo}</td>
                          </tr>
                          <tr>
                            <td><strong>Contract</strong></td>
                            <td>Sale</td>
                          </tr>
                          <tr>
                            <td><strong>Location</strong></td>
                            <td>${direccion.localidad}</td>
                          </tr>
                          <tr>
                            <td><strong>Habitaciones</strong></td>
                            <td>${propiedad.num_habitaciones}</td>
                          </tr>
                          <tr>
                            <td><strong>Camas</strong></td>
                            <td>${propiedad.num_camas}</td>
                          </tr>
                          <tr>
                            <td><strong>Area</strong></td>
                            <td>${propiedad.area}  m<sup>2</sup> </td>
                          </tr>
                        </table>
                        <h3>Property Features</h3>
                        <div class="row">
                          <div class="col-md-4 col-sm-4">
                            <ul>
                              <li><i class="fa fa-check"></i> Air conditioning</li>
                              <li><i class="fa fa-check"></i> Balcony</li>
                              <li><i class="fa fa-times"></i> Bedding</li>
                              <li><i class="fa fa-check"></i> Cable TV</li>
                              <li><i class="fa fa-times"></i> Cleaning after exit</li>
                              <li><i class="fa fa-check"></i> Cofee pot</li>
                              <li><i class="fa fa-check"></i> Computer</li>
                              <li><i class="fa fa-times"></i> Cot</li>
                            </ul>
                          </div>
                          <div class="col-md-4 col-sm-4">
                            <ul>
                              <li><i class="fa fa-check"></i> Internet</li>
                              <li><i class="fa fa-times"></i> Iron</li>
                              <li><i class="fa fa-check"></i> Juicer</li>
                              <li><i class="fa fa-times"></i> Lift</li>
                              <li><i class="fa fa-times"></i> Microwave</li>
                              <li><i class="fa fa-check"></i> Oven</li>
                              <li><i class="fa fa-times"></i> Parking</li>
                              <li><i class="fa fa-times"></i> Parquet</li>
                            </ul>
                          </div>
                          <div class="col-md-4 col-sm-4">
                            <ul>
                              <li><i class="fa fa-times"></i> Radio</li>
                              <li><i class="fa fa-check"></i> Roof terrace</li>
                              <li><i class="fa fa-times"></i> Smoking allowed</li>
                              <li><i class="fa fa-check"></i> Terrace</li>
                              <li><i class="fa fa-times"></i> Toaster</li>
                              <li><i class="fa fa-check"></i> Towelwes</li>
                              <li><i class="fa fa-check"></i> Use of pool</li>
                              <li><i class="fa fa-check"></i> Video</li>
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
                            <label for="name">Name</label>
                            <input type="text" class="form-control input-lg" placeholder="Enter name : ">
                          </div>
                          <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control input-lg" placeholder="Enter email : ">
                          </div>
                          <div class="form-group">
                            <label for="telp">Telp.</label>
                            <input type="text" class="form-control input-lg" placeholder="Enter phone number : ">
                          </div>
                          <div class="form-group">
                            <label for="message">Message</label>
                            <textarea class="form-control input-lg" rows="7" placeholder="Type a message : "></textarea>
                          </div>
                          <div class="form-group">
                            <input type="submit" name="submit" value="Send Message" class="btn btn-primary btn-lg">
                          </div>
                        </form>
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