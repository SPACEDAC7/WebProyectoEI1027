<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Nosotros">
<jsp:body>
<div id="header" class="heading" style="background-image: url(../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Sobre nosotros</p>
            </div>
            <ol class="breadcrumb">
              <li><a href="${pageContext.request.contextPath}/cabecera/inicio.html">Inicio</a></li>
              <li class="active">Sobre nosotros</li>
            </ol>
          </div>
        </div>
      </div>
    </div>
    <!-- fin:header -->

    <!-- inicio:content -->
    <div id="content">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="blog-container">
              <div class="blog-content">
                <div class="blog-image" style="background-image: url(../img/img16.jpg);"></div>
                <div class="blog-title">
                  <h2>Nuesta historia</h2>
                  <h3>...empezando desde abajo</h3>
                </div>

                <div class="blog-text">
                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus quis lectus metus, at posuere neque. Sed pharetra nibh eget orci convallis at posuere leo convallis. Sed blandit augue vitae augue scelerisque bibendum. Vivamus sit amet libero turpis, non venenatis urna. In blandit, odio convallis suscipit venenatis, ante ipsum cursus augue.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus quis lectus metus, at posuere neque. Sed pharetra nibh eget orci convallis at posuere leo convallis.Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus quis lectus metus, at posuere neque. Sed pharetra nibh eget orci convallis at posuere leo convallis. Sed blandit augue vitae augue scelerisque bibendum.</p>
                </div>

                <div class="blog-title">
                  <h2>Nuestro equipo</h2>
                  <h3>...los mejores agentes mobiliarios </h3>
                </div>

                <div class="the-team">
                  <div class="row container-realestate">
                    <div class="col-md-4">
                      <div class="team-container">
                        <div class="team-image">
                          <img src="../img/team01.jpg" alt="the team - mikha realestate theme">
                        </div>
                        <div class="team-description">
                          <h3>David Albalate <small>Chief Executive Officer</small></h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                          tempor incididunt ut labore et dolore magna aliqua.</p>
                          <div class="team-social">
                            <span><a href="#" title="Twitter" rel="tooltip" data-placement="top"><i class="fa fa-twitter"></i></a></span>
                            <span><a href="#" title="Facebook" rel="tooltip" data-placement="top"><i class="fa fa-facebook"></i></a></span>
                            <span><a href="#" title="Google Plus" rel="tooltip" data-placement="top"><i class="fa fa-google-plus"></i></a></span>
                            <span><a href="#" title="Instagram" rel="tooltip" data-placement="top"><i class="fa fa-instagram"></i></a></span>
                            <span><a href="#" title="LinkedIn" rel="tooltip" data-placement="top"><i class="fa fa-linkedin"></i></a></span> 
                          </div>                       
                        </div>
                      </div>
                    </div>
                    <!-- break -->
                    <div class="col-md-4">
                      <div class="team-container team-dark">
                        <div class="team-image">
                          <img src="../img/team02.jpg" alt="the team - mikha realestate theme">
                        </div>
                        <div class="team-description">
                          <h3>Carlos Mollón <small>Chief Marketing Officer</small></h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                          tempor incididunt ut labore et dolore magna aliqua.</p>
                          <div class="team-social">
                            <span><a href="#" title="Twitter" rel="tooltip" data-placement="top"><i class="fa fa-twitter"></i></a></span>
                            <span><a href="#" title="Facebook" rel="tooltip" data-placement="top"><i class="fa fa-facebook"></i></a></span>
                            <span><a href="#" title="Google Plus" rel="tooltip" data-placement="top"><i class="fa fa-google-plus"></i></a></span>
                            <span><a href="#" title="LinkedIn" rel="tooltip" data-placement="top"><i class="fa fa-linkedin"></i></a></span>
                            <span><a href="#" title="Email" rel="tooltip" data-placement="top"><i class="fa fa-envelope"></i></a></span> 
                          </div>                       
                        </div>
                      </div>
                    </div>
                    <!-- break -->
                    <div class="col-md-4">
                      <div class="team-container">
                        <div class="team-image">
                          <img src="../img/team03.jpg" alt="the team - mikha realestate theme">
                        </div>
                        <div class="team-description">
                          <h3>Israel López <small>Chief Financial Officer</small></h3>
                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                          tempor incididunt ut labore et dolore magna aliqua.</p>
                          <div class="team-social">
                            <span><a href="#" title="Twitter" rel="tooltip" data-placement="top"><i class="fa fa-twitter"></i></a></span>
                            <span><a href="#" title="Facebook" rel="tooltip" data-placement="top"><i class="fa fa-facebook"></i></a></span>
                            <span><a href="#" title="Google Plus" rel="tooltip" data-placement="top"><i class="fa fa-google-plus"></i></a></span>
                            <span><a href="#" title="Instagram" rel="tooltip" data-placement="top"><i class="fa fa-instagram"></i></a></span>
                            <span><a href="#" title="LinkedIn" rel="tooltip" data-placement="top"><i class="fa fa-linkedin"></i></a></span> 
                          </div>                       
                        </div>
                      </div>
                    </div>
                    <!-- break -->
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- fin:content -->
</jsp:body>
</t:paginabasica>