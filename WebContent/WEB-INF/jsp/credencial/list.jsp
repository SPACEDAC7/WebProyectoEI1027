<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:paginabasica title="Listado credenciales">
	<jsp:body>
		<h1>Llista de Credenciales</h1>
		<table class="table table-condensed">
			<tr>
				<th>Id Cedencial</th>
				<th>Nick usuario</th>
				<th>Password</th>
				<th>Rol</th>
			</tr>
			<c:forEach items="${credenciales}" var="credencial">
				<tr>
					<td class="linea">${credencial.id_credencial}</td>
					<td class="linea">${credencial.nick_usuario}</td>
					<td class="linea">${credencial.password}</td>
					<td class="linea">${credencial.rol}</td>
					<td><a href="update/${credencial.id_credencial}.html">Edita</a>
					<td><a href="delete/${credencial.id_credencial}.html">Esborra</a>
				</tr>
			</c:forEach>
		</table>
		<a style="color: #5090C0;" href="add.html" class="btn btn-default" role="button">Añadir credencial</a>
	</jsp:body>
</t:paginabasica>