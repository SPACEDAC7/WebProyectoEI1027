<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de propiedades">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Bandeja de Salida</h1>
		<table class="table table-condensed">
			<tr>
				<th>Nombre Emisor</th>
				<th>Email Emisor</th>
				<th>Asunto</th>
				<th>Fecha de recepción</th>
				<th>Ver contenido</th>
				<th>Eliminar</th>
			</tr>
			<c:forEach items="${listaMensajeReceptor}" var="mapaMensajeReceptor">
				<tr>
					<td class="linea">${mapaMensajeReceptor.value.nombre}</td>
					<td class="linea">${mapaMensajeReceptor.value.email}</td>
					<td class="linea">${mapaMensajeReceptor.key.asunto}</td>
					<td class="linea">${mapaMensajeReceptor.key.fecha_mensaje}</td>
					<td class="linea"><a href="${pageContext.request.contextPath}/mensaje/single/${mapaMensajeReceptor.key.id_mensaje}&${mapaMensajeReceptor.value.id_usuario}.html">VER CONTENIDO</a></td>
					<td><button type="button" onclick="pasarIdPropiedadAModal(${mapaMensajeReceptor.key.id_mensaje})" id="botonBorrar" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="fa fa-trash-o"></i>  Borrar</button></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="add.html">Redactar</a>
		<a class="btn btn-danger" href="${pageContext.request.contextPath}/"> Volver al inicio</a>
		</div>
		
		
		<div class="modal fade" id="borrar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Confirmación de borrado</h4>
				      </div>
				      <div class="modal-body">
				        <h3>¿Desea eliminar el mensaje?<input type="hidden" id="idPropiedad"></h3>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				        <button type="button" class="btn btn-primary" onClick="borrarPropiedad()" >Borrar</button>
				        <!-- onClick="location.href='delete/${factura.id_factura}.html'" -->
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
						location.href='delete/' + idpropiedad + '.html'
					};
				  </script>
		
		
	</jsp:body>
</t:paginabasica>