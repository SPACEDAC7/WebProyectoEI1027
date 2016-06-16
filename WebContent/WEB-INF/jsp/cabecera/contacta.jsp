<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Contacta">
<jsp:body>
    <!-- inicio:header -->
    <div id="header" class="heading" style="background-image: url(../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Contacto</p>
            </div>
            <ol class="breadcrumb">
              <li><a href="#">Inicio</a></li>
              <li class="active">Contacto</li>
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
              <div class="blog-content">
                <div id="map"></div>
                <div class="blog-title">
                  <h2>Por favor, no lo dude y póngase en contacto con nosotros.</h2>
                  <h3>...Si quiere ponerse en contacto con nosotros, rellene el siguiente formulario.</h3>
                </div>

                <div class="blog-text contact">
                  <div class="row">
                    <div class="col-md-8 col-sm-7">
                      <form>
                        <div class="form-group">
                          <label for="name" class="sr-only">Name</label>
                          <input type="text" class="form-control" placeholder="Enter your name">
                        </div>
                        <div class="form-group">
                          <label for="email" class="sr-only">Email</label>
                          <input type="email" class="form-control" placeholder="Enter your email">
                        </div>
                        <div class="form-group">
                          <label for="subject" class="sr-only">Subject</label>
                          <input type="text" class="form-control" placeholder="Enter subject">
                        </div>
                        <div class="form-group">
                          <label for="name" class="sr-only">Message</label>
                          <textarea class="form-control" rows="5" placeholder="Enter your name"></textarea>
                        </div>
                        <div class="form-group">
                          <button type="submit" name="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> Send Message</button>
                        </div>
                      </form><br>
                    </div>
                    <div class="col-md-4 col-sm-5">
                      <address>
                        <strong>EasyRent, la mejor opción.</strong><br>
						Av. de Vicent Sos Baynat s/n 12071<br>
						<br>
						Telp. : +62-345678910<br>
						Email : aluji@uji.es
                        http://www.visual-designs.net <br>
                        <abbr title="Phone">Telp.</abbr> (0274) 441-5000
                      </address>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- fin:content -->
    <!-- fin:partner -->
</jsp:body>
</t:paginabasica>