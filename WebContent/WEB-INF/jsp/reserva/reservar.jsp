<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Reservar">
<jsp:body>
 <div id="header" class="heading" style="background-image: url(../../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Nueva Reserva</p>
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
          <form:form method="post" modelAttribute="reserva">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaCheckIn">Fecha Check In</form:label></td>
				<td><form:input class="form-control input-md datepicker" path="fechaCheckIn"/></td>
				<td><form:errors style="color:#F44336" path="fechaCheckIn" cssClass="error"/></td>
				
				<td><form:input type="hidden" class="form-control input-md" path="id_reserva" readonly="true" /></td>
				<td><form:errors style="color:#F44336" path="id_reserva" cssClass="error"/></td>
			
				<td><form:input type="hidden" class="form-control input-md datepicker" path="fechaReserva" readonly="true"/></td>
				<td><form:errors style="color:#F44336" path="fechaReserva" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="fechaCheckOut">Fecha Check Out</form:label></td>
				<td><form:input class="form-control input-md datepicker" path="fechaCheckOut" /></td>
				<td><form:errors style="color:#F44336" path="fechaCheckOut" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="precio_reserva">Precio Diario Reserva</form:label></td>
				<td><form:input class="form-control input-md" path="precio_reserva" /></td>
				<td><form:errors style="color:#F44336" path="precio_reserva" cssClass="error"/></td>
			
				<td><form:input type="hidden" value="pendiente" class="form-control input-md" path="estado" /></td>
				<td><form:errors style="color:#F44336" path="estado" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Reservar" /></td>
 				<td><a href="${pageContext.request.contextPath}/reserva/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
 				</td>
			</tr>
		</table>
	</form:form>
          <!-- fin:article -->
          
        </div>
      </div>
    </div>
    <!-- fin:content -->
    
    	</jsp:body>
</t:paginabasica>
<<t:datepicker></t:datepicker>
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