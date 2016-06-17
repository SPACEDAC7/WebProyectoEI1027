<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado de facturas">
	<jsp:body>
		<div class="page-content"> 
		<div class="content">
			<ul class="breadcrumb">
				<li><p>ESTÁS AQUÍ</p></li>
				<li><a href="${pageContext.request.contextPath}/factura/list.html" class="active">GESTIÓN DE FACTURAS</a> </li>
			</ul>
			<div class="page-title"><a href="${pageContext.request.contextPath}/gestiones/listGestiones.html" ><i class="icon-custom-left"></i></a>
				<h3>Facturas - <span class="semi-bold">Listado de facturas</span></h3>
			</div>
			<div class="row-fluid">
	        <div class="span12">
	          <div class="grid simple ">
	            <div class="grid-title">
	              <h4><span class="semi-bold">Facturas</span></h4>
				  <span class="semi-bold pull-right"><button type="button" class="btn btn-info btn-sm btn-small" onClick="location.href='add.html'"><i class="fa fa-plus"></i>  Añadir factura</button></span>
	            </div>
	            <div class="grid-body ">
	              <table class="table table-hover table-condensed">
	                <thead>
	                  <tr>
	                    <th style="width:15%">Id factura</th>
	                    <th style="width:15%">Id reserva</th>
	                    <th style="width:15%" data-hide="phone,tablet">Fecha factura</th>
	                    <th style="width:15%">Precio factura</th>
	                    <th style="width:14%" data-hide="phone,tablet">I.V.A.</th>
	                    <th style="width:13%">Editar</th>
	                    <th style="width:13%">Borrar</th>
	                  </tr>
	                </thead>
	                <tbody>
	                  <c:forEach items="${facturas}" var="factura">
				<tr>
					<td class="v-align-middle">${factura.id_factura}</td>
					<td class="v-align-middle">${factura.id_reserva}</td>
					<td class="v-align-middle">${factura.fecha_factura}</td>
					<td class="v-align-middle">${factura.precio_factura}</td>
					<td class="v-align-middle">${factura.iva}</td>
					<td class="v-align-middle">
							<button type="button" class="btn btn-primary btn-sm btn-small" onClick="location.href='update/${factura.id_factura}.html'"><i class="fa fa-pencil"></i>  Editar</button>
						</td>
	                    <td class="v-align-middle">
							<button type="button" class="btn btn-danger btn-sm btn-small" data-toggle="modal" data-target="#borrar"><i class="fa fa-trash-o"></i>  Borrar</button>
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
				        <h3>¿Desea eliminar la factura ${factura.id_factura}?</h3>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				        <button type="button" class="btn btn-primary" onClick="location.href='delete/${factura.id_factura}.html'">Borrar</button>
				      </div>
				    </div>
				  </div>
				</div>
					</tbody>
	              </table>
				  
	            </div>
	          </div>
	        </div>
	      </div>
		</div>
	</div>
	</jsp:body>
</t:paginabasica>