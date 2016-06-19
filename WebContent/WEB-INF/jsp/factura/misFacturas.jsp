<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de facturas">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Lista de Facturas</h1>
		<table class="table table-condensed">
			<tr>
				<th>Titulo</th>
				<th>Fecha Reserva</th>
				<th>Fecha Factura</th>
				<th>Precio Factura</th>
				<th>IVA</th>
				<th>Detalles</th>
			</tr>
			<c:forEach items="${listaFacturaReserva}" var="mapaFacturaReserva">
				<c:forEach items="${listaReservaPropiedad}" var="mapaReservaPropiedad">
					<c:set var="idFacturaReserva" value="${mapaFacturaReserva.value.id_reserva}"></c:set>
					<c:set var="idReservaPropiedad" value="${mapaReservaPropiedad.key.id_reserva}"></c:set>
					<c:choose>
						 <c:when test='${idFacturaReserva == idReservaPropiedad}'>
							<tr>
							<td class="linea">${mapaReservaPropiedad.value.titulo}</td>
							<td class="linea">${mapaReservaPropiedad.key.fecha_reserva}</td>
							<td class="linea">${mapaFacturaReserva.key.fecha_factura}</td>
							<td class="linea">${mapaFacturaReserva.key.precio_factura}</td>
							<td class="linea">${mapaFacturaReserva.key.iva}</td>
							<td class="linea"><a href="${pageContext.request.contextPath}/factura/single/${mapaFacturaReserva.key.id_factura}.html">VER FACTURA</a></td>
							</tr>
						</c:when>
					</c:choose>		
				</c:forEach>
			</c:forEach>
			</table>
		<a class="btn btn-primary" href="add.html">Afegeix Propiedad</a>
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
				        <h3>¿Desea eliminar factura?<input type="hidden" id="idPropiedad"></h3>
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