<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de reservas">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Lista de Peticiones</h1>
	<table class="table table-condensed sortable">
			<tr>
				<th>Titulo Propiedad</th>
				<th>Fecha Reserva</th>
				<th>Fecha de Entrada</th>
				<th>Fecha de Salida</th>
				<th>Precio Reserva</th>
				<th>Aceptar</th>
				<th>Rechazar</th>
			</tr>
			<c:forEach items="${listaReservaPropiedades}" var="mapReservasPropiedad">
				<tr>
					<td class="linea">${mapReservasPropiedad.value.titulo}</td>
					<td class="linea">${mapReservasPropiedad.key.fecha_reserva}</td>
					<td class="linea">${mapReservasPropiedad.key.fecha_checkin}</td>
					<td class="linea">${mapReservasPropiedad.key.fecha_checkout}</td>
					<td class="linea">${mapReservasPropiedad.key.precio_reserva}</td>
					<td class="linea"><a class="btn btn-primary" href="../aceptar/${mapReservasPropiedad.key.id_reserva}.html">Aceptar Reserva</a></td>
					<td><button type="button" onclick="pasarIdPropiedadAModal(${mapReservasPropiedad.key.id_reserva})" id="botonBorrar" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="fa fa-trash-o"></i>  Rechazar Reserva</button></td>
				
				</tr>
			</c:forEach>
			</table>

		<a class="btn btn-danger" href="${pageContext.request.contextPath}/cabecera/inicio.html"> Volver al inicio</a>
		</div>
		
		
		<div class="modal fade" id="borrar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Confirmación de borrado</h4>
				      </div>
				      <div class="modal-body">
				        <h3>¿Seguro que desea rechazar la reserva?<input type="hidden" id="idPropiedad"></h3>
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
						location.href='../rechazar/' + idpropiedad + '.html'
					};
				  </script>

</jsp:body>
</t:paginabasica>