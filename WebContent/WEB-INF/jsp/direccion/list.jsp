<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado de direcciones">
<jsp:body>
	<h1>Llista de Direcciones</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id Direccion</th>
			<th>Calle</th>
			<th>Numero</th>
			<th>C.P.</th>
			<th>Localidad</th>
			<th>Provincia</th>
		</tr>
		<c:forEach items="${direcciones}" var="direccion">
			<tr>
				<td class="linea">${direccion.id_direccion}</td>
				<td class="linea">${direccion.calle}</td>
				<td class="linea">${direccion.numero}</td>
				<td class="linea">${direccion.codigo_postal}</td>
				<td class="linea">${direccion.localidad}</td>
				<td class="linea">${direccion.provincia}</td>
				<td><a class="btn btn-primary btn-block" href="update/${direccion.id_direccion}.html">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										Editar</a>
				<td><a class="btn btn-danger" href="delete/${direccion.id_direccion}.html"><span style="margin-right:5px" class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										Borrar</a></td>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix Direccion</a>
	<a class="btn btn-default" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	
	</jsp:body>
</t:paginabasica>