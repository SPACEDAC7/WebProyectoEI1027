<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<c:set var="rol" scope="request" value='${session.getAttribute("rol")}' />
<t:paginabasica title="Perfil de usuario">
	<jsp:body>
		<div id="service">
<div class="container">
      <div class="row">
        <div class="col-md-8 toppad" >   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"> Perfil de  ${usuario.nombre} ${usuario.apellido}</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="${usuario.url_imagen_perfil}" class="img-circle img-responsive"> </div>
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Email:</td>
                        <td>${usuario.email}</td>
                      </tr>
                      <tr>
                        <td>NIF:</td>
                        <td>${usuario.nif}</td>
                      </tr>
                      <tr>
                        <td>Telefono</td>
                        <td>${usuario.telefono}</td>
                      </tr>
                        <tr>
                        <td>Direccion</td>
                        <td>C/  ${direccion.calle}  ${direccion.numero}<br>
                        ${direccion.codigo_postal}, ${direccion.localidad} <br>
                        ${direccion.provincia}</td>
                      </tr>
                                           
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i> Mensajes</a>
                        <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i> Editar perfil</a>
                            <button type="button" onclick="pasarIdPropiedadAModal(${usuario.id_usuario})" id="botonBorrar" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="glyphicon glyphicon-remove"></i> Eliminar usuario</button>
                        </span>
				</div>
				<div class="modal fade" id="borrar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Confirmación de borrado</h4>
				      </div>
				      <div class="modal-body">
				        <h3>¿Esta seguro de eliminar su cuenta de usuario?<input type="hidden" id="idPropiedad"></h3>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				        <button type="button" class="btn btn-primary" onClick="borrarPropiedad()" >Borrar</button>
				      </div>
				    </div>
				  </div>
				</div>
				<script>
				  function pasarIdPropiedadAModal(idPropiedad) {
					  $('#borrar').on('show.bs.modal', function (event) {
						  var modal = $(this)
						  modal.find('.modal-body input').val(idPropiedad)
					  });
					};
					function borrarPropiedad() {
						var idpropiedad = document.getElementById("idPropiedad").value
						location.href='../delete/' + idpropiedad + '.html'
					};
				  </script>
          </div>
        </div>
		<div class="col-md-4 toppad" >   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Gestión de cuenta</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div  align="center">
                	<c:choose>
                		<c:when test='${rol == "inquilino"}'>
                			<a href="${pageContext.request.contextPath}/reserva/misReservas.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Consultar tus reservas</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Bandeja de entrada</button></a><hr style="margin:0px 0px 0px 0px">
		                    <a href="${pageContext.request.contextPath}/mensaje/bandejaSalida.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Bandeja de salida</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href="${pageContext.request.contextPath}/buscador/list.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Buscar una propiedad</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href="${pageContext.request.contextPath}/factura/misFacturas.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Consultar tus facturas</button></a>
                		</c:when>
                		<c:when test='${rol == "propietario"}'>
                			<a href="${pageContext.request.contextPath}/propiedad/misPropiedades.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Consultar tus propiedades</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href="${pageContext.request.contextPath}/propiedad/anadirPropiedadPropietario.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Añadir una propiedad</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href="${pageContext.request.contextPath}/mensaje/bandejaEntrada.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Bandeja de entrada</button></a><hr style="margin:0px 0px 0px 0px">
		                    <a href="${pageContext.request.contextPath}/mensaje/bandejaSalida.html"><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Bandeja de salida</button></a><hr style="margin:0px 0px 0px 0px">
		                 	<a href=""><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Consultar las reservas / periodo</button></a><hr style="margin:0px 0px 0px 0px">
		              		<a href=""><button style="border-style:none" type="button" class="btn btn-default btn-lg btn-block">Consultar tus puntuaciones</button></a>
                		</c:when>
                	</c:choose>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
	</div>
	</jsp:body>
</t:paginabasica>