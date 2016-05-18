<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado de imagenes">
	<jsp:body>
	<h1>Llista de Imagenes</h1>
	<table class="table table-condensed">
		<tr>
			<th>Id Imagen</th>
			<th>Id Propiedad</th>
			<th>Pie de foto</th>
			<th>Referencia</th>
		</tr>
		<c:forEach items="${imagenes}" var="imagen">
			<tr>
				<td class="linea">${imagen.id_imagen}</td>
				<td class="linea">${imagen.id_propiedad}</td>
				<td class="linea">${imagen.pie_foto}</td>
				<td class="linea">${imagen.referencia}</td>
				<td><a href="update/${imagen.id_imagen}.html">Edita</a>
				<td><a href="delete/${imagen.id_imagen}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="add.html">Afegeix imagen</a>
	<a class="btn btn-danger" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>