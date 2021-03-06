<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de propiedades">
<jsp:body>
	<div style="margin-bottom:20px" class="container">
	<h1>Lista de Propiedades</h1>
		<table class="table table-condensed sortable">
			<tr>
				<th>Titulo</th>
				<th>Precio</th>
				<th>Calle</th>
				<th>Localidad</th>
				<th>Ver propiedad</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>
			<c:forEach items="${listaPropiedadesDirecciones}" var="mapaPropiedadDireccion">
				<tr>
					<td class="linea">${mapaPropiedadDireccion.key.titulo}</td>
					<td class="linea">${mapaPropiedadDireccion.key.precio_propiedad}</td>
					<td class="linea">${mapaPropiedadDireccion.value.calle}</td>
					<td class="linea">${mapaPropiedadDireccion.value.localidad}</td>
					<td class="linea"><a href="${pageContext.request.contextPath}/propiedad/single/${mapaPropiedadDireccion.key.id_propiedad}.html">VER PROPIEDAD</a></td>
					<td><button onClick="location.href='updatePropietario/${mapaPropiedadDireccion.key.id_propiedad}.html'" type="button" class="btn btn-primary btn-sm btn-small" ><i class="fa fa-pencil"></i>  Editar</button>
					<td><button type="button" onclick="pasarIdPropiedadAModal(${mapaPropiedadDireccion.key.id_propiedad})" id="botonBorrar" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="fa fa-trash-o"></i>  Borrar</button></td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/propiedad/anadirPropiedadPropietario.html">A&ntilde;adir Propiedad</a>
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
				        <h3>¿Desea eliminar la propiedad?<input type="hidden" id="idPropiedad"></h3>
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
						location.href='delete/' + idpropiedad + '.html'
					};
				  </script>
		
		
	</jsp:body>
</t:paginabasica>