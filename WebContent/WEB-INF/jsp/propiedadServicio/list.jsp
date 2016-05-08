<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Propiedad Servicio</title>
</head>
<body>
	<h1>Llista de Propiedad Servicio</h1>
	<table>
		<tr>
			<th>Id. Propiedad</th>
			<th>Id. Servicio</th>
		</tr>
		<c:forEach items="${propiedadesServicios}" var="propiedadServicio">
			<tr>
				<td class="linea">${propiedadServicio.id_propiedad}</td>
				<td class="linea">${propiedadServicio.id_servicio}</td>
				<td><a href="update/${propiedadServicio.id_propiedad}&${propiedadServicio.id_servicio}.html">Edita</a>
				<td><a href="delete/${propiedadServicio.id_propiedad}&${propiedadServicio.id_servicio}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix Propiedad Servicio</a>
	<a href="${pageContext.request.contextPath}"> Volver al inicio</a>
</body>
</html>