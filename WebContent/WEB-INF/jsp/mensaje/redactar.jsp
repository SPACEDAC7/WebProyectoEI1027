<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td><form:label class="col-md-3 col-xs-5 control-label" path="id_receptor">Receptor </form:label></td>
				<td><form:select class="form-control" path="id_receptor" >
					<form:option value="" selected="selected">Seleccione nick de receptor</form:option>
					<c:forEach items="${usuarios}" var="listausuarios">
						<form:option value="${listausuarios.id_usuario}">${listausuarios.nombre}</form:option>
					</c:forEach>
					</form:select></td>
				<td><form:errors style="color:#F44336" path="id_receptor" cssClass="error"/></td>
				
				<td><form:input type="hidden" class="form-control input-md" path="id_mensaje" readonly="true" /></td>
				<td><form:errors style="color:#F44336"  path="id_mensaje" cssClass="error"/></td>
			
				<td><form:input type="hidden" class="form-control input-md" path="id_emisor" /></td>
				<td><form:errors style="color:#F44336" path="id_emisor" cssClass="error"/></td>
							
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
			
				<td><form:input type="hidden" value="1" class="form-control input-md" path="estado_vision" /></td>
				<td><form:errors style="color:#F44336" path="estado_vision" cssClass="error"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-cons" type="submit" value="Enviar" /></td>
			</tr>
		</table>
		<a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"><input class="btn btn-danger btn-cons" type="button" value="Volver a la bandeja de entrada"></a>
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