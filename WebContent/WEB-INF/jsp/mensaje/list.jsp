<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Lista de Mensajes">
	<jsp:body>
	<div class="page-content"> 
		<div class="content">
			<ul class="breadcrumb">
				<li><p>ESTÁS AQUÍ</p></li>
				<li><a href="${pageContext.request.contextPath}/mensaje/list.html" class="active">GESTIÓN DE MENSAJES</a> </li>
			</ul>
			<div class="page-title"><a href="${pageContext.request.contextPath}/gestiones/listGestiones.html" ><i class="icon-custom-left"></i></a>
				<h3>Mensajes - <span class="semi-bold">Listado de mensajes</span></h3>
			</div>
			<div class="row-fluid">
	        <div class="span12">
	          <div class="grid simple ">
	            <div class="grid-title">
	              <h4><span class="semi-bold">Mensajes</span></h4>
				  <span class="semi-bold pull-right"><button type="button" class="btn btn-info btn-sm btn-small" onClick="location.href='add.html'"><i class="fa fa-plus"></i>  Añadir mensaje</button></span>
	            </div>
	            <div class="grid-body ">
	              <table class="table table-hover table-condensed">
		<thead>
		<tr>
			<th style="width:15%">Id Mensaje</th>
			<th style="width:15%">Id Receptor</th>
			<th style="width:15%">Id Emisor</th>
			<th style="width:15%">Asunto</th>
			<th style="width:15%">Contenido</th>
			<th style="width:15%">Estado Vision</th>
			<th style="width:15%">Fecha Mensaje</th>
			<th style="width:13%">Editar</th>
	        <th style="width:13%">Borrar</th>
		</tr>
		</thead>
        <tbody>
		<c:forEach items="${mensajes}" var="mensaje">
			<tr>
				<td class="v-align-middle">${mensaje.id_mensaje}</td>
				<td class="v-align-middle">${mensaje.id_receptor}</td>
				<td class="v-align-middle">${mensaje.id_emisor}</td>
				<td class="v-align-middle">${mensaje.asunto}</td>
				<td class="v-align-middle">${mensaje.contenido}</td>
				<td class="v-align-middle">${mensaje.estado_vision}</td>
				<td class="v-align-middle">${mensaje.fecha_mensaje}</td>
				<td class="v-align-middle">
							<button type="button" class="btn btn-primary btn-sm btn-small" onClick="location.href='update/${mensaje.id_mensaje}.html'"><i class="fa fa-pencil"></i>  Editar</button>
						</td>
					 <td class="v-align-middle"><button type="button" onclick="pasarIdAModal(${mensaje.id_mensaje})" id="botonBorrar" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="fa fa-trash-o"></i>  Borrar</button>
						</td>
			</tr>
		</c:forEach>
	<div class="modal fade" id="borrar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">Confirmación de borrado</h4>
				      </div>
				      <div class="modal-body">
				        <h3>¿Desea eliminar el mensaje?<input type="hidden" id="idCosa"></h3>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				        <button type="button" class="btn btn-primary" onClick="borrarObjeto()" >Borrar</button>
				      </div>
				    </div>
				  </div>
				</div>
					</tbody>
					
	              </table>
	              <script>
				  function pasarIdAModal(entrada) {
					  $('#borrar').on('show.bs.modal', function (event) {
						  var modal = $(this)
						  modal.find('.modal-body input').val(entrada)
					  });
					};
					function borrarObjeto() {
						var idbor = document.getElementById("idCosa").value
						location.href='delete/' + idbor + '.html'
					};
				  </script>
				  
	            </div>
	          </div>
	        </div>
	      </div>
		</div>
	</div>
	</jsp:body>
</t:paginabasica>