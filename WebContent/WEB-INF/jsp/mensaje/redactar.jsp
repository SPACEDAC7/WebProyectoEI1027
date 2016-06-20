<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Detalles Mensaje">
<jsp:body>
 <div id="header" class="heading" style="background-image: url(../img/img01.jpg);">
      <div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1 col-sm-12">
            <div class="page-title">
              <h2>Nuevo Mensaje</p>
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
          	<form:form method="post" modelAttribute="mensaje">
		<table class="table table-condensed">
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_mensaje">ID. Mensaje</form:label></td>
				<td><form:input class="form-control input-md" path="id_mensaje" readonly="true" /></td>
				<td><form:errors style="color:#F44336"  path="id_mensaje" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_emisor"> Emisor </form:label></td>
				<td><form:input class="form-control input-md" path="id_emisor" /></td>
				<td><form:errors style="color:#F44336" path="id_emisor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_receptor">Receptor </form:label></td>
				<td><form:select class="form-control" path="id_receptor" >
					<form:option value="" selected="selected">Seleccione nick de receptor</form:option>
					<form:option value="1">Administrador</form:option>
					<form:option value="2">david</form:option>
					<form:option value="3">israel</form:option>
					<form:option value="4">pablo</form:option>
					<form:option value="5">enrique</form:option>
					<form:option value="6">oscar</form:option>
					<form:option value="7">paco</form:option>
					<form:option value="8">almudena</form:option>
					<form:option value="9">mery</form:option>
					</form:select></td>
				<td><form:errors style="color:#F44336" path="id_receptor" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="asunto">Asunto</form:label></td>
				<td><form:input class="form-control input-md" path="asunto" /></td>
				<td><form:errors style="color:#F44336" path="asunto" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="contenido">Contenido </form:label></td>
				<td><form:input class="form-control input-md" path="contenido" /></td>
				<td><form:errors style="color:#F44336" path="contenido" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label class="col-md-3 col-xs-5 control-label" path="estado_vision">Estado Vision</form:label></td>
				<td><form:input value="1" class="form-control input-md" path="estado_vision" /></td>
				<td><form:errors style="color:#F44336" path="estado_vision" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Enviar" /></td>
 				<td><a href="${pageContext.request.contextPath}/mensaje/list.html"><input class="btn btn-default btn-cons" type="button" value="Cancelar"></a>
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