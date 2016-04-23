<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listaCredenciales.css">
<title>Gestionar Credenciales</title>
</head>
<body>
	<h1>Llista de Nadadors</h1>
	<table>
		<tr>
			<th>NumFederat</th>
			<th>Nom</th>
			<th>Pais</th>
			<th>Edat</th>
			<th>Sexe</th>
		</tr>
		<c:forEach items="${nadadors}" var="nadador">
			<tr>
				<td class="linea">${nadador.numFederat}</td>
				<td class="linea">${nadador.nom}</td>
				<td class="linea">${nadador.pais}</td>
				<td class="linea">${nadador.edat}</td>
				<td class="linea">${nadador.sexe}</td>
				<td><a href="update/${nadador.nom}.html">Edita</a>
				<td><a href="delete/${nadador.nom}.html">Esborra</a>
			</tr>
		</c:forEach>
	</table>
	<a href="add.html">Afegeix nadador</a>
</body>
</html>