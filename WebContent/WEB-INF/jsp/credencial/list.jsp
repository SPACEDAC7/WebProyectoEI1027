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
					<td><a class="btn btn-primary btn-block" href="update/${credencial.id_credencial}.html">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
										Editar</a>
					<td><a class="btn btn-danger" href="delete/${credencial.id_credencial}.html"><span style="margin-right:5px" class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										Borrar</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="add.html" class="btn btn-primary" role="button">Añadir credencial</a>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/gestiones/listGestiones.html"> Volver al inicio</a>
	</jsp:body>
</t:paginabasica>